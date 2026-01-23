package com.juego.razas;

import com.juego.modelo.Estadistica;

public class Enano implements Raza {
    private Estadistica estadisticas;
    private String nombreRaza;
    public Enano(){;
        this.nombreRaza="Enano";
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    @Override
    public void establecerEstadisticas(Estadistica estadisticas) {
        estadisticas.setVida(110);
        estadisticas.setVidaMaxima(110);
        estadisticas.setFuerza(7);
        estadisticas.setDestreza(4);
        estadisticas.setInteligencia(4);
    }
}
