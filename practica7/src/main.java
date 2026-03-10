import Services.GestionMundo;
import handler.RPGDataException;
import model.Items;
import model.Personajes;
import utils.JsonHelper;
import utils.TxtHelper;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws RPGDataException {
        GestionMundo gestionMundo=new GestionMundo();
        gestionMundo.cargarTodo();
        ArrayList<String> idObjetos=new ArrayList<>();
        idObjetos.add("K01");

        gestionMundo.crearPersonajeBueno("Pepe", "Elfo",20,idObjetos);
        

    }
}


