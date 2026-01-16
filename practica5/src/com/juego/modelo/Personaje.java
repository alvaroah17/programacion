package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.habilidades.Habilidades;
import com.juego.razas.Raza;

import java.util.ArrayList;
/// ATRIBUTOS
public class Personaje {
    private String nombre;
    private Clase clase;
    private Raza raza;
    private Estadistica estadisticas;
    private ArrayList<Habilidades> listaHabilidades;
}
