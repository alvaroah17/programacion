package com.juego.presentacion;

import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Presentacion {
    public void Menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("===========|MENÙ PRINCIPAL|==========");
        System.out.println("=====================================");
        System.out.println("1) Jugar");
        System.out.println("2) Crear Personaje");
        System.out.println("3) Salir");
        System.out.printf("Elige una opción :");
        int opcionMenu= sc.nextInt();
        GestorPersonajes gestorPersonajes=new GestorPersonajes();
        switch (opcionMenu){
            case 1:
                System.out.println("- Elige los Personajes para jugar entre los disponibles -");

                for (int i = 0; i < gestorPersonajes.getPersonajes().size(); i++) {
                    System.out.println((i+1)+" "+gestorPersonajes.getPersonajes().get(i).getNombre()+" es un "+gestorPersonajes.getPersonajes().get(i).getRaza().getNombreRaza()+"-"+gestorPersonajes.getPersonajes().get(i).getClase().getNombreClase());
                }
                /// ELIGE JUGADOR 1
                System.out.println("Elige Jugador 1");
                Personaje eleccionPersonaje1=null;
                do {
                    int numeroEleccionPersonaje = sc.nextInt();
                    switch (numeroEleccionPersonaje){
                        case 1:
                            eleccionPersonaje1=gestorPersonajes.getPersonajes().get(0);
                            break;
                        case 2:
                            eleccionPersonaje1=gestorPersonajes.getPersonajes().get(1);
                            break;
                        case 3:
                            if (gestorPersonajes.getPersonajes().size()>2){
                                gestorPersonajes.getPersonajes().get(2);
                            }
                            break;
                        case 4:
                            if (gestorPersonajes.getPersonajes().size()>3){
                                gestorPersonajes.getPersonajes().get(3);
                            }
                    }
                }while (eleccionPersonaje1==null);

                /// ELIGE JUGADOR 2
                Personaje eleccionPersonaje2=null;
                System.out.println("Elige Jugador 2");
                do {
                    int numeroEleccionPersonaje = sc.nextInt();
                    switch (numeroEleccionPersonaje){
                        case 1:
                            eleccionPersonaje2=gestorPersonajes.getPersonajes().get(0);
                            break;
                        case 2:
                            eleccionPersonaje2=gestorPersonajes.getPersonajes().get(1);
                            break;
                        case 3:
                            if (gestorPersonajes.getPersonajes().size()>2){
                                gestorPersonajes.getPersonajes().get(2);
                            }
                            break;
                        case 4:
                            if (gestorPersonajes.getPersonajes().size()>3){
                                gestorPersonajes.getPersonajes().get(3);
                            }
                    }
                }while (eleccionPersonaje2==null);
                Combate nuevoCombate=new Combate();
                nuevoCombate.iniciarCombate(eleccionPersonaje1,eleccionPersonaje2);
            case 2:
                gestorPersonajes.crearNuevoPersonaje();
                break;
            case 3:
                break;

        }
    }

}
