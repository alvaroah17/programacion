import java.util.ArrayList;
import java.util.HashSet;

public class Lista {
    private String nombreLista;
    private int idLista;
    private HashSet<Obra> obras;

    public Lista(String nombreLista, int idLista) {
        this.idLista = idLista;
        this.nombreLista = nombreLista;
        this.obras=new HashSet<>();
    }

    public void agregarObra(Obra obra){
        this.obras.add(obra);
    }
}
