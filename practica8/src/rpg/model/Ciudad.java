package rpg.model;

public class Ciudad {
    private int id;
    private String nombre;
    private int nivelMinimoAcceso;

    public Ciudad(int id, String nombre, int nivelMinimoAcceso) {
        this.id = id;
        this.nombre = nombre;
        this.nivelMinimoAcceso = nivelMinimoAcceso;
    }
}
