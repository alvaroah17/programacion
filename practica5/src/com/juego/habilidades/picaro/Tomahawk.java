package com.juego.habilidades.picaro;

import com.juego.habilidades.Habilidades;

public class Tomahawk implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    public Tomahawk(){
        this.nombre="Tomahawk";
        this.daño=100;
        this.usos=1;
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
}
