package com.juego.habilidades.curacion;

import com.juego.habilidades.Habilidades;

public class CuracionMedia implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public CuracionMedia(){
        this.nombre="Pocion Curativa Mediana";
        this.tipo="Curacion";
        this.cantidadDaño =45;
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

    @Override
    public String toString() {
        return "CuracionMedia{" +
                "nombre='" + nombre + '\'' +
                ", curacion=" + cantidadDaño +
                ", usos=" + usos +
                '}';
    }
}
