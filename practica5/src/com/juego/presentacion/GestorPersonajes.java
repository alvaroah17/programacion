package com.juego.presentacion;

import com.juego.clases.*;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPersonajes {
    private ArrayList <Personaje> personajes;

    public GestorPersonajes() {
        this.personajes = new ArrayList<>();
        this.personajes.add(Personaje1);
        this.personajes.add(Personaje2);
    }
    /// METODOS GET
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    /// PERSONAJES CREADOS PREDEFINIDOS
    Personaje Personaje1 = new Personaje("Sergio Mondrigón",new Enano(), new Sacerdote(), new Estadistica());
    Personaje Personaje2= new Personaje("Marco Palomo",new Elfo(), new Guerrero(), new Estadistica());
    ///FUNCION PARA CREAR PERSONAJE Y METERLO EN EL ARRAYLIST personajes
    public void crearNuevoPersonaje(){
        System.out.println("=====================================");
        System.out.println("=======|CREACIÓN DE PERSONAJE|=======");
        System.out.println("=====================================");
        Scanner sc=new Scanner(System.in);
        System.out.printf("- Introduce un nombre para tu personaje :");
        String nombre=sc.nextLine();
        System.out.println("- Selecciona una raza -");
        System.out.println("1) Humano");
        System.out.println("2) Elfo");
        System.out.println("3) Enano");
        int opcionRaza= sc.nextInt();
        Raza guardarRaza = null;
        switch (opcionRaza){
            case 1:
                guardarRaza= new Humano();
                break;
            case 2:
                guardarRaza=new Elfo();
                break;
            case 3:
                guardarRaza=new Enano();
                break;
            default:
                System.out.println("Al haber seleccionado una raza que no está se le ha asignado la Raza Enano");
                guardarRaza=new Enano();
        }
        System.out.println("Selecciona una Clase");
        System.out.println("1) Bardo");
        System.out.println("2) Druida");
        System.out.println("3) Guerrero");
        System.out.println("4) Mago");
        System.out.println("5) Monje");
        System.out.println("6) Paladín");
        System.out.println("7) Pícaro");
        System.out.println("8) Sacerdote");
        int opcionClase= sc.nextInt();
        Clase guardarClase=null;
        switch (opcionClase){
            case 1:
                guardarClase=new Bardo();
                break;
            case 2:
                guardarClase=new Druida();
                break;
            case 3:
                guardarClase=new Guerrero();
                break;
            case 4:
                guardarClase=new Mago();
                break;
            case 5:
                guardarClase=new Monje();
                break;
            case 6:
                guardarClase=new Paladin();
                break;
            case 7:
                guardarClase=new Picaro();
                break;
            case 8:
                guardarClase=new Sacerdote();
                break;
            default:
                System.out.println("Al haber seleccionado una Clase que no está se le ha asignado la Clase Sacerdote");
                guardarClase=new Sacerdote();
        }
        Estadistica estadisticas=new Estadistica();
        Personaje personajeCreado= new Personaje(nombre,guardarRaza , guardarClase, estadisticas);
        this.personajes.add(personajeCreado);
    }
}
