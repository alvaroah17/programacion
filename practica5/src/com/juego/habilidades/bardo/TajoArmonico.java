package com.juego.habilidades.bardo;

import com.juego.habilidades.Habilidades;

public class TajoArmonico implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    public TajoArmonico(){
        this.nombre="Tajo Armonico";
        this.daño=30;
        this.usos=5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
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
                ", daño=" + daño +
                ", usos=" + usos +
                '}';
    }
}
