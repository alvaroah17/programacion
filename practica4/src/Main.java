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
                "No binario",
                2240.50,
                2006,
                urgencias
        );
        Medico m2=new Medico(
                "32758395P",
                "Sergio",
                50,
                "Masculino",
                2550.0,
                1999,
                maternidad
        );
        Medico m3=new Medico(
                "32347922F",
                "Cristian",
                30,
                "Masculino",
                2100.0,
                2010,
                urgencias
        );
        ///AÑADIR MEDICOS a AREAS
        urgencias.añadirMedico();
        maternidad.añadirMedico();
        urgencias.añadirMedico();
    ////CONTRATOS
        Contrato contrato1=new Contrato(
                2006,
                m1,
                h1

        );
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
            //Cálculo Agregado
        System.out.println("El numero total de medicos en todas las areas es = "+h1.numeroTotalMedicos());
            //Cálculo de Proporción
        System.out.println("La proporcion del area "+h1.proporcionMedicosArea("URG")+"%");
            //Comprobación de Existencia
        System.out.println("Comprobacion SI existe o NO un area, si existe devolvera TRUE sino FALSE = "+h1.existeArea("URG"));
    //----------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
    ////IMPRIMIR FUNCIONES CONTRATO
        System.out.println("|FUNCIONES CONTRATO|");
    //----------------------------------------------------------------------------------------------------------------------------------------------
            //Comprobación de Año
        System.out.println("Comprobacion si el año contrato coincide con el dado, si coincide devolvera TRUE sino FALSE = "+contrato1.comprobacionAnio(2006));
            //Cálculo de Vigencia
        System.out.println("El número total de dias transcurridos desde la creación del contrato es = "+contrato1.diasDesdeCreacion(2025)+" dias");

    //----------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

    }
}
