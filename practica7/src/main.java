import Services.GestionMundo;
import handler.RPGDataException;
import model.Items;
import model.Personajes;
import utils.JsonHelper;
import utils.TxtHelper;

public class main {
    public static void main(String[] args) throws RPGDataException {
        GestionMundo gestionMundo=new GestionMundo();
        //gestionMundo.cargarTodo();
        gestionMundo.crearPersonaje();
    }
}


