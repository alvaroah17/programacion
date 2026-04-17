package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Clase;

import java.sql.*;
import java.util.ArrayList;

public class ClaseDAO {
    private ArrayList<Clase> clases;

    private String URL = "jdbc:postgresql://localhost:5432/XRPG";
    private String USER = "xrpg_user";
    private String PASSWD = "xrpg_password";

    public ClaseDAO() throws BDException {
        this.clases = new ArrayList<>();
        cConexionDB();
    }

    public void cConexionDB() throws BDException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM Clases_RPG")) {

            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                clases.add(new Clase(id, nombre));
            }
        } catch (SQLException e) {
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos ");
        }
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }
}
