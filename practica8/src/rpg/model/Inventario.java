package rpg.model;

public class Inventario {
    private int idPersonaje;
    private int idItem;
    private int cantidad;

    public Inventario(int idPersonaje, int idItem, int cantidad) {
        this.idPersonaje = idPersonaje;
        this.idItem = idItem;
        this.cantidad = cantidad;
    }
}
