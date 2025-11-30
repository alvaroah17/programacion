import java.util.Scanner;

public class MenuGestor {

    public static void ejecutarMenuPrincipal() {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---------------------------------------");
            System.out.println("           _______________");
            System.out.println("           | MENÚ GESTOR |");
            System.out.println("           _______________");
            System.out.println("---------------------------------------");
            System.out.println("1. Crear Hospital");
            System.out.println("2. Crear Área");
            System.out.println("3. Crear Médico");
            System.out.println("4. Modificar Médico");
            System.out.println("5. Modificar Hospital");
            System.out.println("6. Calcular Antigüedad");
            System.out.println("7. Calcular Sueldo Neto");
            System.out.println("8. Comprobar Edad");
            System.out.println("9. Proporción de Médicos en un Área");
            System.out.println("10. Capacidad Restante del Área");
            System.out.println("11. Comparar Nº de Médicos entre Áreas");
            System.out.println("12. Contratos por Año");
            System.out.println("0. Salir");
            System.out.println("---------------------------------------");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearHospital(sc);
                case 2 -> crearArea(sc);
                case 3 -> crearMedico(sc);
                case 4 -> modificarMedico(sc);
                case 5 -> modificarHospital(sc);
                case 6 -> calcularAntiguedad(sc);
                case 7 -> calcularSueldoNeto(sc);
                case 8 -> comprobarEdad(sc);
                case 9 -> proporcionMedicos(sc);
                case 10 -> capacidadRestante(sc);
                case 11 -> compararAreas(sc);
                case 12 -> contratosPorAnio(sc);
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    // -----------------------------------------------------------------
    // 1. CREAR HOSPITAL
    // -----------------------------------------------------------------
    private static void crearHospital(Scanner sc) {

        System.out.print("Nombre del hospital: ");
        String nombre = sc.nextLine();

        System.out.print("CIF: ");
        String cif = sc.nextLine();

        Hospital h = new Hospital(nombre, cif);
        Main.hospitales.add(h);

        System.out.println("Hospital creado correctamente.");
    }

    // -----------------------------------------------------------------
    // 2. CREAR ÁREA
    // -----------------------------------------------------------------
    private static void crearArea(Scanner sc) {

        System.out.print("Nombre del área: ");
        String nombre = sc.nextLine();

        System.out.print("Identificador del área: ");
        String id = sc.nextLine();

        System.out.print("Planta: ");
        int planta = sc.nextInt();
        sc.nextLine();

        System.out.print("CIF del hospital: ");
        String cif = sc.nextLine();

        Hospital hosp = Main.buscarHospital(cif);

        if (hosp == null) {
            System.out.println("Hospital no encontrado.");
            return;
        }

        Area a = new Area(nombre, id, planta, hosp);
        Main.areas.add(a);
        hosp.agregarAreas(a);

        System.out.println("Área creada correctamente.");
    }

    // -----------------------------------------------------------------
    // 3. CREAR MÉDICO
    // -----------------------------------------------------------------
    private static void crearMedico(Scanner sc) {

        System.out.print("DNI: ");
        String dni = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Sexo: ");
        String sexo = sc.nextLine();

        System.out.print("Sueldo bruto: ");
        double sueldo = sc.nextDouble();
        sc.nextLine();

        System.out.print("Año inicio: ");
        int inicio = sc.nextInt();
        sc.nextLine();

        System.out.print("ID del área: ");
        String idArea = sc.nextLine();

        Area area = Main.buscarArea(idArea);

        if (area == null) {
            System.out.println("Área no encontrada.");
            return;
        }

        Medico m = new Medico(dni, nombre, edad, sexo, sueldo, inicio, area);
        Main.medicos.add(m);
        area.aniadirMedico();

        System.out.println("Médico creado correctamente.");
    }

    // -----------------------------------------------------------------
    // 4. MODIFICAR MÉDICO
    // -----------------------------------------------------------------
    private static void modificarMedico(Scanner sc) {

        System.out.print("DNI del médico: ");
        String dni = sc.nextLine();

        Medico m = Main.buscarMedico(dni);

        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }
        else {
            System.out.println(m.getNombre());
        }

        System.out.println("""
                1. Cambiar sueldo
                2. Cambiar edad
                3. Cambiar sexo
                4. Cambiar área
                """);

        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.print("Nuevo sueldo: ");
                double s = sc.nextDouble();
                sc.nextLine();
                m.setSueldoBruto(s);
            }
            case 2 -> {
                System.out.print("Nueva edad: ");
                int e = sc.nextInt();
                sc.nextLine();
                m.setEdad(e);
            }
            case 3 -> {
                System.out.print("Nuevo sexo: ");
                String s = sc.nextLine();
                m.setSexo(s);
            }
            case 4 -> {
                System.out.print("Nueva ID de área: ");
                String id = sc.nextLine();
                Area nueva = Main.buscarArea(id);

                if (nueva == null) {
                    System.out.println("Área no encontrada.");
                    return;
                }

                m.cambiarArea(nueva);
                m.setArea(nueva);
            }
            default -> System.out.println("Opción no válida.");
        }

        System.out.println("Médico actualizado correctamente.");
    }

    // -----------------------------------------------------------------
    // 5. MODIFICAR HOSPITAL
    // -----------------------------------------------------------------
    private static void modificarHospital(Scanner sc) {

        System.out.print("CIF del hospital: ");
        String cif = sc.nextLine();

        Hospital h = Main.buscarHospital(cif);

        if (h == null) {
            System.out.println("Hospital no encontrado.");
            return;
        }

        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar CIF");

        System.out.print("Opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nuevo nombre: ");
            h.setNombre(sc.nextLine());
        } else if (op == 2) {
            System.out.print("Nuevo CIF: ");
            h.setCIF(sc.nextLine());
        } else {
            System.out.println("Opción no válida.");
        }

        System.out.println("Hospital actualizado.");
    }

    // -----------------------------------------------------------------
    // 6. CALCULAR ANTIGÜEDAD
    // -----------------------------------------------------------------
    private static void calcularAntiguedad(Scanner sc) {

        System.out.print("DNI del médico: ");
        String dni = sc.nextLine();

        Medico m = Main.buscarMedico(dni);

        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }

        System.out.print("Introduce año actual: ");
        int actual = sc.nextInt();
        sc.nextLine();

        System.out.println("Antigüedad: " + m.anosAntiguedad(actual) + " años");
    }

    // -----------------------------------------------------------------
    // 7. CALCULAR SUELDO NETO
    // -----------------------------------------------------------------
    private static void calcularSueldoNeto(Scanner sc) {

        System.out.print("DNI del médico: ");
        String dni = sc.nextLine();

        Medico medico = Main.buscarMedico(dni);

        if (medico == null) {
            System.out.println("Médico no encontrado.");
            return;
        }
        else {
            System.out.println(medico.getNombre());
        }

        System.out.print("Retención (%): ");
        double ret = sc.nextDouble();
        sc.nextLine();

        System.out.println("Sueldo neto: " + medico.sueldoNeto(ret)+"€");
    }

    // -----------------------------------------------------------------
    // 8. COMPROBAR EDAD
    // -----------------------------------------------------------------
    private static void comprobarEdad(Scanner sc) {

        System.out.print("DNI del médico: ");
        String dni = sc.nextLine();

        Medico m = Main.buscarMedico(dni);

        if (m == null) {
            System.out.println("Médico no encontrado.");
            return;
        }

        System.out.print("Edad mínima: ");
        int min = sc.nextInt();
        sc.nextLine();

        System.out.println("¿Cumple la edad mínima? " + m.comprobarEdad(min));
    }

    // -----------------------------------------------------------------
    // 9. PROPORCIÓN DE MÉDICOS EN UN ÁREA
    // -----------------------------------------------------------------
    private static void proporcionMedicos(Scanner sc) {

        System.out.print("CIF del hospital: ");
        Hospital h = Main.buscarHospital(sc.nextLine());

        if (h == null) {
            System.out.println("Hospital no encontrado.");
            return;
        }

        System.out.print("ID del área: ");
        String id = sc.nextLine();

        System.out.println("Proporción: " + h.proporcionMedicosArea(id) + "%");
    }

    // -----------------------------------------------------------------
    // 10. CAPACIDAD RESTANTE DEL ÁREA
    // -----------------------------------------------------------------
    private static void capacidadRestante(Scanner sc) {

        System.out.print("ID del área: ");
        String id = sc.nextLine();

        Area a = Main.buscarArea(id);

        if (a == null) {
            System.out.println("Área no encontrada.");
            return;
        }

        System.out.print("Capacidad máxima: ");
        int max = sc.nextInt();
        sc.nextLine();

        System.out.println("Capacidad restante: " + a.capacidadRestanteNºMedicos(max));
    }

    // -----------------------------------------------------------------
    // 11. COMPARAR ÁREAS
    // -----------------------------------------------------------------
    private static void compararAreas(Scanner sc) {

        System.out.print("ID de área 1: ");
        Area a1 = Main.buscarArea(sc.nextLine());

        System.out.print("ID de área 2: ");
        Area a2 = Main.buscarArea(sc.nextLine());

        if (a1 == null || a2 == null) {
            System.out.println("Una de las áreas no existe.");
            return;
        }

        System.out.println(a1.compararNºMedicos(a2));
    }

    // -----------------------------------------------------------------
    // 12. CONTRATOS POR AÑO
    // -----------------------------------------------------------------
    private static void contratosPorAnio(Scanner sc) {

        System.out.print("Año: ");
        int año = sc.nextInt();
        sc.nextLine();

        boolean encontrado = false;

        for (Contrato c : Main.contratos) {
            if (c.getFechaCreacion() == año) {
                System.out.println(
                        "Contrato: año=" + c.getFechaCreacion() +
                                ", Médico=" + c.getMedico().getNombre() +
                                ", Hospital=" + c.getHospital().getNombre()
                );
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("No hay contratos de ese año.");
    }
}