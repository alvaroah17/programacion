import java.util.*;

public class Bloque1 {
    ///|---------------------|
    ///| OPERACIONES BASICAS |
    ///|---------------------|
    private ArrayList<String> registroCombate;
    private Set<String> nombreVillanos;
    private Map<String, Integer> aventurero;
    private Map<String, Double> hechizosMana;

    public Bloque1 () {
        ///1. El Registro de Muertes
        this.registroCombate =new ArrayList<>();
        this.registroCombate.add("Orco derrotado");
        this.registroCombate.add("Pocion usada");
        this.registroCombate.add("Vida curada");
        this.registroCombate.add("Paladin derrotado");
        this.registroCombate.add("Ataque defendido");
        //--------------------------------------------
        ///2. El Censo Único:
        this.nombreVillanos=new HashSet<>();
        this.nombreVillanos.add("Morgoth");
        this.nombreVillanos.add("Morgoth");

        //--------------------------------------------
        ///3. Bolsa de Oro
        this.aventurero=new HashMap<>();
        this.aventurero.put("Mondrigon, el intrepido", 100);
        this.aventurero.put("Palomo, el volador", 80);
        this.aventurero.put("Cristiano, el remate", 150);
        //--------------------------------------------
        ///5. Mercado de Hechizos
        this.hechizosMana=new HashMap<>();
        this.hechizosMana.put("Llamas Errantes",35.00 );
        this.hechizosMana.put("Invocación del Cuervo Negro",40.00 );
        this.hechizosMana.put("Tormenta de Areana",45.00 );
        this.hechizosMana.put("Meteorito Carmesí",55.00 );
        this.hechizosMana.put("Ritual del Vacío",60.00 );
        this.hechizosMana.put("Tempestad Celestial",65.00 );
    }

    ///4.Limpieza del Calabozo
    public void eliminarEventoMasAntiguoYaniaadirDragonAvistado (){
        this.registroCombate.removeFirst();
        this.registroCombate.add("Dragón avistado");
    }
    ///5.Mercado de hechizos
    public void mostrarHechizosManaMayores50(){
        for (String Hechizo: hechizosMana.keySet()){
            if (hechizosMana.get(Hechizo)>50.0){
                System.out.println(Hechizo+" cuesta "+hechizosMana.get(Hechizo)+" de Mana");
            }
        }
    }
    ///6. Expulsión del Reino
    public void verificarHashSetVillanos (){
        this.nombreVillanos.removeIf(villano->villano.equals("Sauron"));
    }

    /// -----------------------------------------FUNCIONES-------------------------------------------------------
    /// FUNCION EJ.1
    public void mostrar3erEvento1 (){
        System.out.println("ESTE ES EL 3er EVENTO = "+this.registroCombate.get(2));
    }
    /// FUNCION EJ.2
    public void mostrarNombreVillanos2 (){
        System.out.println("NOMBRE DE VILLANOS = "+this.nombreVillanos.size());
    }
    /// FUNCION EJ.3
    public void mostrarOroAventurero (String nombreAventurero){
        System.out.println("Oro del aventurero/a: " + nombreAventurero+ " : "+this.aventurero.get(nombreAventurero));
    }
}