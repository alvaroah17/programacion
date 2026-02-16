public class Cancion extends Obra{
    public Cancion(String nombreObra,int idObra, int duracionMinutos) {
        super(nombreObra,idObra, duracionMinutos);
    }

    @Override
    boolean esMonetizable() {
        return true;
    }
}
