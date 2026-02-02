import java.util.*;

public class Bloque1 {
    private ArrayList<String> registroCombate;
    private Set<String> nombreVillanos;
    private Map<String, Integer> aventurero;
    public Bloque1 () {
        //1. El Registro de Muertes
        this.registroCombate =new ArrayList<>();
        this.registroCombate.add("Orco derrotado");
        this.registroCombate.add("Pocion usada");
        this.registroCombate.add("Vida curada");
        this.registroCombate.add("Paladin derrotado");
        this.registroCombate.add("Ataque defendido");
        //--------------------------------------------
        //2. El Censo Único:
        this.nombreVillanos=new HashSet<>();
        this.nombreVillanos.add("Morgoth");
        this.nombreVillanos.add("Morgoth");
        //--------------------------------------------
        //3. Bolsa de Oro
        this.aventurero=new HashMap<>();
        this.aventurero.put("Mondrigon, el intrepido", 100);
        this.aventurero.put("Palomo, el volador", 100);
        this.aventurero.put("Cristiano, el remate", 100);
        //--------------------------------------------
    }
    public void mostrar3erEvento1 (){
        System.out.println("ESTE ES EL 3er EVENTO = "+this.registroCombate.get(2));
    }

    public void mostrarNombreVillanos2 (){
        System.out.println("NOMBRE DE VILLANOS = "+this.nombreVillanos.size());
    }
}