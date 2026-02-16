import java.util.ArrayList;
import java.util.Scanner;

public class Artista {
    private String nombreArtista;
    private ArrayList<Obra> obrasPublicadas;

    Scanner sc=new Scanner(System.in);
    public Artista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
        this.obrasPublicadas=new ArrayList<>();
    }

    public void crearObra(){
        System.out.println("1-Crear una Canción");
        System.out.println("2-Crear un Podcast");
        System.out.println("3-Crear un Audio Libro");
        System.out.printf("Seleccion: ");
        int eleccionObra=sc.nextInt();
        switch (eleccionObra){
            case 1:
                System.out.println("Introduce un nombre");
                String nombreCancion=sc.nextLine();
                System.out.println("Introduce un id");
                int idCancion=sc.nextInt();
                System.out.println("Introduce la duracion de la obra");
                int duracionCancion =sc.nextInt();
                Cancion cancion=new Cancion( nombreCancion,idCancion, duracionCancion);
            case 2:
                System.out.println("Introduce un nombre");
                String nombrePodcast=sc.nextLine();
                System.out.println("Introduce un id");
                int idPodcast=sc.nextInt();
                System.out.println("Introduce la duracion de la obra");
                int duracionPodcast =sc.nextInt();
                Podcast podcast =new Podcast( nombrePodcast,idPodcast, duracionPodcast);
            case 3:
                System.out.println("Introduce un nombre");
                String nombreAudioLibro=sc.nextLine();
                System.out.println("Introduce un id");
                int idAudioLibro=sc.nextInt();
                System.out.println("Introduce la duracion de la obra");
                int duracionObra=sc.nextInt();
                AudioLibro audioLibro =new AudioLibro( nombreAudioLibro, idAudioLibro,duracionObra);
        }
    }
}
