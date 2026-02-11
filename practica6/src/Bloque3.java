import java.util.*;

public class Bloque3 {
    /// ATRIBUTOS
    // EJERCICIO. 11
    HashMap<String, Double> objetosPrecio;
    HashMap<String, ArrayList<String>> ciudadesObjetosEnStock;
    //EJERCICIO. 12
    HashMap<String, Boolean> habilidades;
    HashMap<String, HashMap<String, Boolean>> clasesYhashMapDeHabilidades;
    //EJERCICIO. 13
    HashMap<String, ArrayList<HashSet<String>>> historialIncursiones;
    /// CONSTRUCTOR
    public Bloque3(){
        /// 11. El Sistema de Comercio y Precios Dinámicos
        //Rellenar HashMap de Objetos/Precio
        this.objetosPrecio=new HashMap<>();
        this.objetosPrecio.put("Espada de Hierro", 50.0);
        this.objetosPrecio.put("Arco Élfico", 80.0);
        this.objetosPrecio.put("Poción de Vida", 20.0);
        this.objetosPrecio.put("Armadura de Acero", 120.00);
        this.objetosPrecio.put("Escudo Protector", 70.0);
        this.objetosPrecio.put("Anillo Mágico", 150.0);
        this.objetosPrecio.put("Botas de Velocidad", 30.0);
        this.objetosPrecio.put("Casco de Guerrero", 60.0);
        //-------------------------------------------------------
        //Rellenar HashMap de Ciudades/Objetos en stock
        this.ciudadesObjetosEnStock=new HashMap<>();
        this.ciudadesObjetosEnStock.put("Madrid", new ArrayList<>(List.of("Espada de Hierro", "Arco Élfico", "Poción de Vida")));
        this.ciudadesObjetosEnStock.put("Sevilla", new ArrayList<>(List.of("Espada de Hierro, Arco Élfico, Poción de Vida, Armadura de Acero", "Escudo Protector", "Anillo Mágico", "Botas de Velocidad", "Casco de Guerrero")));
        this.ciudadesObjetosEnStock.put("Barcelona", new ArrayList<>(List.of("Espada de Hierro", "Arco Élfico")));
        //-------------------------------------------------------
        /// 12. El Sistema de Comercio y Precios Dinámicos
        this.habilidades=new HashMap<>();
        this.habilidades.put("Enfoque", true);
        this.habilidades.put("Golpe Divino", false);
        this.clasesYhashMapDeHabilidades=new HashMap<>();
        this.clasesYhashMapDeHabilidades.put("Paladin", habilidades);
        /// 13. El Historial de Incursiones (Raid Tracker)
        ArrayList<HashSet<String>> raidCueva=new ArrayList<>();
        this.historialIncursiones=new HashMap<>();
        raidCueva.add(new HashSet<>(List.of("Mondri", "Palomo", "Josemi")));
        historialIncursiones.put("Cueva",raidCueva);

        ArrayList<HashSet<String>> raidMontania=new ArrayList<>();
        raidMontania.add(new HashSet<>(List.of("Palomo", "Cristiano", "Liendre")));
        historialIncursiones.put("Monstaña",raidMontania);

        ArrayList<HashSet<String>> raidCastillo=new ArrayList<>();
        raidCastillo.add(new HashSet<>(List.of("Mondri", "Palomo", "Liendre")));
        historialIncursiones.put("Castillo",raidCastillo);


    }
    /// FUNCIONES
    /// EJERCICIO 11
    public void descuentoSiHayMasDe5ObjetosEnCiudad(String ciudad){
        if (this.ciudadesObjetosEnStock.get(ciudad).size()>=5){
            System.out.println("Se ha aplicado el impuesto de lujo para la ciudad "+ ciudad);
            System.out.println("----------------------------------------------------------------------------");
            for (String objeto:this.objetosPrecio.keySet()){
                System.out.println("Precio antes del descuento para el objeto "+objeto+": "+objetosPrecio.get(objeto));
                this.objetosPrecio.put(objeto, this.objetosPrecio.get(objeto)+this.objetosPrecio.get(objeto)*0.1);
                System.out.println("Precio despues del descuento: "+objetosPrecio.get(objeto));
                System.out.println("----------------------------------------------------------------------------");
            }
            return;
        }
        System.out.println("La ciudad no tiene mas de 5 item por lo que no se aplica el impuesto de lujo");
    }
    ///EJERCICIO 12
    public void comprobarDesbloqueoGolpeDivino(String jugador){
        HashMap<String, Boolean> comprobacion=clasesYhashMapDeHabilidades.get(jugador);
        if (comprobacion.get("Enfoque")==false){
            System.out.println("No se puede utilizar la habilidad Golpe Divino");
        }
        if (comprobacion.get("Enfoque")==true){
            comprobacion.put("Golpe Divino", true);
            System.out.println("Usa la habilidad Golpe Divino");
        }
    }
    /// EJERCICIO 13
    public void historialEnMazmorras(){
        Map<String, Integer> contadorJugadores = new HashMap<>();
        String jugadorMasAparecido = null;
        int contadorJugadorMasAparecido = 0;
        for (ArrayList<HashSet<String>> raids : historialIncursiones.values()) {
            //Se recorren los valores ArrayList<HashSet<String>> del HashMap historialIncursiones
            //Recorremos los valores HashSet<String> de raids
            for (HashSet<String> raid : raids) {
                //Recorremos los jugadores de los hashset raids anteriores
                for (String jugadores : raid) {
                    //Añade los jugadores al HashMap de contador y va contando las apariciones, si no esta el jugador se añade como 0 y si existe le suma 1
                    contadorJugadores.put(jugadores, contadorJugadores.getOrDefault(jugadores, 0) + 1);
                }
            }
        }
        //Recorremos cada entrada del map contador y comparamos cada valor con el maximo, si es mayor, maximo es igual a el y mvp es el valor de la clave
        for (Map.Entry<String, Integer> apariciones : contadorJugadores.entrySet()) {
            if (apariciones.getValue() > contadorJugadorMasAparecido) {
                contadorJugadorMasAparecido = apariciones.getValue();
                jugadorMasAparecido = apariciones.getKey();
            }
        }
        System.out.println("El jugador mas aparecido es: " + jugadorMasAparecido + " con " + contadorJugadorMasAparecido + " raids ");
    }
}
