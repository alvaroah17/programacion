package rpg.dao;

import rpg.exception.BDException;
import rpg.model.*;
import rpg.utils.LoggerCustom;

import java.sql.*;
import java.util.ArrayList;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;

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
                Personaje personaje = new Personaje(id, nombre, nivel, oro, vida, raza, clase, ciudad);
                cargarInventario(personaje);
                cargarHabilidades(personaje);
                personajes.add(personaje);
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

    public void actualizarCiudadNUllBD(Personaje personaje) throws BDException {
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
    public void cargarInventario(Personaje personaje) throws BDException{
        String sql=
                "SELECT i.id AS id_item, i.nombre, i.tipo, i.precio_oro, i.bonificador_ataque, i.bonificador_defensa, inv.cantidad " +
                        "FROM Items i " +
                        "JOIN Inventarios inv ON i.id = inv.id_item " +
                        "WHERE inv.id_personaje = ?";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, personaje.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id_item=resultSet.getInt("id_item");
                String nombreItem=resultSet.getString("nombre");
                String tipo = resultSet.getString("tipo");
                int precioOro= resultSet.getInt("precio_oro");
                int bonificadorAtaque = resultSet.getInt("bonificador_ataque");
                int bonificadorDefensa= resultSet.getInt("bonificador_defensa");

                int cantidadItem = resultSet.getInt("cantidad");

                Item itemsBD = new Item(id_item, nombreItem, tipo, precioOro, bonificadorAtaque, bonificadorDefensa);
                personaje.aniardirItem(itemsBD, cantidadItem);
            }
        }catch (SQLException e){
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos --> "+ e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos --> "+ e.getMessage());
        }
    }

    public void cargarHabilidades(Personaje personaje) throws BDException{
        String sql = "SELECT h.id, h.nombre, h.dano_base, h.usos_maximos, h.id_clase " +
                "FROM Habilidades h " +
                "JOIN Personajes_Habilidades p_h ON h.id = p_h.id_habilidad " +
                "WHERE p_h.id_personaje = ?";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, personaje.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while ( resultSet.next()){
                int id_habilidades = resultSet.getInt("id");
                String nombreHabilidd = resultSet.getString("nombre");
                int danioBase = resultSet.getInt("dano_base");
                int usosMaximos = resultSet.getInt("usos_maximos");
                int id_clase = resultSet.getInt("id_clase");

                 Habilidad habilidadesBD = new Habilidad(id_habilidades, nombreHabilidd, danioBase, usosMaximos, id_clase);
                personaje.aniadirHabilidad(habilidadesBD);
            }
        }catch (SQLException e){
            LoggerCustom.escribirLog("ERROR: Ha ocurrido un error en la conexion con la base de datos --> "+ e.getMessage());
            throw new BDException("ERROR: Ha ocurrido un error en la conexion con la base de datos --> "+ e.getMessage());
        }
    }

    public void actualizarCiudadViajeBD( Personaje personaje) throws BDException{
        String sql= "UPDATE Personajes SET id_ciudad_actual = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, personaje.getCiudad_actual().getId());
            preparedStatement.setInt(2,personaje.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            LoggerCustom.escribirLog("ERROR: Al cambiar de ciudad en la BD");
            throw new BDException("ERROR: Al cambiar de ciudad en la BD");
        }
    }
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
}