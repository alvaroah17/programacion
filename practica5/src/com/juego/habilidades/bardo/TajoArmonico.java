package com.juego.habilidades.bardo;

import com.juego.habilidades.Habilidades;

public class TajoArmonico implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public TajoArmonico(){
        this.nombre="Tajo Armonico";
        this.tipo="Daño";
        this.cantidadDaño =30;
        this.usos=5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDaño() {
        return cantidadDaño;
    }

    public void setCantidadDaño(int cantidadDaño) {
        this.cantidadDaño = cantidadDaño;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    @Override
    public void usarHabilidad() {

    }

    @Override
    public String toString() {
        return "TajoArmonico{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + cantidadDaño +
                ", usos=" + usos +
                '}';
    }
}
