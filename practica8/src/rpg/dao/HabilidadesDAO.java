package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Habilidad;
import rpg.utils.LoggerCustom;

import java.sql.*;
import java.util.ArrayList;

public class HabilidadesDAO {
    private ArrayList<Habilidad> habilidades;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public HabilidadesDAO() throws BDException {
        this.habilidades =new ArrayList<>();
        hConexionDB();
    }

    public void hConexionDB() throws BDException {
        /// CONEXION CON LA TABLA HABILIDAD DE LA BASE DE DATOS
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM habilidades")) {

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int dañoBase = resultset.getInt("dano_Base");
                int usosMaximos = resultset.getInt("usos_maximos");
                int idClase = resultset.getInt("id_Clase");

                habilidades.add(new Habilidad(id, nombre, dañoBase, usosMaximos, idClase));
            }
        } catch (SQLException e) {
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos"+e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos"+e.getMessage());
        }
    }
}
