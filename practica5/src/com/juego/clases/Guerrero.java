package com.juego.clases;

import com.juego.habilidades.Habilidades;
import com.juego.habilidades.curacion.CuracionPequenia;
import com.juego.habilidades.guerrero.Espadazo;
import com.juego.habilidades.guerrero.LanzamientoEspada;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Guerrero implements Clase{
    private String nombreClase;
    public Guerrero (){
        this.nombreClase="Guerrero";
    }

    public String getNombreClase() {
        return nombreClase;
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Espadazo());
        listaHabilidades.add(new LanzamientoEspada());
        listaHabilidades.add(new CuracionPequenia());
    }

    @Override
    public void aplicarBonificadores(Estadistica estadisticas) {
        estadisticas.setVida(estadisticas.getVida()+120);
        estadisticas.setVidaMaxima(estadisticas.getVidaMaxima()+120);
        estadisticas.setFuerza(estadisticas.getFuerza()+3);
    }
}
