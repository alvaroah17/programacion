package com.juego.presentacion;

import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Combate {
    public Combate (){

    }
    public void iniciarCombate(Personaje jugador1, Personaje jugador2){
        int vidaMaximaJ1 =jugador1.getEstadisticas().getVida();
        int vidaMaximaJ2 =jugador2.getEstadisticas().getVida();
        //----------------------------------------------------------------------------------------------------------
        /// MENSAJE DE INICIO DE COMBATE
        System.out.println("====================");
        System.out.println(" INICIO DEL COMBATE");
        System.out.println("====================");
        //----------------------------------------------------------------------------------------------------------
        do {
            /// MOSTRAR VIDA DE LOS 2 JUGADORES
            System.out.println("VIDA INICIAL DE LOS DOS JUGADORES ");
            System.out.println("--------------------------------------------------");
            System.out.println("JUGADOR 1");
            System.out.println(jugador1.getNombre()+" "+jugador1.getEstadisticas().getVida()+"/"+ vidaMaximaJ1);
            System.out.println("--------------------------------------------------");
            System.out.println("JUGADOR 2");
            System.out.println(jugador2.getNombre()+" "+jugador2.getEstadisticas().getVida()+"/"+ vidaMaximaJ2);
            System.out.println("--------------------------------------------------");
            //----------------------------------------------------------------------------------------------------------
            ///TURNO JUGADOR 1
            System.out.println("====================");
            System.out.println("  TURNO JUGADOR 1");
            System.out.println("====================");
            System.out.println("  - HABILIDADES - ");
            System.out.println("¿Que habilidad quieres usar?");
            // RECORRE ARRAYLIST HABILIDADES JUGADOR 1 Y IMPRIME LO QUE LE DIGAMOS
            for (int i = 0; i < jugador1.getListaHabilidades().size(); i++) {
                if (jugador1.getListaHabilidades().get(i).getTipo().equals("Curacion")){
                    System.out.println(i+") "+jugador1.getListaHabilidades().get(i).getNombre()+ " - "+jugador1.getListaHabilidades().get(i).getCantidadDaño()+" cura"+" - "+jugador1.getListaHabilidades().get(i).getUsos()+" usos");
                }
                else if (jugador1.getListaHabilidades().get(i).getTipo().equals("Daño")){
                    System.out.println(i+") "+jugador1.getListaHabilidades().get(i).getNombre()+ " - "+jugador1.getListaHabilidades().get(i).getCantidadDaño()+" daño"+" - "+jugador1.getListaHabilidades().get(i).getUsos()+" usos");
                }
            }
            //VARIABLE PARA COMPROBACION
            boolean sePuedeUsar;
            do {
                System.out.print("- Elige una habilidad por su Indice :  ");
                ///ESCANER
                Scanner sc= new Scanner(System.in);
                int opcionElegidaJ1 = sc.nextInt();
                sePuedeUsar=quedanUsos(jugador1,opcionElegidaJ1);
                //RESTAMOS 1 USO DE LA HABILIDAD QUE ELIJAMOS LLAMANDO A LA FUNCION
                jugador1.getListaHabilidades().get(opcionElegidaJ1).usarHabilidad();
                switch (opcionElegidaJ1){
                    case 0:
                        if (sePuedeUsar==true){
                            jugador2.recibeDaño(jugador1.getListaHabilidades().get(0).getCantidadDaño());
                        }
                        else {
                            System.out.println("NO te quedan movimientos, elige otro");
                        }
                        break;
                    case 1:
                        if (sePuedeUsar==true){
                            jugador2.recibeDaño(jugador1.getListaHabilidades().get(1).getCantidadDaño());
                        }
                        else {
                            System.out.println("NO te quedan movimientos, elige otro");
                        }
                        break;
                    case 2:
                        if (sePuedeUsar==true){
                            jugador2.recibeCura(jugador1.getListaHabilidades().get(2).getCantidadDaño());
                        }
                        else {
                            System.out.println("NO te quedan movimientos, elige otro");
                        }
                        break;
                    default:
                        System.out.println("| Opción NO válida | ");
                }
            }while (sePuedeUsar==false);

            //----------------------------------------------------------------------------------------------------------

            /// TERMINA TURNO JUGADOR 1
            ///----------------------------------------------------------------------------------------------------------
            /// TURNO JUGADOR 2
            System.out.println("====================");
            System.out.println("  TURNO JUGADOR 2");
            System.out.println("====================");
            System.out.println(" - HABILIDADES - ");
            System.out.println("¿Que habilidad quieres usar?");
            // RECORRE ARRAYLIST HABILIDADES JUGADOR 2 Y IMPRIME LO QUE LE DIGAMOS
            for (int i = 0; i < jugador2.getListaHabilidades().size(); i++) {
                if (jugador2.getListaHabilidades().get(i).getTipo().equals("Curacion")){
                    System.out.println(i+") "+jugador2.getListaHabilidades().get(i).getNombre()+ " - "+jugador2.getListaHabilidades().get(i).getCantidadDaño()+" cura"+" - "+jugador2.getListaHabilidades().get(i).getUsos()+" usos");
                }
                else if (jugador2.getListaHabilidades().get(i).getTipo().equals("Daño")){
                    System.out.println(i+") "+jugador2.getListaHabilidades().get(i).getNombre()+ " - "+jugador2.getListaHabilidades().get(i).getCantidadDaño()+" daño"+" - "+jugador2.getListaHabilidades().get(i).getUsos()+" usos");
                }
            }
            //----------------------------------------------------------------------------------------------------------
            do {
                System.out.println("- Elige una habilidad por su Indice ");
                //----------------------------------------------------------------------------------------------------------
                ///ESCANER
                Scanner sc = new Scanner(System.in);
                int opcionElegidaJ2 = sc.nextInt();
                sePuedeUsar=quedanUsos(jugador2,opcionElegidaJ2);
                //RESTAMOS 1 USO DE LA HABILIDAD QUE ELIJAMOS LLAMANDO A LA FUNCION
                jugador2.getListaHabilidades().get(opcionElegidaJ2).usarHabilidad();
                //----------------------------------------------------------------------------------------------------------
                switch (opcionElegidaJ2){
                    case 0:
                        if (sePuedeUsar==true){
                            jugador1.recibeDaño(jugador2.getListaHabilidades().get(0).getCantidadDaño());
                        }
                        else {
                            System.out.println("NO te quedan movimientos, elige otro");
                        }
                        break;
                    case 1:
                        if (sePuedeUsar==true){
                            jugador1.recibeDaño(jugador2.getListaHabilidades().get(1).getCantidadDaño());
                        }
                        else {
                            System.out.println("NO te quedan movimientos, elige otro");
                        }
                        break;
                    case 2:
                        if (sePuedeUsar==true){
                            jugador1.recibeCura(jugador2.getListaHabilidades().get(2).getCantidadDaño());
                        }
                        else {
                            System.out.println("NO te quedan movimientos, elige otro");
                        }
                        break;
                    default:
                        System.out.println("| Opción NO válida | ");
                }
                /// TERMINA TURNO JUGADOR 2
            }while (sePuedeUsar==false);

        }while (jugador1.getEstadisticas().getVida()>0 && jugador2.getEstadisticas().getVida()>0);
    }
    public boolean quedanUsos (Personaje personaje, int eleccion){
        if(personaje.getListaHabilidades().get(eleccion).getUsos()<=0){
            return false;
        }
        return true;
    };
}
