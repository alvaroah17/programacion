import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bloque2 {
    /// |----------------------------|
    /// | DESAFIOS DE LÓGICA ANIDADA |
    /// |----------------------------|
    //EJERCICIO 7---------------------------------------------
    private ArrayList<String> miembrosGremio1;
    private ArrayList<String> miembrosGremio2;
    private Map<String, ArrayList<String>> gremioMiembros;
    //EJERCICIO 8---------------------------------------------
    private HashSet<String> objetosMounstro;
    private Map<String, HashSet<String>> mounstroConObjetos;
    //EJERCICIO 9---------------------------------------------
    private HashMap<String, HashMap<String, Integer>> jugadorYsusEstadisticas;
    public Bloque2(){
        /// 7. El Repositorio de Gremios
        this.miembrosGremio1=new ArrayList<>();
        this.miembrosGremio1.add("Mago1");
        this.miembrosGremio1.add("Mago2");
        this.miembrosGremio1.add("Mago3");
        this.gremioMiembros=new HashMap<>();
        this.gremioMiembros.put("Magos",miembrosGremio1 );
        this.miembrosGremio2=new ArrayList<>();
        this.miembrosGremio2.add("Bardo1");
        this.miembrosGremio2.add("Bardo2");
        this.miembrosGremio2.add("Bardo3");
        this.gremioMiembros.put("Bardos",miembrosGremio2 );
        /// 8. El Sistema de Loot (Botín)
        this.mounstroConObjetos=new HashMap<>();
        this.objetosMounstro=new HashSet<>();
        this.objetosMounstro.add("Espada oxidada");
        this.objetosMounstro.add("Casco quebrado");
        this.objetosMounstro.add("Cadenas mohosas");
        this.objetosMounstro.add("Espada oxidada");
        this.mounstroConObjetos.put("Trasgo", objetosMounstro);
        /// 9. El Sistema de Loot (Botín)
        this.jugadorYsusEstadisticas=new HashMap<>();
        this.jugadorYsusEstadisticas.put("Conan", estadisticasBaseJugador());
        this.jugadorYsusEstadisticas.get("Conan").put("Fuerza", this.jugadorYsusEstadisticas.get("Conan").get("Fuerza")+2);

    }
    /// -----------------------------------------FUNCIONES-------------------------------------------------------
    /// FUNCION EJ.9
    public HashMap<String, Integer> estadisticasBaseJugador(){
        HashMap<String, Integer> estadisticasBase=new HashMap<>();
        estadisticasBase.put("Fuerza", 20);
        estadisticasBase.put("Destreza", 25);
        return estadisticasBase;
    }
    public void mostrarEstadisticasJugador(){
        System.out.println(jugadorYsusEstadisticas);
    }
    /// FUNCION EJ.7
    public void mostrarMiembrosGremio(){
        System.out.println(this.gremioMiembros.get("Magos"));
    }
    /// FUNCION EJ.8
    public void mostrarObjetosMounstrosNoRepetidos(){
        System.out.println(this.mounstroConObjetos);
    }

}
