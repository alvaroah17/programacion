package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.exception.BDException;
import rpg.exception.FondosInsuficientesException;
import rpg.model.Personaje;
import rpg.utils.LoggerCustom;

import java.util.Scanner;

public class Menu {
    private GestionMundo gestionMundo;
    private PersonajeDAO personajeDAO;
    private MotorCombate motorCombate;
    private Scanner sc;

    public Menu() throws BDException, FondosInsuficientesException {
        this.gestionMundo = new GestionMundo();
        this.personajeDAO = new PersonajeDAO();
        this.motorCombate = new MotorCombate(personajeDAO);
        this.sc = new Scanner(System.in);
        menu();
    }

    public void menu() throws BDException, FondosInsuficientesException {
        int opcionMenu = -1;
        do {
            System.out.println("=====================================");
            System.out.println("=======|  MENÚ PRINCIPAL  |=========");
            System.out.println("=====================================");
            System.out.println("1) Tienda");
            System.out.println("2) Viajar a otra ciudad");
            System.out.println("3) Cobrar Impuestos");
            System.out.println("4) Crear Personaje");
            System.out.println("5) Combatir");
            System.out.println("6) Estadísticas");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1:
                        gestionMundo.tienda();
                    break;
                case 2:
                    gestionMundo.viajarCiudad();
                    break;
                case 3:
                    gestionMundo.cobroImpuestos(personajeDAO.getPersonajes());
                    System.out.println("Impuestos cobrados correctamente.");
                    break;
                case 4:
                    gestionMundo.crearPersonaje();
                    break;
                case 5:
                    elegirCombate();
                    break;
                case 6:
                    gestionMundo.mostrarEstadisticas();
                    break;
                case 0:
                    System.out.println("Saliendo del juego. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Elige entre 0 y 6.");
            }
        } while (opcionMenu != 0);
    }

    private void elegirCombate() throws BDException {
        if (personajeDAO.getPersonajes().size() < 2) {
            System.out.println("Necesitas al menos 2 personajes para combatir.");
            return;
        }

        /// LISTA DE PERSONAJES DISPONIBLES
        System.out.println("|=======================================================|");
        System.out.println("| ELIGE LOS PERSONAJES PARA JUGAR ENTRE LOS DISPONIBLES |");
        System.out.println("|=======================================================|");
        for (int i = 0; i < personajeDAO.getPersonajes().size(); i++) {
            System.out.printf("| %-53s |%n", (i + 1) + ") " + personajeDAO.getPersonajes().get(i).getNombre()
                    + " es un " + personajeDAO.getPersonajes().get(i).getRaza().getNombre()
                    + "-" + personajeDAO.getPersonajes().get(i).getClase().getNombre());
            System.out.println("|-------------------------------------------------------|");
        }

        /// ELIGE JUGADOR 1
        System.out.println("=====================");
        System.out.println(" | Elige Jugador 1 |");
        System.out.println("=====================");
        Personaje eleccionPersonaje1 = null;
        do {
            System.out.print("Nº de personaje: ");
            int numeroEleccion = sc.nextInt();
            if (numeroEleccion >= 1 && numeroEleccion <= personajeDAO.getPersonajes().size()) {
                eleccionPersonaje1 = personajeDAO.getPersonajes().get(numeroEleccion - 1);
            } else {
                System.out.println("NO existe ese personaje. Selecciona uno que esté en la lista.");
                eleccionPersonaje1 = null;
            }
        } while (eleccionPersonaje1 == null);

        /// ELIGE JUGADOR 2
        System.out.println("=====================");
        System.out.println(" | Elige Jugador 2 |");
        System.out.println("=====================");
        Personaje eleccionPersonaje2 = null;
        do {
            System.out.print("Nº de personaje: ");
            int numeroEleccion = sc.nextInt();
            if (numeroEleccion >= 1 && numeroEleccion <= personajeDAO.getPersonajes().size()) {
                if (personajeDAO.getPersonajes().get(numeroEleccion - 1) == eleccionPersonaje1) {
                    System.out.println("No puedes elegir el mismo personaje dos veces.");
                    eleccionPersonaje2 = null;
                } else {
                    eleccionPersonaje2 = personajeDAO.getPersonajes().get(numeroEleccion - 1);
                }
            } else {
                System.out.println("NO existe ese personaje. Selecciona uno que esté en la lista.");
                eleccionPersonaje2 = null;
            }
        } while (eleccionPersonaje2 == null);

        /// INICIAMOS EL COMBATE CON LOS DOS PERSONAJES ELEGIDOS
        motorCombate.iniciarCombate(eleccionPersonaje1, eleccionPersonaje2);
    }
}
