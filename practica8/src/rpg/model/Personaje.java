package rpg.model;

public class Personaje {
    private int id;
    private String nombre;
    private int nivel;
    private int oro;
    private int vida_actual;
    private Raza raza;
    private Clase clase;
    private Ciudad ciudad_actual;


    public Personaje(int id, String nombre, int nivel, int oro, int vida_actual) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
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

    public int getId_raza() {
        return id_raza;
    }

    public void setId_raza(int id_raza) {
        this.id_raza = id_raza;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getId_ciudad_actual() {
        return id_ciudad_actual;
    }

    public void setId_ciudad_actual(int id_ciudad_actual) {
        this.id_ciudad_actual = id_ciudad_actual;
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
}
