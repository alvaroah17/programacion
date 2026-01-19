package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionPequenia;
import com.juego.habilidades.mago.BolaFuego;
import com.juego.habilidades.mago.PalmadaIgnea;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Mago implements Clase{
    Estadistica estadisticas;

    public Mago (Estadistica estadisticas){
        this.estadisticas=estadisticas;
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList <Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new BolaFuego());
        listaHabilidades.add(new PalmadaIgnea());
        listaHabilidades.add(new CuracionPequenia());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+90);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
    }
}
