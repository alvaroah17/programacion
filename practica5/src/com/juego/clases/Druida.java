package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionMedia;
import com.juego.habilidades.druida.LlamadaTrueno;
import com.juego.habilidades.druida.ZarpazoSalvaje;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Druida implements Clase{

    public Druida (){

    }


    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new LlamadaTrueno());
        listaHabilidades.add(new ZarpazoSalvaje());
        listaHabilidades.add(new CuracionMedia());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+100);
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+1);
    }


}
