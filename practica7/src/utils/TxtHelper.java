package utils;

import handler.FormatoInvalidoException;
import model.Ciudades;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    private LoggerCustom loggerCustom ;

    public TxtHelper() {
        this.loggerCustom = new LoggerCustom();
    }

    public ArrayList<Ciudades> leerCiudades() throws FormatoInvalidoException {
        ArrayList<Ciudades> ciudades=new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get("practica7"+File.separator+"Ficheros"+ File.separator+"ciudades.txt"));
            for (String linea : lineas) {
                //System.out.println(linea);
                String [] s =linea.split(";");
                Ciudades ciudades2=new Ciudades(s[0], Integer.parseInt(s[1]), s[2],Integer.parseInt(s[3]));
                ciudades.add(ciudades2);
            }
        } catch (Exception e) {
            loggerCustom.escribirLog("ERROR: Al procesar el fichero ciudades.txt: " + e.getMessage());
            throw new FormatoInvalidoException("ERROR: Al procesar el fichero ciudades.txt: " + e.getMessage());
        }
        return ciudades;
    }
}
