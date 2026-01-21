package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.bardo.SinfoniaEstridente;
import com.juego.habilidades.bardo.TajoArmonico;
import com.juego.habilidades.curacion.CuracionGrande;
import com.juego.habilidades.curacion.CuracionPequenia;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Bardo implements Clase{


    public Bardo(){

    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new TajoArmonico());
        listaHabilidades.add(new SinfoniaEstridente());
        listaHabilidades.add(new CuracionPequenia());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+90);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
    }

}
