import com.juego.clases.Bardo;
import com.juego.clases.Paladin;
import com.juego.habilidades.Habilidades;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;
import com.juego.presentacion.Combate;
import com.juego.presentacion.GestorPersonajes;
import com.juego.presentacion.Presentacion;
import com.juego.razas.Elfo;
import com.juego.razas.Humano;

public class Main {
   public static void main(String[] args) {

       Presentacion menu=new Presentacion();
       menu.Menu();



       /*GestorPersonajes gestorPersonajes= new GestorPersonajes();
       gestorPersonajes.crearNuevoPersonaje();
       System.out.println("PERSONAJES CREADOS");
       for (int i = 0; i < gestorPersonajes.getPersonajes().size(); i++) {
           System.out.println(gestorPersonajes.getPersonajes().get(i).getNombre());
       }

       Combate combate1 = new Combate();
       combate1.iniciarCombate(personaje1, personaje2);
       */
    }
}