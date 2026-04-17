package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Inventario;
import rpg.utils.LoggerCustom;

import java.sql.*;
import java.util.ArrayList;

public class InventarioDAO {
    private ArrayList<Inventario> inventarios;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public InventarioDAO() throws BDException {
        this.inventarios = new ArrayList<>();
        inConexionDB();
    }

    public void inConexionDB() throws BDException {
        /// CONEXION CON LA TABLA DE LA BASE DE DATOS
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM inventarios")) {

            while (resultset.next()) {
                int idPersonaje = resultset.getInt("id_personaje");
                int idItem = resultset.getInt("id_item");
                int cantidad = resultset.getInt("cantidad");

                // He ajustado la creación del objeto a tus nuevos atributos
                inventarios.add(new Inventario(idPersonaje, idItem, cantidad));
            }
        } catch (SQLException e) {
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos"+e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos"+e.getMessage());
        }
    }
}
