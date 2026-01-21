package com.juego.habilidades.druida;

import com.juego.habilidades.Habilidades;

public class LlamadaTrueno implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public LlamadaTrueno(){
        this.nombre="Llamada del Trueno";
        this.tipo="Daño";
        this.cantidadDaño =120;
        this.usos=1;
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
}
