package rpg.model;

public class Habilidad {
    private int id;
    private String nombre;
    private int dañoBase;
    private int usosMaximos;
    private int idClase; // FK (Foreign Key)

    public Habilidad(int id, String nombre, int dañoBase, int usosMaximos, int idClase) {
        this.id = id;
        this.nombre = nombre;
        this.dañoBase = dañoBase;
        this.usosMaximos = usosMaximos;
        this.idClase = idClase;
    }
}
