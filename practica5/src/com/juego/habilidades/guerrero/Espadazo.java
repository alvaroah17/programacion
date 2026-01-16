package com.juego.habilidades.guerrero;

import com.juego.habilidades.Habilidades;

public class Espadazo implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    public Espadazo(){
        this.nombre="Espadazo";
        this.daño=45;
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
