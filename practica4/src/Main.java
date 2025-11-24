import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    //PRECARGA DE DATOS
        //HOSPITALES
        Hospital h1=new Hospital("San Juan Grande","H001");

        //AREAS
        Area urgencias=new Area ("Urgencias", "URG", 0, h1);


        //MEDICOS
        Medico m1=new Medico(
                "32750907L",
                "Marco",
                40,
                "Masculino",
                2240.50,
                2006,
                urgencias
        );
        //AÑADIR MEDICOS
        urgencias.añadirMedico();
        //AÑADIR AREAS
        //h1.getAreas().add(urgencias);
        h1.agregarAreas(urgencias);
        //PRUEBAS
        System.out.println(urgencias.getHospital().getNombre());
        System.out.println("El tamaño del array list es de = "+h1.getAreas().size());
        System.out.println(h1.getAreas().get(0).getNombre());
        //IMPRIMIR FUNCIONES
        System.out.println("El sueldo neto es ="+m1.sueldoNeto(20)+"€");
        System.out.println("El 1er medico tiene "+m1.añosAntiguedad(2025)+" años de antiguedad");
        System.out.println("Impuestos anuales a pagar = "+m1.impuestoSueldoAnual(21)+"€");
        System.out.println("¿Cumple o excede la mayoria de edad? "+m1.comprobarEdad(30));




    }
}
