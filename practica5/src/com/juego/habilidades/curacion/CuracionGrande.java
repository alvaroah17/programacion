package com.juego.habilidades.curacion;

import com.juego.habilidades.Habilidades;

public class CuracionGrande implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public CuracionGrande(){
        this.nombre="Pocion Curacion Grande";
        this.tipo="Curacion";
        this.cantidadDaño =80;
        this.usos=3;
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
        return "CuracionGrande{" +
                "nombre='" + nombre + '\'' +
                ", cura=" + cantidadDaño +
                ", usos=" + usos +
                '}';
    }
}
