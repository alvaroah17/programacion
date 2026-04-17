package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Ciudad;
import rpg.utils.LoggerCustom;

import java.sql.*;
import java.util.ArrayList;

public class CiudadDAO {
    private ArrayList<Ciudad> ciudades;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public CiudadDAO() throws BDException {
        this.ciudades = new ArrayList<>();
        cConexionDB();
    }

    public void cConexionDB() throws BDException {
        /// CONEXION CON LA TABLA CIUDAD DE LA BASE DE DATOS
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM ciudades")) {

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int nivelMinimoAcceso = resultset.getInt("nivel_minimo_acceso");

                ciudades.add(new Ciudad(id, nombre, nivelMinimoAcceso));
            }
        } catch (SQLException e) {
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos"+e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos"+e.getMessage());
        }
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }
}
