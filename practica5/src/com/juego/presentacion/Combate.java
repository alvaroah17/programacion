package com.juego.presentacion;

import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Combate {
    public Combate (){

    }
    public void iniciarCombate(Personaje jugador1, Personaje jugador2){
        /// MENSAJE DE INICIO DE COMBATE
        System.out.println("========================");
        System.out.println(" | INICIO DEL COMBATE |");
        System.out.println("========================");
        //----------------------------------------------------------------------------------------------------------
        do {
            /// MOSTRAR VIDA DE LOS 2 JUGADORES
            System.out.println("VIDA INICIAL DE LOS DOS JUGADORES ");
            System.out.println("================================================");
            System.out.println("JUGADOR 1");
            System.out.println("Eres un "+jugador1.getRaza().getNombreRaza()+"-"+jugador1.getClase().getNombreClase());
            System.out.println(jugador1.getNombre()+" "+jugador1.getEstadisticas().getVida()+"/"+ jugador1.getEstadisticas().getVidaMaxima()+"HP");
            System.out.println("-------------------------------------------------|");
            System.out.println("JUGADOR 2");
            System.out.println("Eres un "+jugador2.getRaza().getNombreRaza()+"-"+jugador2.getClase().getNombreClase());
            System.out.println(jugador2.getNombre()+" "+jugador2.getEstadisticas().getVida()+"/"+ jugador2.getEstadisticas().getVidaMaxima()+"HP");
            System.out.println("-------------------------------------------------|");
            //----------------------------------------------------------------------------------------------------------
            ///VARIABLE PARA COMPROBACION EN AMBOS TURNOS
            boolean sePuedeUsar;
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
                    System.out.println(i+") "+jugador1.getListaHabilidades().get(i).getNombre()+ " - "+jugador1.getListaHabilidades().get(i).getCantidadDaño()+" cura"+" | "+jugador1.getListaHabilidades().get(i).getUsos()+" usos");
                }
                else if (jugador1.getListaHabilidades().get(i).getTipo().equals("Daño")){
                    System.out.println(i+") "+jugador1.getListaHabilidades().get(i).getNombre()+ " - "+jugador1.getListaHabilidades().get(i).getCantidadDaño()+" daño"+" | "+jugador1.getListaHabilidades().get(i).getUsos()+" usos");
                }
            }
            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            do {
                System.out.print("- Elige una habilidad por su Indice :  ");
                ///ESCANER
                Scanner sc= new Scanner(System.in);
                int opcionElegidaJ1 = sc.nextInt();
                if (opcionElegidaJ1 <0 || opcionElegidaJ1>= jugador1.getListaHabilidades().size()){
                    System.out.println("| Opción NO válida |");
                    sePuedeUsar=false;
                }
                else {
                    sePuedeUsar=quedanUsos(jugador1,opcionElegidaJ1);
                    if (sePuedeUsar==false){
                        System.out.println("NO te quedan movimientos, elige otro");
                    }
                    else {
                        //RESTAMOS 1 USO DE LA HABILIDAD QUE ELIJAMOS LLAMANDO A LA FUNCION
                        jugador1.getListaHabilidades().get(opcionElegidaJ1).usarHabilidad();

                        switch (opcionElegidaJ1){
                            case 0:
                                jugador2.recibeDaño(jugador1.getListaHabilidades().get(0).getCantidadDaño());
                                break;
                            case 1:
                                jugador2.recibeDaño(jugador1.getListaHabilidades().get(1).getCantidadDaño());
                                break;
                            case 2:
                                jugador1.recibeCura(jugador1.getListaHabilidades().get(2).getCantidadDaño());
                                break;
                            // No necesitamos un "default" porque el índice que se introduce ya está comprobado con los if-else
                        }
                    }
                }
            }while (sePuedeUsar==false);
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
                    System.out.println(i+") "+jugador2.getListaHabilidades().get(i).getNombre()+ " - "+jugador2.getListaHabilidades().get(i).getCantidadDaño()+" cura"+" | "+jugador2.getListaHabilidades().get(i).getUsos()+" usos");
                }
                else if (jugador2.getListaHabilidades().get(i).getTipo().equals("Daño")){
                    System.out.println(i+") "+jugador2.getListaHabilidades().get(i).getNombre()+ " - "+jugador2.getListaHabilidades().get(i).getCantidadDaño()+" daño"+" | "+jugador2.getListaHabilidades().get(i).getUsos()+" usos");
                }
            }
            //----------------------------------------------------------------------------------------------------------
            do {
                System.out.println("- Elige una habilidad por su Indice ");
                //----------------------------------------------------------------------------------------------------------
                ///ESCANER
                Scanner sc = new Scanner(System.in);

                // |1| Leemos la opción del jugador
                int opcionElegidaJ2 = sc.nextInt();

                // |2| Comprobamos si la opción está dentro del rango de habilidades
                if (opcionElegidaJ2 < 0 || opcionElegidaJ2 >= jugador2.getListaHabilidades().size()) {
                    System.out.println("| Opción NO válida |");
                    sePuedeUsar = false; // el bucle sigue repitiendose
                }
                else {
                    // |3| Comprobamos si la habilidad tiene usos disponibles
                    sePuedeUsar = quedanUsos(jugador2, opcionElegidaJ2);

                    if (sePuedeUsar==false) { //Si la variable sePuedeUsar que coge el valor de la funcion "quedanUsos" es falsa porque sus usos sean <=0 imprime eso
                        // |4| Si no hay usos, avisamos y el bucle se repite
                        System.out.println("NO te quedan movimientos, elige otro");
                    }
                    else {
                        // |5| Si está correcto, restamos un uso
                        jugador2.getListaHabilidades().get(opcionElegidaJ2).usarHabilidad();
                        // |6| Ejecutamos la acción concreta según la habilidad
                        switch (opcionElegidaJ2){
                            case 0:
                                jugador1.recibeDaño(jugador2.getListaHabilidades().get(0).getCantidadDaño());
                                break;
                            case 1:
                                jugador1.recibeDaño(jugador2.getListaHabilidades().get(1).getCantidadDaño());
                                break;
                            case 2:
                                jugador2.recibeCura(jugador2.getListaHabilidades().get(2).getCantidadDaño());
                                break;
                            // No necesitamos un "default" porque el índice que se introduce ya está comprobado con los if-else
                        }
                    }
                }
                /// TERMINA TURNO JUGADOR 2
            } while (sePuedeUsar == false);

        }while (jugador1.getEstadisticas().getVida()>0 && jugador2.getEstadisticas().getVida()>0);
        if (jugador1.getEstadisticas().getVida()<=0){
            System.out.println("EL JUGADOR 1 HA MUERTO");
            System.out.println("¡¡FELICIDADES!! JUGADOR 2");
        }
        else {
            System.out.println("____________________________");
            System.out.println("|  EL JUGADOR 2 HA MUERTO  |");
            System.out.println("|__________________________|");
            System.out.println("| ¡¡FELICIDADES!! JUGADOR 1|");
            System.out.println("|__________________________|");
        }
    }
    public boolean quedanUsos (Personaje personaje, int eleccion){
        if(personaje.getListaHabilidades().get(eleccion).getUsos()<=0){
            return false;
        }
        return true;
    };

}
