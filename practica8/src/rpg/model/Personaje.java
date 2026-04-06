package rpg.model;

public class Personaje {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private int id_raza;
    private int id_clase;
    private int id_ciudad_actual;

    public Personaje(int id, String nombre, int nivel, int oro, int vida_actual, int id_raza, int id_clase, int id_ciudad_actual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.id_raza = id_raza;
        this.id_clase = id_clase;
        this.id_ciudad_actual = id_ciudad_actual;
    }
}
