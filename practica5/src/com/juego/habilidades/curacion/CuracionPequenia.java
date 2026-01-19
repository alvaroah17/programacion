package com.juego.habilidades.curacion;

import com.juego.habilidades.Habilidades;

public class CuracionPequenia implements Habilidades {
    private String nombre;
    private int curacion;
    private int usos;

    public CuracionPequenia(){
        this.nombre="Pocion Curativa Pequeña";
        this.curacion=30;
        this.usos=3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuracion() {
        return curacion;
    }

    public void setCuracion(int curacion) {
        this.curacion = curacion;
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
        return "CuracionPequenia{" +
                "nombre='" + nombre + '\'' +
                ", curacion=" + curacion +
                ", usos=" + usos +
                '}';
    }
}
