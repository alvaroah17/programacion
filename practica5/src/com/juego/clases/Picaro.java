package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionMedia;
import com.juego.habilidades.picaro.Puñalada;
import com.juego.habilidades.picaro.Tomahawk;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Picaro implements Clase{

    public Picaro (){
    }


    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList <Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Puñalada());
        listaHabilidades.add(new Tomahawk());
        listaHabilidades.add(new CuracionMedia());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+105);
        estadisticas.setDestreza(estadisticas.getDestreza()+3);
    }
}
