package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import handler.FormatoInvalidoException;
import model.Items;
import model.Personajes;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonHelper {
    public JsonHelper(){
    }
    public ArrayList<Personajes> leerJsonPersonajes () throws FormatoInvalidoException {
        ArrayList<Personajes> listaPersonajes=new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("practica7\\Ficheros\\personajes.json")){
            Type tokenPersonajes = new TypeToken<ArrayList<Personajes>>() {}.getType();
            listaPersonajes=gson.fromJson(reader, tokenPersonajes);
        }catch (Exception e){
            throw new FormatoInvalidoException("Error al procesar el fichero ciudades.txt: " + e.getMessage());
        }
        return listaPersonajes;
    }
    //HACER LO MISMO PARA LOS ITEMS
    public ArrayList<Items> leerJsonItems () throws FormatoInvalidoException {
        ArrayList<Items> listaItems =new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("practica7\\Ficheros\\items.json")){
            Type tokenItems = new TypeToken<ArrayList<Items>>() {}.getType();
            listaItems =gson.fromJson(reader, tokenItems);
        }catch (Exception e){
            throw new FormatoInvalidoException("Error al procesar el fichero ciudades.txt: " + e.getMessage());
        }
        return listaItems;
    }
}
