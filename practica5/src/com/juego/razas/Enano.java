package com.juego.razas;

import com.juego.modelo.Estadistica;

public class Enano implements Raza {
    private Estadistica estadisticas;

    public Enano(){;
    }

    @Override
    public void establecerEstadisticas(Estadistica estadisticas) {
        estadisticas.setVida(110);
        estadisticas.setFuerza(7);
        estadisticas.setDestreza(4);
        estadisticas.setInteligencia(4);
    }
}
