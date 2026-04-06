package rpg.model;

import rpg.dao.RazaDAO;

public class Raza {
    private int id;
    private String nombre;
    private int bonificadorVida;
    private int bonificadorFuerza;

    public Raza(int id, String nombre, int bonificadorVida, int bonificadorFuerza) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadorVida = bonificadorVida;
        this.bonificadorFuerza = bonificadorFuerza;
    }
}
