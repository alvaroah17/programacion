package com.juego.habilidades.guerrero;

import com.juego.habilidades.Habilidades;

public class LanzamientoEspada implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public LanzamientoEspada(){
        this.nombre="Lanzamiento de Espada";
        this.tipo="Daño";
        this.cantidadDaño=100;
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

    public void setCantidadDaño(int daño) {
        this.cantidadDaño = daño;
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
