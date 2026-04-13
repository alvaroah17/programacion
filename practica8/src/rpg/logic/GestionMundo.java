package rpg.logic;

import rpg.dao.*;
import rpg.model.Personaje;

import java.util.ArrayList;

public class GestionMundo {
    private CiudadDAO ciudadDAO;
    private HabilidadesDAO habilidadesDAO;
    private InventarioDAO inventarioDAO;
    private ItemDAO itemDAO;
    private PersonajeDAO personajeDAO;
    private RazaDAO razaDAO;


    public GestionMundo(CiudadDAO ciudadDAO, HabilidadesDAO habilidadesDAO, InventarioDAO inventarioDAO, ItemDAO itemDAO, PersonajeDAO personajeDAO, RazaDAO razaDAO) {
        this.ciudadDAO = ciudadDAO;
        this.habilidadesDAO = habilidadesDAO;
        this.inventarioDAO = inventarioDAO;
        this.itemDAO = itemDAO;
        this.personajeDAO = personajeDAO;
        this.razaDAO = razaDAO;
    }

    public ArrayList<Personaje> cobroImpuestos(){

    }

    public void comprobarOro (Personaje personaje, int cantidadComprobada){
        if (personaje.getOro()<cantidadComprobada){
            //throw new SaldoInsuficienteException
        }else {
            personaje.setOro(personaje.getOro()-cantidadComprobada);
        }
    }

    public void comprobarNivel (Personaje personaje){

    }
}
