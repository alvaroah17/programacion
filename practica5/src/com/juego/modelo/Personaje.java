package com.juego.modelo;

import com.juego.clases.Clase;
import com.juego.habilidades.Habilidades;
import com.juego.razas.Raza;

import java.util.ArrayList;
/// ATRIBUTOS
public class Personaje {
    private String nombre;
    private Clase clase;
    private Raza raza;
    private Estadistica estadisticas;
    private ArrayList<Habilidades> listaHabilidades;

    public Personaje(String nombre, Raza raza, Clase clase, Estadistica estadisticas) {
        this.nombre = nombre;
        this.raza = raza;
        this.clase = clase;
        this.estadisticas = estadisticas;
        this.listaHabilidades = new ArrayList<>();
        this.raza.establecerEstadisticas(this.estadisticas);
        this.clase.aplicarBonificadores(this.estadisticas);
        this.clase.agregarHabilidad(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Estadistica getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadistica estadisticas) {
        this.estadisticas = estadisticas;
    }

    public ArrayList<Habilidades> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(ArrayList<Habilidades> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }
    public void recibeDaño (int cantidad){
        this.estadisticas.setVida(this.estadisticas.getVida()-cantidad);
    }
    public void recibeCura (int cantidad){

       if (this.estadisticas.getVida()+cantidad>=this.estadisticas.getVidaMaxima()){
           this.estadisticas.setVida(this.estadisticas.getVidaMaxima());
       }
       else if (this.estadisticas.getVida()+cantidad< estadisticas.getVidaMaxima()){
            this.estadisticas.setVida(this.estadisticas.getVida()+cantidad);
       }
    }
 /// ARREGLAR MAÑANA
}
