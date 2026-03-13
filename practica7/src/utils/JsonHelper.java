package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import handler.FormatoInvalidoException;
import model.Items;
import model.Personajes;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonHelper {
    private LoggerCustom loggerCustom ;

    public JsonHelper(){
        loggerCustom=new LoggerCustom();
    }
    public ArrayList<Personajes> leerJsonPersonajes () throws FormatoInvalidoException {
        ArrayList<Personajes> listaPersonajes=new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("practica7"+ File.separator+"Ficheros"+File.separator+"personajes.json")){
            Type tokenPersonajes = new TypeToken<ArrayList<Personajes>>() {}.getType();
            listaPersonajes=gson.fromJson(reader, tokenPersonajes);
        }catch (Exception e){
            loggerCustom.escribirLog("ERROR: Al procesar el fichero personajes.json : " + e.getMessage());
            throw new FormatoInvalidoException("ERROR: Al procesar el fichero personajes.json :" + e.getMessage());
        }
        return listaPersonajes;
    }
    //HACER LO MISMO PARA LOS ITEMS
    public ArrayList<Items> leerJsonItems () throws FormatoInvalidoException {
        ArrayList<Items> listaItems =new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader("practica7"+File.separator+"Ficheros"+File.separator+"items.json")){
            Type tokenItems = new TypeToken<ArrayList<Items>>() {}.getType();
            listaItems =gson.fromJson(reader, tokenItems);
        }catch (Exception e){
            loggerCustom.escribirLog("ERROR: Al procesar el fichero items.json : " + e.getMessage());
            throw new FormatoInvalidoException("ERROR: Al procesar el fichero items.json : " + e.getMessage());
        }
        return listaItems;
    }

    public void escribirJSON(ArrayList<Personajes> listaPersonajes) throws FormatoInvalidoException{
        String path="practica7"+File.separator+"Ficheros"+File.separator+"personajes.json";
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(path))){
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaPersonajes, writer);
        }catch (Exception e){
            loggerCustom.escribirLog("ERROR: Al escribir en el JSON : "+e.getMessage());
            throw new FormatoInvalidoException("ERROR: Al escribir en el JSON : "+e.getMessage());
        }
    }
}
