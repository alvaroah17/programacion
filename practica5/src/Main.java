import com.juego.clases.Bardo;
import com.juego.habilidades.Habilidades;
import com.juego.modelo.Estadistica;
import com.juego.modelo.Personaje;
import com.juego.razas.Humano;

public class Main {
   public static void main(String[] args) {
       Personaje personaje1= new Personaje("Personaje 1", new Humano(),new Bardo(),new Estadistica());
       System.out.println(personaje1.getEstadisticas());
       for (Habilidades habilidad:personaje1.getListaHabilidades()){
           System.out.println(habilidad.toString());
       }



    }
}