import java.util.ArrayList;

public class Main {

    ////ARRAYLIST OBJETOS
    static ArrayList<Direccion> direcciones = new ArrayList<>();
    static ArrayList<Hospital> hospitales = new ArrayList<>();
    static ArrayList<Area> areas = new ArrayList<>();
    static ArrayList<Medico> medicos = new ArrayList<>();
    static ArrayList<Contrato> contratos = new ArrayList<>();

    public static void main(String[] args) {
        preCargaDatos();

        // LLAMADA AL MENÚ
        MenuGestor.ejecutarMenuPrincipal();
    }

    ///PRECARGA DE DATOS
    public static void preCargaDatos() {

        ////HOSPITALES
        Hospital h1 = new Hospital(
                "San Juan Grande",
                "H001"
        );
        hospitales.add(h1);

        ////AREAS
        Area urgencias = new Area(
                "Urgencias",
                "URG",
                0,
                h1
        );
        Area maternidad = new Area(
                "Maternidad",
                "MAT",
                1,
                h1
        );
        areas.add(urgencias);
        areas.add(maternidad);

        ////MEDICOS
        Medico m1 = new Medico(
                "32750907L",
                "Marco",
                40,
                "No binario",
                2240.50,
                2006,
                urgencias
        );
        Medico m2 = new Medico(
                "32758395P",
                "Sergio",
                50,
                "Masculino",
                2550.0,
                1999,
                maternidad
        );
        Medico m3 = new Medico(
                "32347922F",
                "Cristian",
                30,
                "Masculino",
                2100.0,
                2010,
                urgencias
        );
        medicos.add(m1);
        medicos.add(m2);
        medicos.add(m3);

        ////CONTRATOS (constructor ya corregido)
        Contrato contrato1 = new Contrato(
                2006,
                m1,
                h1,
                "CON1"
        );
        Contrato contrato2 = new Contrato(
                1999,
                m2,
                h1,
                "CON2"
        );
        Contrato contrato3 = new Contrato(
                2010,
                m3,
                h1,
                "CON3"
        );
        contratos.add(contrato1);
        contratos.add(contrato2);
        contratos.add(contrato3);

        ////DIRECCIONES
        Direccion direccionH1 = new Direccion(
                "Avenida Nacional",
                "Nº38",
                11407,
                "Jerez",
                "Cádiz"
        );
        direcciones.add(direccionH1);

        ///AÑADIR AREAS al HOSPITAL
        h1.agregarAreas(urgencias);
        h1.agregarAreas(maternidad);

        ///AÑADIR MEDICOS a ÁREAS
        urgencias.aniadirMedico();
        maternidad.aniadirMedico();
        urgencias.aniadirMedico();
    }

    public static Hospital buscarHospital(String CIFhospital){
        for (int i = 0; i < hospitales.size(); i++) {
            Hospital hospitalAdevolver = hospitales.get(i);
            if (hospitalAdevolver.getCIF().equals(CIFhospital)){
                return hospitalAdevolver;
            }
        }
        return null;
    }

    public static Area buscarArea(String IDArea){
        for (int i = 0; i < areas.size(); i++) {
            Area areaAdevolver = areas.get(i);
            if (areaAdevolver.getIdentificador().equals(IDArea)){
                return areaAdevolver;
            }
        }
        return null;
    }

    public static Medico buscarMedico(String DNIMedico){
        for (int i = 0; i < medicos.size(); i++) {
            Medico medicoAdevolver = medicos.get(i);
            if (medicoAdevolver.getDNI().equals(DNIMedico)){
                return medicoAdevolver;
            }
        }
        return null;
    }

    public static Contrato buscarContrato(String codContrato){
        for (int i = 0; i < contratos.size(); i++) {
            Contrato contratoAdevolver = contratos.get(i);
            if (contratoAdevolver.getCodContrato().equals(codContrato)){
                System.out.print("El contrato que buscas por el codContrato es: ");
                return contratoAdevolver;
            }
        }
        return null;
    }
}