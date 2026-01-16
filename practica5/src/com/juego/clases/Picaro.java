package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public class Picaro implements Clase{
    Estadistica estadisticas;

    public Picaro (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {

    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+105);
        estadisticas.setDestreza(estadisticas.getDestreza()+3);
    }
}
