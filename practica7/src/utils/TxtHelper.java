package utils;

import model.Ciudades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    public ArrayList<Ciudades> leerCiudades() {
        ArrayList<Ciudades> ciudades=new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get("practica7\\Ficheros\\ciudades.txt"));
            for (String linea : lineas) {
                //System.out.println(linea);
                String [] s =linea.split(";");
                Ciudades ciudades2=new Ciudades(s[0], Integer.parseInt(s[1]), s[2],Integer.parseInt(s[3]));
                ciudades.add(ciudades2);
            }
        } catch (Exception e) {
            System.out.println("Error al procesar el fichero."+e.getMessage());
        }
        return ciudades;
    }

}
