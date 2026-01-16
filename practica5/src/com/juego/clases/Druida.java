package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public class Druida implements Clase{
    Estadistica estadisticas;

    public Druida (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {

    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+100);
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+1);
    }
}
