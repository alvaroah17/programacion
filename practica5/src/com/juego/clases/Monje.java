package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionGrande;
import com.juego.habilidades.monje.GolpePalma;
import com.juego.habilidades.monje.OndaChi;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Monje implements Clase{

    public Monje (){

    }


    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList <Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new GolpePalma());
        listaHabilidades.add(new OndaChi());
        listaHabilidades.add(new CuracionGrande());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+100);
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setDestreza(estadisticas.getDestreza()+1);
    }
}
