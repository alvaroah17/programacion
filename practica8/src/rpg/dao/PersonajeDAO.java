package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Personaje;
import rpg.model.Raza;

import java.sql.*;
import java.util.ArrayList;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public PersonajeDAO() throws BDException{
        this.personajes=new ArrayList<>();
        conexionDB();
    }

    public void conexionDB() throws BDException{
        /*try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery("SELECT * FROM personajes")) {
            while (resultset.next()) {

                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int nivel = resultset.getInt("nivel");
                int oro = resultset.getInt("oro");
                int vida_actual = resultset.getInt("vida_actual");
                Raza raza = resultset.getRaza("id_raza");

                personajes.add(new Personaje(id, nombre, nivel, oro, vida_actual, raza, clase, ciudad);
            }
        } catch (SQLException e) {
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos");
        }*/
    }
}
