package com.juego.presentacion;

import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Menu {
    public void Menu(){
        GestorPersonajes gestorPersonajes=new GestorPersonajes();
        int opcionMenu=0;
        do {
        Scanner sc=new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("===========|MENÙ PRINCIPAL|==========");
        System.out.println("=====================================");
        System.out.println("1) Jugar");
        System.out.println("2) Crear Personaje");
        System.out.println("3) Salir");
        System.out.printf("Elige una opción :");
        opcionMenu= sc.nextInt();
            switch (opcionMenu){
                case 1:
                    /// LISTA DE PERSONAJES CREADOS
                    System.out.println("|=======================================================|");
                    System.out.println("| ELIGE LOS PERSONAJES PARA JUGAR ENTRE LOS DISPONIBLES |");
                    System.out.println("|=======================================================|");

                    for (int i = 0; i < gestorPersonajes.getPersonajes().size(); i++) {
                        System.out.printf("| %-53s |%n","|"+(i+1)+") "+gestorPersonajes.getPersonajes().get(i).getNombre()+" es un "+gestorPersonajes.getPersonajes().get(i).getRaza().getNombreRaza()+"-"+gestorPersonajes.getPersonajes().get(i).getClase().getNombreClase());
                        System.out.println("|-------------------------------------------------------|");
                    }
                    /// ELIGE JUGADOR 1
                    System.out.println("=====================");
                    System.out.println(" | Elige Jugador 1 |");
                    System.out.println("=====================");
                    Personaje eleccionPersonaje1=null;
                    do {
                        System.out.printf("Nº de personaje : ");
                        int numeroEleccionPersonaje = sc.nextInt();
                        if (numeroEleccionPersonaje>=1 && numeroEleccionPersonaje<=gestorPersonajes.getPersonajes().size()){
                            eleccionPersonaje1=gestorPersonajes.getPersonajes().get(numeroEleccionPersonaje-1);
                        }
                        else {
                            System.out.println("NO existe ese personaje que estás intentando seleccionar. Selecciona uno que este en la lista");
                            eleccionPersonaje1=null;
                        }
                        }while (eleccionPersonaje1==null);

                    /// ELIGE JUGADOR 2
                    System.out.println("=====================");
                    System.out.println(" | Elige Jugador 2 |");
                    System.out.println("=====================");
                    Personaje eleccionPersonaje2=null;
                    do {
                        System.out.printf("Nº de personaje : ");
                        int numeroEleccionPersonaje = sc.nextInt();
                        if (numeroEleccionPersonaje>=1 && numeroEleccionPersonaje<=gestorPersonajes.getPersonajes().size()){
                            eleccionPersonaje2=gestorPersonajes.getPersonajes().get(numeroEleccionPersonaje-1);
                        }
                        else {
                            System.out.println("NO existe ese personaje que estás intentando seleccionar. Selecciona uno que este en la lista");
                            eleccionPersonaje2=null;
                        }
                    }while (eleccionPersonaje2==null);
                    Combate nuevoCombate=new Combate();
                    nuevoCombate.iniciarCombate(eleccionPersonaje1,eleccionPersonaje2);
                    break;

                case 2:
                    gestorPersonajes.crearNuevoPersonaje();
                    break;
                case 3:
                    break;

            }
        }while (opcionMenu<3 && opcionMenu>0);

    }

}
