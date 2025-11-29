import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    ///PRECARGA DE DATOS
    ////HOSPITALES
        Hospital h1=new Hospital(
                "San Juan Grande",
                "H001"
        );

    ////AREAS
        Area urgencias=new Area (
                "Urgencias",
                "URG",
                0,
                h1
        );
        Area maternidad=new Area(
                "Maternidad",
                "MAT",
                1,
                h1
        );
        ///AÑADIR AREAS a HOSPITAL
        //SIN FUNCION
            //h1.getAreas().add(urgencias);
        //CON FUNCION
        h1.agregarAreas(urgencias);
        h1.agregarAreas(maternidad);
    ////MEDICOS
        Medico m1=new Medico(
                "32750907L",
                "Marco",
                40,
                "Masculino",
                2240.50,
                2006,
                urgencias
        );
        ///AÑADIR MEDICOS a AREAS
        urgencias.añadirMedico();
    ////PRUEBAS
        System.out.println("|PRUEBAS|");
    //----------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println(urgencias.getHospital().getNombre());
        System.out.println("El tamaño del array list es de = "+h1.getAreas().size());
        System.out.println(h1.getAreas().get(0).getNombre());
        System.out.println(h1.getAreas().get(1).getNombre());
    //----------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    ////IMPRIMIR FUNCIONES MEDICO
        System.out.println("|FUNCIONES MEDICO|");
    //----------------------------------------------------------------------------------------------------------------------------------------------
            //Cálculo de Sueldo Neto
        System.out.println("El sueldo neto es ="+m1.sueldoNeto(20)+"€");
            //Cálculo de Antigüedad
        System.out.println("El 1er medico tiene "+m1.anosAntiguedad(2025)+" años de antiguedad");
            //Cálculo de Impuestos Anuales
        System.out.println("Impuestos anuales a pagar = "+m1.impuestoSueldoAnual(25)+"€");
            //Comprobación de Edad
        System.out.println("¿Cumple o excede la mayoria de edad? "+m1.comprobarEdad(30));
            //Cálculo de Aumento
        System.out.println("El sueldo con aumento SI cumple los años requeridos es = "+m1.proximoAumento(10.0, 17)+"€");
            //Gestión de Área
        m1.cambiarArea(maternidad);//LLAMAMIENTO FUNCION CAMBIAR MEDICO (m1) DE AREA "URGENCIAS" a "MATERNIDAD"
        System.out.println("El Nº de medicos del area "+urgencias.getNombre()+" es = "+urgencias.getNumMedicos());
        System.out.println("El Nº de medicos del area "+maternidad.getNombre()+" es = "+maternidad.getNumMedicos());
    //----------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    ////IMPRIMIR FUNCIONES AREA
        System.out.println("|FUNCIONES AREA|");
    //----------------------------------------------------------------------------------------------------------------------------------------------
            //Comprobación y Comparación
        System.out.println("Comparacion entre el Nº de medicos de 2 Areas = "+urgencias.compararNºMedicos(maternidad));
            //Cálculo de Capacidad
        System.out.println("El número de medicos que se pueden añadir antes de llegar al límite son = "+maternidad.capacidadRestanteNºMedicos(10));
    //----------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    ////IMPRIMIR FUNCIONES HOSPITAL
        System.out.println("|FUNCIONES HOSPITAL|");
    //----------------------------------------------------------------------------------------------------------------------------------------------



        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    //----------------------------------------------------------------------------------------------------------------------------------------------

    }

}
