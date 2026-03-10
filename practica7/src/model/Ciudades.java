package model;

public class Ciudades {
    private String nombre;
    private int poblacion;
    private String clima;
    private int riesgo;;

    public Ciudades(String nombre, int poblacion, String clima, int riesgo){
        this.nombre=nombre;
        this.poblacion=poblacion;
        this.clima=clima;
        this.riesgo=riesgo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    @Override
    public String toString() {
        return "Ciudades{" +
                "nombre='" + nombre + '\'' +
                ", poblacion=" + poblacion +
                ", clima='" + clima + '\'' +
                ", riesgo=" + riesgo +
                '}';
    }
}
