package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAO {
    private ArrayList<Item> items;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public ItemDAO() throws BDException {
        this.items = new ArrayList<>();
        itConexionDB();
    }

    public void itConexionDB() throws BDException {
        /// CONEXION CON LA TABLAR RAZA DE LA BASE DE DATOS
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM items")) {
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                String tipo = resultset.getString("tipo");
                int precio_oro = resultset.getInt("precio_oro");
                int bonificador_ataque = resultset.getInt("bonificador_ataque");
                int bonificador_defensa = resultset.getInt("bonificador_defensa");
                items.add(new Item(id, nombre, tipo, precio_oro, bonificador_ataque, bonificador_defensa));
                //System.out.println(id + "\t" + nombre + "\t" + bonificador_vida + "\t" + bonificador_fuerza);
            }
        } catch (SQLException e) {
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos");
            //System.out.println("Error en la conexión de la base de datos");
            //e.printStackTrace();
        }
    }
}
