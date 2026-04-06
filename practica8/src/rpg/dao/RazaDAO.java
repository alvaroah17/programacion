package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Raza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RazaDAO{
    private ArrayList<Raza> razas;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public RazaDAO() throws BDException{
        ///INICIALIZAMOS LA LISTA
        this.razas=new ArrayList<>();
        conexionDB();
    }

    /// GETTERS AND SETTERS
    public ArrayList<Raza> getRazas() {
        return razas;
    }

    /// FUNCIONES
    public void conexionDB() throws BDException{
        /// CONEXION CON LA TABLAR RAZA DE LA BASE DE DATOS
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM razas")) {
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int bonificador_vida = resultset.getInt("bonificador_vida");
                int bonificador_fuerza = resultset.getInt("bonificador_fuerza");
                razas.add(new Raza(id, nombre, bonificador_vida, bonificador_fuerza));
                //System.out.println(id + "\t" + nombre + "\t" + bonificador_vida + "\t" + bonificador_fuerza);
            }
        } catch (SQLException e) {
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos");
            //System.out.println("Error en la conexión de la base de datos");
            //e.printStackTrace();
        }
    }
}
