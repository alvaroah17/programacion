package Services;

import handler.*;
import model.Ciudades;
import model.Items;
import model.Personajes;
import utils.JsonHelper;
import utils.LoggerCustom;
import utils.TxtHelper;
import java.util.*;

public class GestionMundo {
    private ArrayList<Personajes> listaPersonajes;
    private ArrayList<Personajes> listaPersonajesAeliminar;
    private ArrayList<Items> listaItems;
    private ArrayList<Ciudades> listaCiudades;
    private HashMap<String, Items> mapItems;
    private LoggerCustom loggerCustom;
    private JsonHelper jsonHelper;

    public GestionMundo() throws RPGDataException {
        this.listaCiudades = new ArrayList<>();
        this.listaPersonajes = new ArrayList<>();
        this.listaItems = new ArrayList<>();
        this.mapItems = new HashMap<>();
        this.loggerCustom = new LoggerCustom();
        this.jsonHelper = new JsonHelper();
        this.listaPersonajesAeliminar=new ArrayList<>();
        cargarTodo();
    }


    public ArrayList<Personajes> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    public ArrayList<Items> getListaItems() {
        return listaItems;
    }

    public void setListaItems(ArrayList<Items> listaItems) {
        this.listaItems = listaItems;
    }

    public ArrayList<Ciudades> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(ArrayList<Ciudades> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public HashMap<String, Items> getMapItems() {
        return mapItems;
    }

    public void setMapItems(HashMap<String, Items> mapItems) {
        this.mapItems = mapItems;
    }

    public LoggerCustom getLoggerCustom() {
        return loggerCustom;
    }

    public void setLoggerCustom(LoggerCustom loggerCustom) {
        this.loggerCustom = loggerCustom;
    }

    public JsonHelper getJsonHelper() {
        return jsonHelper;
    }

    public void setJsonHelper(JsonHelper jsonHelper) {
        this.jsonHelper = jsonHelper;
    }

    public void cargarTodo() throws RPGDataException {
        TxtHelper lectorTXT = new TxtHelper();
        this.listaCiudades = lectorTXT.leerCiudades();

        this.listaPersonajes = jsonHelper.leerJsonPersonajes();
        this.listaItems = jsonHelper.leerJsonItems();

        for (Items itemAbuscar : listaItems) {
            this.mapItems.put(itemAbuscar.getId(), itemAbuscar);
        }
        equipamientoInteligente(listaPersonajes, listaCiudades, listaItems);
    }

    public void crearPersonaje(String nombre, String raza, int nivel, ArrayList<String> idsItems, String nombreCiudad) throws RPGDataException {

        for (String idObjeto : idsItems) {
            if (!mapItems.containsKey(idObjeto)) {
                loggerCustom.escribirLog("ERROR: El idItem que buscas no existe ");
                throw new RecursoNoEncontradoException("ERROR: El idItem que buscas no existe ");
            }
        }
        if (nivel < 0) {
            loggerCustom.escribirLog("ERROR: El nivel no puede ser inferior a 0");
            throw new DatoInvalidoException("ERROR: El nivel no puede ser inferior a 0");
        } else if (nivel > 100) {
            loggerCustom.escribirLog("ERROR: El nivel no puede ser superior a 100");
            throw new DatoInvalidoException("ERROR: El nivel no puede ser superior a 100");
        }


        Personajes personajeNuevo = new Personajes(nombre, raza, nivel, idsItems, nombreCiudad);
        listaPersonajes.add(personajeNuevo);
        guardarCambios(listaPersonajes);
    }

    public ArrayList<String> item(String idItem) {
        ArrayList<String> itemPersonaje = new ArrayList<>(List.of(idItem));
        return itemPersonaje;
    }

    public void guardarCambios(ArrayList<Personajes> listaPersonajes) throws FormatoInvalidoException {
        jsonHelper.escribirJSON(listaPersonajes);
    }

    public void equipamientoInteligente(ArrayList<Personajes> personajes, ArrayList<Ciudades> ciudades, ArrayList<Items> items) throws ValidadorBiomaException {

        for (Personajes personajeAcomprobar : personajes) {
            for (Ciudades ciudad : ciudades) {
                if (ciudad.getNombre().equals(personajeAcomprobar.getNombreCiudad())) {
                    if (ciudad.getClima().equals("Desertico") && personajeAcomprobar.getRaza().equals("Enano")) {
                        loggerCustom.escribirLog("ERROR: NO es compatible la raza Enano y el clima desierto");
                        //throw new ValidadorBiomaException("ERROR: NO es compatible la raza Enano y el clima desierto");
                        listaPersonajesAeliminar.add(personajeAcomprobar);
                        //listaPersonajes.remove(listaPersonajesAeliminar);
                    }
                }
            }
        }
        for (Personajes personajeAcomprobar : personajes) {
            for (Ciudades ciudad : ciudades) {
                if (ciudad.getNombre().equals(personajeAcomprobar.getNombreCiudad())) {
                    for (int i = 0; i < personajeAcomprobar.getEquipoIds().size(); i++) {
                        if (ciudad.getClima().equals("Volcanico") && personajeAcomprobar.getEquipoIds().get(i).equals("H01")) {
                            loggerCustom.escribirLog("ERROR: No puede haber un objeto de tipo hielo en un clima volcanico");
                            //  throw new ValidadorBiomaException("ERROR: No puede haber un objeto de tipo hielo en un clima volcanico");
                            // intento borrar personaje
                            listaPersonajesAeliminar.add(personajeAcomprobar);
                            //listaPersonajes.remove(listaPersonajesAeliminar);
                        }
                    }
                }
            }
        }
        listaPersonajes.removeAll(listaPersonajesAeliminar);
    }
}