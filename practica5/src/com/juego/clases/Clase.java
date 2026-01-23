package com.juego.clases;

import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;

public interface Clase {
    public void agregarHabilidad(Personaje personaje);
    public void aplicarBonificadores (Estadistica estadisticas);
    public String getNombreClase();
}
