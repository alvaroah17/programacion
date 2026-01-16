package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public class Guerrero implements Clase{
    Estadistica estadisticas;

    public Guerrero (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {

    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+120);
        estadisticas.setFuerza(estadisticas.getFuerza()+3);
    }
}
