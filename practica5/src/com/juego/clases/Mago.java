package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public class Mago implements Clase{
    Estadistica estadisticas;

    public Mago (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {

    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+90);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
    }
}
