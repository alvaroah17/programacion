package rpg.logic;

import rpg.dao.*;
import rpg.exception.BDException;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.NIvelInsuficienteException;
import rpg.model.Ciudad;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.LoggerCustom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionMundo {
    private CiudadDAO ciudadDAO;
    private HabilidadesDAO habilidadesDAO;
    private InventarioDAO inventarioDAO;
    private ItemDAO itemDAO;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private Scanner sc;

    public GestionMundo() throws BDException {
        this.ciudadDAO = new CiudadDAO();
        this.habilidadesDAO = new HabilidadesDAO();
        this.inventarioDAO = new InventarioDAO();
        this.itemDAO = new ItemDAO();
        this.personajeDAO = new PersonajeDAO();
        this.razaDAO = new RazaDAO();
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

    public void viajarCiudad (Personaje personaje, Ciudad ciudadNueva) throws NIvelInsuficienteException, BDException {

        if (personaje.getNivel()>=ciudadNueva.getNivelMinimoAcceso()){
            personaje.setCiudad_actual(ciudadNueva);
            personajeDAO.actualizarCiudadViajeBD(personaje);
        }
        else {
            LoggerCustom.escribirLog("NIVEL INSUFICIENTE: El personaje "+personaje.getNombre()+" no alcanza el nivel minimo de acceso para la ciudad. " +
                    "| Nivel de "+personaje.getNombre()+": "+personaje.getNivel()+" | nivel requerido para viajar a esa ciudad: "+ciudadNueva.getNivelMinimoAcceso()+" |");
            throw new NIvelInsuficienteException("NIVEL INSUFICIENTE: El personaje "+personaje.getNombre()+" no alcanza el nivel minimo de acceso para la ciudad. " +
                    "| Nivel de "+personaje.getNombre()+": "+personaje.getNivel()+" | nivel requerido para viajar a esa ciudad: "+ciudadNueva.getNivelMinimoAcceso()+" |");
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
}
