package com.juego.habilidades.curacion;

import com.juego.habilidades.Habilidades;

public class CuracionGrande implements Habilidades {
    private String nombre;
    private int cura;
    private int usos;

    public CuracionGrande(){
        this.nombre="Pocion Curacion Grande";
        this.cura=80;
        this.usos=3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return cura;
    }

    public void setDaño(int daño) {
        this.cura = daño;
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
        return "CuracionGrande{" +
                "nombre='" + nombre + '\'' +
                ", cura=" + cura +
                ", usos=" + usos +
                '}';
    }
}
