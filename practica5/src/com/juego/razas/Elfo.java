package com.juego.razas;

import com.juego.modelo.Estadistica;

public class Elfo implements Raza{
    private Estadistica estadisticas;

    public Elfo(){
    }

    @Override
    public void establecerEstadisticas(Estadistica estadisticas) {
        estadisticas.setVida(90);
        estadisticas.setVidaMaxima(90);
        estadisticas.setFuerza(7);
        estadisticas.setDestreza(4);
        estadisticas.setInteligencia(4);
    }
}
