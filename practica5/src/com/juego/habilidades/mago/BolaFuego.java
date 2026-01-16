package com.juego.habilidades.mago;

import com.juego.habilidades.Habilidades;

public class BolaFuego implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    public BolaFuego(){
        this.nombre="Bola de Fuego";
        this.daño=120;
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
