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

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
