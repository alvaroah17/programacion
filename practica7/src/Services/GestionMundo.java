package Services;

import handler.DatoInvalidoException;
import handler.FormatoInvalidoException;
import handler.RPGDataException;
import handler.RecursoNoEncontradoException;
import model.Ciudades;
import model.Items;
import model.Personajes;
import utils.JsonHelper;
import utils.TxtHelper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionMundo {
    ArrayList<Personajes> listaPersonajes;
    ArrayList<Items> listaItems;
    ArrayList<Ciudades> listaCiudades;

    public GestionMundo() {
        this.listaCiudades = new ArrayList<>();
        this.listaPersonajes = new ArrayList<>();
        this.listaItems = new ArrayList<>();
        cargarTodo();
    }

    public void cargarTodo(){
        TxtHelper lectorTXT = new TxtHelper();
        this.listaCiudades=lectorTXT.leerCiudades();

        JsonHelper lectorJSON=new JsonHelper();
        this.listaPersonajes=lectorJSON.leerJsonPersonajes();
        this.listaItems=lectorJSON.leerJsonItems();
    }

    public void crearPersonaje() throws RPGDataException {
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
    }
    public void guardarCambios(){

    }
}
