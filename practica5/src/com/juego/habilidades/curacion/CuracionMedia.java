package com.juego.habilidades.curacion;

import com.juego.habilidades.Habilidades;

public class CuracionMedia implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadCura;
    private int usos;

    public CuracionMedia(){
        this.nombre="Pocion Curativa Mediana";
        this.tipo="Curacion";
        this.cantidadCura =120;
        this.usos=1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return cantidadCura;
    }

    public void setDaño(int daño) {
        this.cantidadCura = daño;
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
        return "CuracionMedia{" +
                "nombre='" + nombre + '\'' +
                ", curacion=" + cantidadCura +
                ", usos=" + usos +
                '}';
    }
}
