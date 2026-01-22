package com.juego.razas;

import com.juego.modelo.Estadistica;

public class Humano implements Raza{

    private Estadistica estadisticas;

    public Humano(){

    }

    @Override
    public void establecerEstadisticas(Estadistica estadisticas) {
        estadisticas.setVida(100);
        estadisticas.setVidaMaxima(100);
        estadisticas.setFuerza(5);
        estadisticas.setDestreza(5);
        estadisticas.setInteligencia(5);
    }
}
