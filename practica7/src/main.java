import Services.GestionMundo;
import handler.RPGDataException;
import model.Items;
import model.Personajes;
import utils.JsonHelper;
import utils.TxtHelper;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws RPGDataException {
        GestionMundo gestionMundo=new GestionMundo();
        gestionMundo.crearPersonajeBueno("Pepe", "Elfo",20,gestionMundo.item("Kf01"));
        

    }
}


