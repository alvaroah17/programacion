package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public class Sacerdote implements Clase{
    Estadistica estadisticas;

    public Sacerdote (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {

    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+95);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
    }
}
