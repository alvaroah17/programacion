package utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class LoggerCustom {
    //
    public void escribirLog(String mensaje)  {
        String path = "practica7"+File.separator+"Ficheros"+ File.separator+"errores.log";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))){
            writer.write("["+ LocalDateTime.now()+"] "+mensaje);
            writer.newLine();
        } catch(Exception e){
            System.out.println("ERROR: Al escribir en el log : "+e.getMessage());
        }
    }
}