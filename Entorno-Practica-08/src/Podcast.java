public class Podcast extends Obra{
    public Podcast(String nombreObra,int idObra, int duracionMinutos) {
        super( nombreObra,idObra, duracionMinutos);
    }

    @Override
    boolean esMonetizable() {
        return false;
    }
}
