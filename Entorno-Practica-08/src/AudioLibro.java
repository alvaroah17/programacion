public class AudioLibro extends Obra{
    public AudioLibro(String nombreObra, int idObra, int duracionMinutos) {
        super(nombreObra, idObra, duracionMinutos);
    }

    @Override
    boolean esMonetizable() {
        return true;
    }
}
