import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Oyente {
    private String nombreUsuario;
    private ArrayList<Lista> listasReproduccion;
    Scanner sc=new Scanner(System.in);
    public Oyente(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.listasReproduccion=new ArrayList<>();
    }

    public void crearLista(){
        System.out.println("Introduce el nombre de la lista");
        String nombreLista=sc.nextLine();
        System.out.println("Introduce el id de la lista");
        int idLista=sc.nextInt();
        Lista lista=new Lista(nombreLista,idLista);
    }
}
