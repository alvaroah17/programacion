package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionGrande;
import com.juego.habilidades.sacerdote.BastonazoPurificador;
import com.juego.habilidades.sacerdote.RayoDivino;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Sacerdote implements Clase{
    private String nombreClase;
    public Sacerdote (){
        this.nombreClase="Sacerdote";
    }

    public String getNombreClase() {
        return nombreClase;
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new BastonazoPurificador());
        listaHabilidades.add(new RayoDivino());
        listaHabilidades.add(new CuracionGrande());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+95);
        estadisticas.setVidaMaxima(estadisticas.getVidaMaxima()+95);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
    }
}
