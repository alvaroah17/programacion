package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionMedia;
import com.juego.habilidades.paladin.Estocada;
import com.juego.habilidades.paladin.JabalinaCrucificadora;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Paladin implements Clase{

    public Paladin (Estadistica estadisticas){
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Estocada());
        listaHabilidades.add(new JabalinaCrucificadora());
        listaHabilidades.add(new CuracionMedia());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+115);
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+1);
    }
}
