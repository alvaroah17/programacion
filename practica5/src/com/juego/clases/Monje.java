package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public class Monje implements Clase{
    Estadistica estadisticas;

    public Monje (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {

    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+100);
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setDestreza(estadisticas.getDestreza()+1);
    }
}
