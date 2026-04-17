package rpg.logic;
import rpg.dao.PersonajeDAO;
import rpg.exception.BDException;
import rpg.model.Habilidad;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.LoggerCustom;

import java.util.Map;
import java.util.Scanner;

public class MotorCombate {

    private PersonajeDAO personajeDAO;
    private Scanner sc;

    public MotorCombate(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
        this.sc = new Scanner(System.in);
    }

    // Calcula ataque total: fuerza base raza + bonificador_ataque de items
    private int calcularAtaque(Personaje personaje) {
        int ataque = personaje.getRaza().getBonificadorFuerza();
        for (Map.Entry<Item, Integer> entry : personaje.getInventario().entrySet()) {
            ataque += entry.getKey().getBonificador_ataque();
        }
        return ataque;
    }

    // Calcula defensa total: suma bonificador_defensa de todos los items
    private int calcularDefensa(Personaje personaje) {
        int defensa = 0;
        for (Map.Entry<Item, Integer> entry : personaje.getInventario().entrySet()) {
            defensa += entry.getKey().getBonificador_defensa();
        }
        return defensa;
    }

    private void turnoPersonaje(Personaje atacante, Personaje defensor, int[] usos, int ataqueTotal, int defensaEnemigo) {
        boolean hayUsosDisponibles = false;
        for (int numUsos : usos) {
            if (numUsos > 0) {
                hayUsosDisponibles = true;
                break;
            }
        }

        if (!hayUsosDisponibles) {
            // Ataque básico fallback
            int daño = Math.max(0, ataqueTotal - (defensaEnemigo / 2));
            defensor.setVida_actual(defensor.getVida_actual() - daño);
            System.out.println(atacante.getNombre() + " usa ATAQUE BÁSICO → " + daño + " daño a " + defensor.getNombre());
            return;
        }

        System.out.println("Habilidades disponibles:");
        for (int i = 0; i < atacante.getHablidades().size(); i++) {
            Habilidad h = atacante.getHablidades().get(i);
            System.out.println(i + ") " + h.getNombre()
                    + " | Daño base: " + h.getDañoBase()
                    + " | Usos restantes: " + usos[i]);
        }
        System.out.println(atacante.getHablidades().size() + ") Ataque básico (ATQ total - DEF/2)");
        System.out.print("Elige opción: ");

        boolean accionValida = false;
        while (!accionValida) {
            int eleccion = sc.nextInt();

            if (eleccion == atacante.getHablidades().size()) {
                // Ataque básico elegido manualmente
                int daño = Math.max(0, ataqueTotal - (defensaEnemigo / 2));
                defensor.setVida_actual(defensor.getVida_actual() - daño);
                System.out.println(atacante.getNombre() + " usa ATAQUE BÁSICO → " + daño + " daño a " + defensor.getNombre());
                accionValida = true;

            } else if (eleccion >= 0 && eleccion < atacante.getHablidades().size()) {
                if (usos[eleccion] <= 0) {
                    System.out.println("¡Sin usos! Elige otra opción:");
                } else {
                    Habilidad h = atacante.getHablidades().get(eleccion);
                    int daño = Math.max(0, h.getDañoBase() - (defensaEnemigo / 2));
                    defensor.setVida_actual(defensor.getVida_actual() - daño);
                    usos[eleccion]--;
                    System.out.println(atacante.getNombre() + " usa " + h.getNombre()
                            + " → " + daño + " daño a " + defensor.getNombre()
                            + " (usos restantes: " + usos[eleccion] + ")");
                    accionValida = true;
                }
            } else {
                System.out.println("Opción no válida. Elige otra:");
            }
        }
    }

    public void iniciarCombate(Personaje jugador1, Personaje jugador2) throws BDException {

        int ataqueJ1 = calcularAtaque(jugador1);
        int defensaJ1 = calcularDefensa(jugador1);
        int ataqueJ2 = calcularAtaque(jugador2);
        int defensaJ2 = calcularDefensa(jugador2);

        // Usos temporales en memoria
        int[] usosJ1 = new int[jugador1.getHablidades().size()];
        int[] usosJ2 = new int[jugador2.getHablidades().size()];
        for (int i = 0; i < jugador1.getHablidades().size(); i++)
            usosJ1[i] = jugador1.getHablidades().get(i).getUsosMaximos();
        for (int i = 0; i < jugador2.getHablidades().size(); i++)
            usosJ2[i] = jugador2.getHablidades().get(i).getUsosMaximos();

        LoggerCustom.escribirLog("COMBATE INICIADO: " + jugador1.getNombre()
                + " vs " + jugador2.getNombre());

        System.out.println("========================");
        System.out.println(" | INICIO DEL COMBATE |");
        System.out.println("========================");
        System.out.println(jugador1.getNombre() + " | ATQ: " + ataqueJ1 + " | DEF: " + defensaJ1);
        System.out.println(jugador2.getNombre() + " | ATQ: " + ataqueJ2 + " | DEF: " + defensaJ2);

        while (jugador1.getVida_actual() > 0 && jugador2.getVida_actual() > 0) {

            // ---- TURNO JUGADOR 1 ----
            System.out.println("\n====================");
            System.out.println("  TURNO: " + jugador1.getNombre());
            System.out.println("====================");
            System.out.println(jugador1.getNombre() + " HP: " + jugador1.getVida_actual()
                    + " | " + jugador2.getNombre() + " HP: " + jugador2.getVida_actual());

            turnoPersonaje(jugador1, jugador2, usosJ1, ataqueJ1, defensaJ2);

            if (jugador2.getVida_actual() <= 0) break;

            // ---- TURNO JUGADOR 2 ----
            System.out.println("\n====================");
            System.out.println("  TURNO: " + jugador2.getNombre());
            System.out.println("====================");
            System.out.println(jugador1.getNombre() + " HP: " + jugador1.getVida_actual()
                    + " | " + jugador2.getNombre() + " HP: " + jugador2.getVida_actual());

            turnoPersonaje(jugador2, jugador1, usosJ2, ataqueJ2, defensaJ1);
        }

        // ---- FIN DEL COMBATE ----
        //Vemos quien ha ganao
        Personaje ganador;
        if (jugador1.getVida_actual() > 0) {
            ganador = jugador1;
        } else {
            ganador = jugador2;
        }

        //Vemos quien ha perdio
        Personaje perdedor;
        if (ganador == jugador1) {
            perdedor = jugador2;
        } else {
            perdedor = jugador1;
        }

        int oroRobado = perdedor.getOro() / 5; // 20%
        ganador.setOro(ganador.getOro() + oroRobado);
        perdedor.setOro(perdedor.getOro() - oroRobado);

        personajeDAO.actualizarOroBD(ganador);
        personajeDAO.actualizarOroBD(perdedor);

        System.out.println("\n================================");
        System.out.println("   El jugador  "+perdedor.getNombre()+" ha muerto :(");
        System.out.println("  ¡¡GANA " + ganador.getNombre() + "!!");
        System.out.println("  Le roba " + oroRobado + " monedas de oro al perdedor "+perdedor.getNombre());
        System.out.println("================================");

        LoggerCustom.escribirLog("COMBATE FINALIZADO: Ganador: " + ganador.getNombre()
                + " | Perdedor: " + perdedor.getNombre()
                + " | Oro robado: " + oroRobado);
    }
}
