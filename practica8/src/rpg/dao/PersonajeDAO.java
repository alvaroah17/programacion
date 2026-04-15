package rpg.dao;

import rpg.exception.BDException;
import rpg.model.Ciudad;
import rpg.model.Clase;
import rpg.model.Personaje;
import rpg.model.Raza;
import rpg.utils.LoggerCustom;

import java.sql.*;
import java.util.ArrayList;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;
    public LoggerCustom loggerCustom;

    private String URL="jdbc:postgresql://localhost:5432/XRPG";
    private String USER="xrpg_user";
    private String PASSWD="xrpg_password";

    public PersonajeDAO() throws BDException{
        this.personajes=new ArrayList<>();
        pConexionDB();
    }

    public void pConexionDB() throws BDException{
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
             Statement statement = connection.createStatement();
             ResultSet resultset = statement.executeQuery(
                     "SELECT p.id, p.nombre, p.nivel, p.oro, p.vida_actual, " +
                             "raz.id AS razId, raz.nombre AS razNombre, raz.bonificador_vida, raz.bonificador_fuerza, " +
                             "clas.id AS clasId, clas.nombre AS clasNombre, " +
                             "ciu.id AS ciuId, ciu.nombre AS ciuNombre, ciu.nivel_minimo_acceso " +
                             "FROM Personajes p " +
                             "JOIN Razas raz ON p.id_raza = raz.id " +
                             "JOIN Ciudades ciu ON p.id_ciudad_actual = ciu.id " +
                             "JOIN Clases_RPG clas ON p.id_clase = clas.id"
             )) {

            while (resultset.next()) {
                // --- DATOS DEL PERSONAJE ---
                int id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                int nivel = resultset.getInt("nivel");
                int oro = resultset.getInt("oro");
                int vida = resultset.getInt("vida_actual");

                // --- DATOS DE LA RAZA (Usando los alias del SELECT) ---
                int idRaz = resultset.getInt("razId");
                String nomRaz = resultset.getString("razNombre");
                int bonificador_vida = resultset.getInt("bonificador_vida");
                int bonificador_fuerza = resultset.getInt("bonificador_fuerza");
                Raza raza = new Raza(idRaz, nomRaz, bonificador_vida, bonificador_fuerza);

                // --- DATOS DE LA CLASE ---
                int idClas = resultset.getInt("clasId");
                String nomClas = resultset.getString("clasNombre");
                Clase clase = new Clase(idClas, nomClas);

                // --- DATOS DE LA CIUDAD ---
                int idCiu = resultset.getInt("ciuId");
                String nomCiu = resultset.getString("ciuNombre");
                int nivAcceso = resultset.getInt("nivel_minimo_acceso");
                Ciudad ciudad = new Ciudad(idCiu, nomCiu, nivAcceso);


                // --- AÑADIR AL PERSONAJE ---
                personajes.add(new Personaje(id, nombre, nivel, oro, vida, raza, clase, ciudad));
            }
        } catch (SQLException e) {
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos --> "+ e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos --> "+ e.getMessage());
        }
    }

    public void actualizarOroBD (Personaje personaje) throws BDException {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Personajes SET oro = ? WHERE id = ?")){
            preparedStatement.setInt(1, personaje.getOro());
            preparedStatement.setInt(2, personaje.getId() );
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error con la base de datos al actualizar el oro del personaje con nombre: "
                    + personaje.getNombre() + " y con id: " + personaje.getId() + " --> " + e.getMessage());
            throw new BDException ("ERROR: Ha ocurrido un error con la base de datos al actualizar el oro del personaje con nombre: "
                    + personaje.getNombre() + " y con id: " + personaje.getId() + " --> " + e.getMessage());
        }
    }

    public void actualizarCiudadBD (Personaje personaje) throws BDException {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Personajes SET id_ciudad_actual = ? WHERE id = ?")){
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, personaje.getId() );
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error con la base de datos al actualizar la ciudad del personaje con nombre: "
                    + personaje.getNombre() + " y con id: " + personaje.getId() + " --> " + e.getMessage());
            throw new BDException ("ERROR: Ha ocurrido un error con la base de datos al actualizar la ciudad del personaje con nombre: "
                    + personaje.getNombre() + " y con id: " + personaje.getId() + " --> " + e.getMessage());
        }
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}