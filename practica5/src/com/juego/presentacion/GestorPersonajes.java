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
        personajes.add(PersonajePrueba1);
        personajes.add(PersonajePrueba2);
    }

    /// PERSONAJES CREADOS PREDEFINIDOS
    Personaje PersonajePrueba1 = new Personaje("PersonajePrueba1",new Enano(), new Sacerdote(), new Estadistica());
    Personaje PersonajePrueba2= new Personaje("PersonajePrueba1",new Elfo(), new Guerrero(), new Estadistica());
    ///FUNCION PARA CREAR PERSONAJE Y METERLO EN EL ARRAYLIST personajes
    public void crearNuevoPersonaje(String nombre, Raza raza, Clase clase, Estadistica estadisticas){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un nombre");
        nombre=sc.nextLine();
        System.out.println("Selecciona una raza");
        System.out.println("1) Humano");
        System.out.println("2) Elfo");
        System.out.println("3) Enano");
        int opcionRaza= sc.nextInt();
        switch (opcionRaza){
            case 1:
                raza= new Humano();
                break;
            case 2:
                raza=new Elfo();
                break;
            case 3:
                raza=new Enano();
                break;
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
        switch (opcionClase){
            case 1:
                clase=new Bardo();
                break;
            case 2:
                clase=new Druida();
                break;
            case 3:
                clase=new Guerrero();
                break;
            case 4:
                clase=new Mago();
                break;
            case 5:
                clase=new Monje();
                break;
            case 6:
                clase=new Paladin();
                break;
            case 7:
                clase=new Picaro();
                break;
            case 8:
                clase=new Sacerdote();
                break;
        }
        estadisticas=new Estadistica();
    }
}
