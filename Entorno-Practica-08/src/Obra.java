import java.util.ArrayList;

public abstract class Obra {
    private String nombreObra;
    private int idObra;
    private ArrayList<Artista> artistas;
    private int duracionMinutos;
    public Obra( String nombreObra,int idObra, int duracionMinutos) {
        this.idObra = idObra;
        this.nombreObra = nombreObra;
        this.duracionMinutos = duracionMinutos;
        this.artistas=new ArrayList<>();
    }
    abstract boolean esMonetizable();
}
