package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Inventario;

import java.sql.*;
import java.util.ArrayList;

public class InventarioDAO {
    private ArrayList<Inventario> inventarios;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public void conexionDB() throws BDException {
        /// CONEXION CON LA TABLA DE LA BASE DE DATOS
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM nombre_de_tu_tabla")) {

            while (resultset.next()) {
                int idPersonaje = resultset.getInt("idPersonaje");
                int idItem = resultset.getInt("idItem");
                int cantidad = resultset.getInt("cantidad");

                // He ajustado la creación del objeto a tus nuevos atributos
                inventarios.add(new Inventario(idPersonaje, idItem, cantidad));
            }
        } catch (SQLException e) {
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos");
        }
    }
}
