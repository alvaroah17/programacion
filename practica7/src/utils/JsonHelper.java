package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Personajes;

import java.awt.*;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonHelper {
    public JsonHelper(){
    }
    public ArrayList<Personajes> leerJsonPersonajes (){
        ArrayList<Personajes> listaPersonajes=new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("practica7\\Ficheros\\personajes.json")){
            Type tokenPersonajes = new TypeToken<ArrayList<Personajes>>() {}.getType();
            listaPersonajes=gson.fromJson(reader, tokenPersonajes);
        }catch (Exception e){
            System.out.println("Error al leer JSON: "+e.getMessage());
        }
        return listaPersonajes;
    }
    //HACER LO MISMO PARA LOS ITEMS
}
