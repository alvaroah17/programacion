package Services;

import handler.DatoInvalidoException;
import handler.FormatoInvalidoException;
import handler.RPGDataException;
import handler.RecursoNoEncontradoException;
import model.Ciudades;
import model.Items;
import model.Personajes;
import utils.JsonHelper;
import utils.LoggerCustom;
import utils.TxtHelper;
import java.time.LocalDateTime;
import java.util.*;

public class GestionMundo {
    private ArrayList<Personajes> listaPersonajes;
    private ArrayList<Items> listaItems;
    private ArrayList<Ciudades> listaCiudades;
    private HashMap<String, Items> mapItems;
    private LoggerCustom loggerCustom ;

    public GestionMundo() throws FormatoInvalidoException {
        this.listaCiudades = new ArrayList<>();
        this.listaPersonajes = new ArrayList<>();
        this.listaItems = new ArrayList<>();
        this.mapItems=new HashMap<>();
        this.loggerCustom=new LoggerCustom();
        cargarTodo();

    }

    public ArrayList<Items> getListaItems() {
        return listaItems;
    }

    public void cargarTodo() throws FormatoInvalidoException {
        TxtHelper lectorTXT = new TxtHelper();
        this.listaCiudades=lectorTXT.leerCiudades();

        JsonHelper lectorJSON=new JsonHelper();
        this.listaPersonajes=lectorJSON.leerJsonPersonajes();
        this.listaItems=lectorJSON.leerJsonItems();

        for(Items itemAbuscar : listaItems){
            this.mapItems.put(itemAbuscar.getId(), itemAbuscar);
        }
    }

    public void crearPersonajeBueno(String nombre, String raza, int nivel, ArrayList<String> idsItems) throws RPGDataException {

        for (String idObjeto: idsItems){
            if (!mapItems.containsKey(idObjeto)){
                loggerCustom.escribirLog("ERROR: El idItem que buscas no existe ");
                throw new DatoInvalidoException("ERROR: El idItem que buscas no existe ");
            }
        }
        Personajes personajeNuevo=new Personajes(nombre, raza, nivel,idsItems);
        listaPersonajes.add(personajeNuevo);
    }
public ArrayList<String> item(String idItem){
        ArrayList<String> itemPersonaje=new ArrayList<>(List.of(idItem));
        return itemPersonaje;
}
   /* public void crearPersonaje() throws RPGDataException {
       // cargarTodo();

        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe un nombre :");
        String nombre= sc.nextLine();
        try{
            Integer.parseInt(nombre);
            throw new FormatoInvalidoException("Error: El nombre no puede ser un numero");
        }catch (NumberFormatException e){

        }
        System.out.println("Escribe una raza :");
        String raza=sc.nextLine();
        try{
            Integer.parseInt(raza);
            throw new FormatoInvalidoException("Error: La raza no puede ser un numero");
        }catch (NumberFormatException e){

        }
        System.out.println("Escribe un nivel :");
        int nivel=0;
        try{
            nivel= sc.nextInt();
            if (nivel<0 || nivel>100){
                throw new DatoInvalidoException("Error: El nivel del personaje no puede ser menor a 0");
            }
        }catch (InputMismatchException e){
            throw new FormatoInvalidoException("Error: Solo se puede seleccionar el nivel con numeros enteros");
        }
        //SE CREA PERSONAJE SI NO SALTA NINGUNA EXCEPCION
        Personajes personajeNuevo=new Personajes(nombre, raza, nivel);

        for (int i = 0; i <listaItems.size(); i++) {
            System.out.println((i)+" | "+listaItems.get(i).getId()+" | "+listaItems.get(i).getNombre()+" ("+listaItems.get(i).getTipo()+") | Valor= "+listaItems.get(i).getValor());
        }

        System.out.println("Elige un numero del 0 al "+listaItems.size()+" dependiendo del equipo que quieras");
        int eleccionEquipo=0;
        try{
            eleccionEquipo= sc.nextInt();
            if (eleccionEquipo>=listaItems.size() || eleccionEquipo<0){
                throw new RecursoNoEncontradoException("Error: NO existe ese Item que intentas buscar, selecciona el equipamiento con un numero de equipamiento que SI exista");
            }
        }catch (InputMismatchException e){
            throw new FormatoInvalidoException("Error: Solo se puede seleccionar el equipo con numeros enteros");
        }
        personajeNuevo.getEquipoIds().add(listaItems.get(eleccionEquipo).getId());
        System.out.println("Has elegido el equipo : "+personajeNuevo.getEquipoIds());
        listaPersonajes.add(personajeNuevo);
    }*/
    public void guardarCambios(){

    }
}
