package com.juego.habilidades.bardo;

import com.juego.habilidades.Habilidades;

public class SinfoniaEstridente implements Habilidades {
    private String nombre;
    private String tipo;
    private int cantidadDaño;
    private int usos;

    public SinfoniaEstridente(){
        this.nombre="Sinfonia Estridente";
        this.tipo="Daño";
        this.cantidadDaño =95;
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

    @Override
    public String toString() {
        return "SinfoniaEstridente{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + cantidadDaño +
                ", usos=" + usos +
                '}';
    }
}
