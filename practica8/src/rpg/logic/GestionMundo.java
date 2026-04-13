package rpg.logic;

import rpg.dao.*;
import rpg.exception.BDException;
import rpg.exception.FondosInsuficientesException;
import rpg.model.Personaje;
import rpg.utils.LoggerCustom;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionMundo {
    private CiudadDAO ciudadDAO;
    private HabilidadesDAO habilidadesDAO;
    private InventarioDAO inventarioDAO;
    private ItemDAO itemDAO;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;
    private LoggerCustom loggerCustom;


    public GestionMundo(CiudadDAO ciudadDAO, HabilidadesDAO habilidadesDAO, InventarioDAO inventarioDAO, ItemDAO itemDAO, PersonajeDAO personajeDAO, RazaDAO razaDAO, LoggerCustom loggerCustom) {
        this.ciudadDAO = ciudadDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.inventarioDAO = inventarioDAO;
        this.itemDAO = itemDAO;
        this.personajeDAO = personajeDAO;
        this.razaDAO = razaDAO;
        this.loggerCustom=new LoggerCustom();
    }

    public void cobroImpuestos(ArrayList<Personaje> listaPersonajes) throws BDException {
        Iterator<Personaje> it = listaPersonajes.iterator();

        while (it.hasNext()){
            Personaje personaje=it.next();

            personaje.setOro(personaje.getOro()-20);

            if (personaje.getOro()<0){
                it.remove();
                personajeDAO.actualizarCiudadBD(personaje);
                LoggerCustom.escribirLog("DESTIERRO: " + personaje.getNombre() + " por impago.");
            }
            else {
                personajeDAO.actualizarOroBD(personaje);
                LoggerCustom.escribirLog("IMPUESTOS: " + personaje.getNombre() + " ha pagado 20 monedas.");
            }
        }
    }

    public void comprobarOro (Personaje personaje, int cantidadComprobada) throws FondosInsuficientesException {
        if (personaje.getOro()<cantidadComprobada){
            loggerCustom.escribirLog("ERROR: "+personaje.getNombre()+"no tiene suficiente oro");
            throw new FondosInsuficientesException("ERROR: "+personaje.getNombre()+"no tiene suficiente oro");
        }else {
            personaje.setOro(personaje.getOro()-cantidadComprobada);
        }
    }

    public void comprobarNivel (Personaje personaje){

    }
}
