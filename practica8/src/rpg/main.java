package rpg;

import rpg.dao.RazaDAO;
import rpg.exception.BDException;
import rpg.utils.LoggerCustom;

import java.sql.*;

public class main {
    LoggerCustom loggerCustom=new LoggerCustom();
    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public void main(String[] args) throws BDException {
        /// CONEXION CON LA TABLAR RAZA DE LA BASE DE DATOS
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM razas")) {
            while (resultset.next()) {
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int bonificador_vida = resultset.getInt("bonificador_vida");
                int bonificador_fuerza = resultset.getInt("bonificador_fuerza");
                //Raza raza = new Raza(id, nombre, bonificador_vida, bonificador_fuerza);
                System.out.println(id + "\t" + nombre + "\t" + bonificador_vida + "\t" + bonificador_fuerza);
            }
        } catch (SQLException e) {
            loggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos"+" --> " +e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos"+" --> " +e.getMessage());
            //e.printStackTrace();
        }
    }
}
