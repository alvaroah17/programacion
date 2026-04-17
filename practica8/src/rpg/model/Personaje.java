package rpg.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private Raza raza;
    private Clase clase;
    private Ciudad ciudad_actual;
    private Map<Item, Integer> inventario;
    private List<Habilidad> hablidades;


    public Personaje(int id, String nombre, int nivel, int oro, int vida_actual, Raza raza, Clase clase, Ciudad ciudad_actual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual + raza.getBonificadorVida();
        this.raza = raza;
        this.clase = clase;
        this.ciudad_actual = ciudad_actual;
        this.inventario = new HashMap<>();
        this.hablidades=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(int vida_actual) {
        this.vida_actual = vida_actual;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Ciudad getCiudad_actual() {
        return ciudad_actual;
    }

    public void setCiudad_actual(Ciudad ciudad_actual) {
        this.ciudad_actual = ciudad_actual;
    }

    public Map<Item, Integer> getInventario() {
        return inventario;
    }

    public void aniardirItem(Item itemNuevo, Integer numeroItems){

        for (Item itemAbuscar : this.inventario.keySet()){
            if (itemAbuscar.getId()== itemNuevo.getId()){
               this.inventario.put(itemAbuscar, this.inventario.get(itemAbuscar) + numeroItems);
               return;
            }
        }
        this.inventario.put(itemNuevo, numeroItems);
    }

    public void aniadirHabilidad (Habilidad nuevaHabilidad){
        this.hablidades.add(nuevaHabilidad);
    }

    public List<Habilidad> getHablidades() {
        return hablidades;
    }
}
