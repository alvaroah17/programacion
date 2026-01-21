package com.juego.habilidades.sacerdote;

import com.juego.habilidades.Habilidades;

public class RayoDivino implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public RayoDivino(){
        this.nombre="Rayo Divino";
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void usarHabilidad() {
        if (this.usos>0)
            this.usos--;
        else {
            this.usos=0;
        }
    }
}
