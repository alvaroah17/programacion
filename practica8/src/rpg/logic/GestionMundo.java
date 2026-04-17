package rpg.logic;

import rpg.dao.*;
import rpg.exception.BDException;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NivelInsuficienteException;
import rpg.model.*;
import rpg.utils.LoggerCustom;

import java.util.*;

public class GestionMundo {
    private CiudadDAO ciudadDAO;
    private HabilidadesDAO habilidadesDAO;
    private InventarioDAO inventarioDAO;
    private ItemDAO itemDAO;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private ClaseDAO claseDAO;
    private Scanner sc;

    public GestionMundo() throws BDException {
        this.ciudadDAO = new CiudadDAO();
        this.habilidadesDAO = new HabilidadesDAO();
        this.inventarioDAO = new InventarioDAO();
        this.itemDAO = new ItemDAO();
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
        this.claseDAO=new ClaseDAO();
        sc=new Scanner(System.in);
    }

    public void cobroImpuestos(ArrayList<Personaje> listaPersonajes) throws BDException {
        Iterator<Personaje> it = listaPersonajes.iterator();

        while (it.hasNext()){
            Personaje personaje=it.next();

            personaje.setOro(personaje.getOro()-20);

            if (personaje.getOro()<0){
                it.remove();
                personajeDAO.actualizarCiudadNUllBD(personaje);
                LoggerCustom.escribirLog("DESTIERRO: " + personaje.getNombre() + " por impago.");
            }
            else {
                personajeDAO.actualizarOroBD(personaje);
                LoggerCustom.escribirLog("IMPUESTOS: " + personaje.getNombre() + " ha pagado 20 monedas.");
            }
        }
    }

    public void tienda() throws FondosInsuficientesException, BDException {
        int eleccionPersonaje =0;
        int eleccionItem=0;
        Personaje personajeCompra=null;
        Item itemAcomprar=null;
        ///INICIO DE ELECCIOM DE ITEM
        System.out.println("*************************************************");
        System.out.println("| ELIGE UN PERSONAJE AL QUE COMPRARLE LOS ITEMS |");
        System.out.println("*************************************************");
        for (Personaje personaje: personajeDAO.getPersonajes()){
            System.out.println("\nID\tNOMBRE\t\tORO\tNIVEL");
            System.out.println("---------------------------------------------");
            System.out.println(personaje.getId() + "\t" + personaje.getNombre() + "\t\t" + personaje.getOro() + "\t" +  personaje.getNivel());
        }
        System.out.println("┌──────────────────────────────────────────┐");
        System.out.println("│      ELIGE EL PERSONAJE POR SU ID        │");
        System.out.println("└──────────────────────────────────────────┘");
        System.out.print("ID => ");
        eleccionPersonaje = sc.nextInt();
        boolean personajeEncontrado=false;
        do {
            for (Personaje personaje: personajeDAO.getPersonajes()){
                if (eleccionPersonaje ==personaje.getId()){
                    personajeCompra=personaje;
                    personajeEncontrado=true;
                    break;
                }
            }
            if (personajeEncontrado==false){
                System.out.println("¡¡Ese ID no existe!!. Escribe otro ID:");
                eleccionPersonaje= sc.nextInt();
            }
        }while (personajeEncontrado==false);

        System.out.println(" - HAS ELEGIDO EL PERSONAJE: [ " + personajeCompra.getNombre().toUpperCase() + " ]");
        ///FIN DE ELECCION DE PERSONAJE
        //-----------------------------------------------------------------------------------------------------------
        ///INICIO DE ELECCIOM DE ITEM
        System.out.println("**********************************************************");
        System.out.println("| ELIGE EL ITEM  QUE COMPRARLE AL PERSONAJE SELECCIONADO |");
        System.out.println("**********************************************************");
        for (Item item : itemDAO.getItems()){
             System.out.println("\nID\tNOMBRE\t\tPRECIO\tTIPO\t\tATQ\tDEF");
             System.out.println("---------------------------------------------------------------------------");
             System.out.println(item.getId() + "\t" + item.getNombre() + "\t\t" + item.getPrecio_oro() + "\t" + item.getTipo() + "\t\t" + item.getBonificador_ataque() + "\t" + item.getBonificador_defensa());
         }
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│      ELIGE EL ITEM POR SU ID        │");
        System.out.println("└─────────────────────────────────────┘");
        System.out.print("ID => ");
        eleccionItem = sc.nextInt();
        boolean itemEncontrado=false;
        do {
            for (Item item:itemDAO.getItems()){
                if (eleccionItem ==item.getId()){
                    itemEncontrado=true;
                    if (personajeCompra.getOro()>=item.getPrecio_oro()){
                        itemAcomprar=item;
                        personajeCompra.setOro(personajeCompra.getOro()-itemAcomprar.getPrecio_oro());
                        break;
                    }
                    else {
                        LoggerCustom.escribirLog("FONDOS INSUFICIENTES:  " +
                                personajeCompra.getNombre() + " [ID: " + personajeCompra.getId() + "] | " +
                                "ORO: " + personajeCompra.getOro() + " | PRECIO ITEM: " + item.getPrecio_oro());

                        throw new FondosInsuficientesException("FONDOS INSUFICIENTES:  " +
                                personajeCompra.getNombre() + " [ID: " + personajeCompra.getId() + "] | " +
                                "ORO: " + personajeCompra.getOro() + " | PRECIO ITEM: " + item.getPrecio_oro());
                    }
                }
            }
            if (itemEncontrado==false){
                System.out.println("¡¡Ese ID no existe!!. Escribe otro ID:");
                eleccionItem = sc.nextInt();
            }
        }while(itemEncontrado==false);

        System.out.println(" - HAS ELEGIDO EL ITEM: [ " + itemAcomprar.getNombre().toUpperCase() + " ]" + "PARA EL PERSONAJE: "+personajeCompra.getNombre());

        personajeDAO.guardarCompraBD(personajeCompra, itemAcomprar);
    }

    public void comprobacionViajarCiudad(Personaje personaje, Ciudad ciudadNueva) throws NivelInsuficienteException, BDException {

        if (personaje.getNivel()>=ciudadNueva.getNivelMinimoAcceso()){
            personaje.setCiudad_actual(ciudadNueva);
            personajeDAO.actualizarCiudadViajeBD(personaje);
        }
        else {
            LoggerCustom.escribirLog("NIVEL INSUFICIENTE: El personaje "+personaje.getNombre()+" no alcanza el nivel minimo de acceso para la ciudad. " +
                    "| Nivel de "+personaje.getNombre()+": "+personaje.getNivel()+" | nivel requerido para viajar a esa ciudad: "+ciudadNueva.getNivelMinimoAcceso()+" |");
            throw new NivelInsuficienteException("NIVEL INSUFICIENTE: El personaje "+personaje.getNombre()+" no alcanza el nivel minimo de acceso para la ciudad. " +
                    "| Nivel de "+personaje.getNombre()+": "+personaje.getNivel()+" | nivel requerido para viajar a esa ciudad: "+ciudadNueva.getNivelMinimoAcceso()+" |");
        }
    }

    public void viajarCiudad() throws BDException {
        System.out.println("*********************************");
        System.out.println("|       VIAJAR A CIUDAD         |");
        System.out.println("*********************************");

        // Mostrar personajes
        System.out.println("\nID\tNOMBRE\t\tNIVEL\tCIUDAD ACTUAL");
        System.out.println("--------------------------------------------------");

        for (Personaje personaje : personajeDAO.getPersonajes()) {

            String nombreCiudad;

            if (personaje.getCiudad_actual() != null) {
                nombreCiudad = personaje.getCiudad_actual().getNombre();
            } else {
                nombreCiudad = "Desterrado";
            }

            System.out.println(personaje.getId() + "\t" + personaje.getNombre() + "\t\t"
                    + personaje.getNivel() + "\t" + nombreCiudad);
        }

        // Elegir personaje
        Personaje personajeElegido = null;

        while (personajeElegido == null) {

            System.out.print("Elige el personaje por su ID => ");
            int idPersonaje = sc.nextInt();

            for (Personaje personaje : personajeDAO.getPersonajes()) {
                if (personaje.getId() == idPersonaje) {
                    personajeElegido = personaje;
                    break;
                }
            }

            if (personajeElegido == null) {
                System.out.println("¡¡Ese ID no existe!!");
            }
        }

        // Mostrar ciudades
        System.out.println("\nID\tNOMBRE\t\tNIVEL MÍNIMO");
        System.out.println("--------------------------------------------------");

        for (Ciudad ciudad : ciudadDAO.getCiudades()) {
            System.out.println(ciudad.getId() + "\t" + ciudad.getNombre() + "\t\t"
                    + ciudad.getNivelMinimoAcceso());
        }

        // Elegir ciudad
        Ciudad ciudadElegida = null;

        while (ciudadElegida == null) {

            System.out.print("Elige la ciudad destino por su ID => ");
            int idCiudad = sc.nextInt();

            for (Ciudad ciudad : ciudadDAO.getCiudades()) {
                if (ciudad.getId() == idCiudad) {
                    ciudadElegida = ciudad;
                    break;
                }
            }

            if (ciudadElegida == null) {
                System.out.println("¡¡Ese ID no existe!!.");
            }
        }

        // Intentar viajar
        try {
            comprobacionViajarCiudad(personajeElegido, ciudadElegida);

            System.out.println("\n " + personajeElegido.getNombre() + " ha viajado a "
                    + ciudadElegida.getNombre());

        } catch (NivelInsuficienteException e) {

            System.out.println("\n " + e.getMessage());
        }
    }

    public void crearPersonaje() throws BDException {
        System.out.println("*********************************");
        System.out.println("|      CREAR NUEVO PERSONAJE    |");
        System.out.println("*********************************");

        System.out.print("Introduce el nombre del personaje: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        // Mostrar razas
        System.out.println("\nID\tNOMBRE\t\tBON.VIDA\tBON.FUERZA");
        System.out.println("--------------------------------------------------");

        for (Raza raza : razaDAO.getRazas()) {
            System.out.println(raza.getId() + "\t" + raza.getNombre() + "\t\t"
                    + raza.getBonificadorVida() + "\t\t" + raza.getBonificadorFuerza());
        }

        // Elegir raza
        Raza razaElegida = null;

        while (razaElegida == null) {

            System.out.print("Elige una raza por su ID => ");
            int idRaza = sc.nextInt();

            for (Raza raza : razaDAO.getRazas()) {
                if (raza.getId() == idRaza) {
                    razaElegida = raza;
                    break;
                }
            }

            if (razaElegida == null) {
                System.out.println("¡¡Ese ID no existe!!.");
            }
        }

        // Mostrar clases
        System.out.println("\nID\tNOMBRE");
        System.out.println("--------------------");

        for (Clase clase : claseDAO.getClases()) {
            System.out.println(clase.getId() + "\t" + clase.getNombre());
        }

        // Elegir clase
        Clase claseElegida = null;

        while (claseElegida == null) {

            System.out.print("Elige una clase por su ID => ");
            int idClase = sc.nextInt();

            for (Clase clase : claseDAO.getClases()) {
                if (clase.getId() == idClase) {
                    claseElegida = clase;
                    break;
                }
            }

            if (claseElegida == null) {
                System.out.println("¡¡Ese ID no existe!!.");
            }
        }

        // Ciudad inicial que acepta nivel 1
        Ciudad ciudadInicial = ciudadDAO.getCiudades().get(0);

        personajeDAO.crearPersonajeBD(nombre, razaElegida, claseElegida, ciudadInicial);

        System.out.println("\n Personaje [ " + nombre+ " ] creado en "
                + ciudadInicial.getNombre() + "!");
    }
    public void mostrarEstadisticas() throws BDException {
        ArrayList<Personaje> lista = personajeDAO.getPersonajes();

        /// TOP 3 JUGADORES MÁS RICOS - ORDENAMOS CON COLLECTIONS.SORT Y COMPARATOR
        ArrayList<Personaje> ordenados = new ArrayList<>(lista);
        Collections.sort(ordenados, new Comparator<Personaje>() {
            @Override
            public int compare(Personaje p1, Personaje p2) {
                return Integer.compare(p2.getOro(), p1.getOro());
            }
        });

        System.out.println("=============================");
        System.out.println("   TOP 3 JUGADORES MÁS RICOS");
        System.out.println("=============================");
        for (int i = 0; i < 3; i++) {
            if (i < ordenados.size()) {
                System.out.println((i + 1) + ") " + ordenados.get(i).getNombre()
                        + " --> " + ordenados.get(i).getOro() + " monedas de oro");
            }
        }

        /// CENSO DE CLASES, CONTAMOS CUANTOS PERSONAJES HAY DE CADA CLASE CON UN HASHMAP
        HashMap<String, Integer> censoPorClase = new HashMap<>();
        for (int i = 0; i < lista.size(); i++) {
            String nombreClase = lista.get(i).getClase().getNombre();
            if (censoPorClase.containsKey(nombreClase)) {
                censoPorClase.put(nombreClase, censoPorClase.get(nombreClase) + 1);
            } else {
                censoPorClase.put(nombreClase, 1);
            }
        }

        System.out.println("\n=============================");
        System.out.println("      CENSO DE CLASES");
        System.out.println("=============================");
        for (String clase : censoPorClase.keySet()) {
            System.out.println(clase + ": " + censoPorClase.get(clase) + " personaje");
        }
    }
}
