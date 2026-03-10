package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Personajes {
    private String nombre;
    private String raza;
    private int nivel;
    private ArrayList<String> equipoIds;

    public Personajes(String nombre, String raza, int nivel) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.equipoIds = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<String> getEquipoIds() {
        return equipoIds;
    }

    public void setEquipoIds(ArrayList<String> equipoIds) {
        this.equipoIds = equipoIds;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", nivel=" + nivel +
                ", equipoIds=" + equipoIds +
                '}';
    }
}
