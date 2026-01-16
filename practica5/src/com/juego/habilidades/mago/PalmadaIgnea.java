package com.juego.habilidades.mago;

import com.juego.habilidades.Habilidades;

public class PalmadaIgnea implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    public PalmadaIgnea(){
        this.nombre="Palmada Ignea";
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
}
