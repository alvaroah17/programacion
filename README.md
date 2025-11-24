# Programacion
# **Practica 4 Java POO** *Álvaro Aliaño* **Java**
<img width="346" height="81" alt="image" src="https://github.com/user-attachments/assets/2739b23c-202d-4c64-9598-0bd2aa9fe122" />
___________________________________________________________________________________________________________________________________________
# **Práctica: Sistema de Gestión Hospitalaria**
___________________________________________________________________________________________________________________________________________
**Objetivo**
Desarrollar una aplicación Java sin usar herencia ni interfaces, para modelar y gestionar hospitales, áreas, médicos y contratos, implementando funciones de cálculo, comprobación y gestión de datos a través de una clase dedicada a la interfaz de usuario (MenuGestor).

___________________________________________________________________________________________________________________________________________
**1.🏗️Requisitos de Diseño y Estructura**
1. Modelado de Clases: Desarrolle las siguientes cinco clases con sus atributos,
constructores y métodos get y set correspondientes, implementando las
asociaciones (agregación/composición) necesarias:

  ○ Direccion: (Calle, Número, Código Postal, Localidad, Provincia).

  ○ Hospital: (Nombre, CIF, y una colección para almacenar sus Áreas).

  ○ Area: (Nombre, Identificador, Planta, una referencia al Hospital, y el             contador numMedicos).

  ○ Medico: (DNI, Nombre, Edad, Sexo, Sueldo Bruto, Fecha de Inicio, y una
    referencia al Área donde trabaja).

  ○ Contrato: (Fecha de Creación, referencia al Medico y al Hospital
    involucrados).

**2. Regla de Gestión Automática:**

○ Al instanciar un objeto Medico, el contador numMedicos del objeto Area asociado debe incrementarse automáticamente.   
___________________________________________________________________________________________________________________________________________
**2.🧮Funciones de Cálculo, Comprobación y Gestión
(Métodos de Clases)**
Implemente las siguientes funciones como métodos dentro de sus respectivas clases,
utilizando java.time para cálculos de fechas:

A. Clase Medico

1. Cálculo de Sueldo Neto: calcularSueldoNeto(double retencion): Devuelve el sueldo
neto aplicando el porcentaje de retención.
2. Cálculo de Antigüedad: getAniosAntiguedad(): Devuelve los años completos
transcurridos desde la fechaInicio.
3. Cálculo de Impuestos Anuales: calcularImpuestosAnuales(double tasaImpositiva):
Estima y devuelve el total de impuestos anuales a pagar.
4. Comprobación de Edad: esMayorDeEdad(int mayoriaEdad): Devuelve true si la edad
del médico cumple o excede la mayoría de edad especificada.
5. Cálculo de Aumento: proximoAumento(double porcentajeAumento, int
aniosRequeridos): Si la antigüedad cumple los años requeridos, devuelve el sueldo
bruto aumentado, si no, devuelve el sueldo actual.
6. Gestión de Área: cambiarArea(Area nuevaArea): Método que gestiona la
transferencia, decrementando el contador del área antigua y aumentando el del
área nueva.

B. Clase Area
1. Comprobación y Comparación: compararMedicos(Area otraArea): Devuelve un
String indicando cuál de las dos áreas tiene más médicos.
2. Cálculo de Capacidad: calcularCapacidadRestante(int capacidadMaxima): Devuelve
cuántos médicos más puede recibir el área antes de alcanzar el límite.

C. Clase Hospital
1. Cálculo Agregado: getNumeroTotalMedicos(): Suma y devuelve el número total de
médicos en todas sus áreas.
2. Cálculo de Proporción: getProporcionMedicosArea(String idArea): Calcula la
proporción (0 a 1) de médicos de un área específica respecto al total del hospital.
José Miguel Cordón Fioris 4
Práctica 04 - Java POO Curso 2025/2026
3. Comprobación de Existencia: existeArea(String idArea): Devuelve true si el hospital
ya tiene un área con el ID dado.

D. Clase Contrato
1. Comprobación de Año: esDeAnio(int anio): Devuelve true si la fecha de creación
coincide con el año dado.
2. Cálculo de Vigencia: diasDesdeCreacion(): Devuelve el número de días
transcurridos desde la creación del contrato.

___________________________________________________________________________________________________________________________________________
**3. 🖱️ Clases de Ejecución**
RELLENAR EJERCICIO 3
___________________________________________________________________________________________________________________________________________

___________________________________________________________________________________________________________________________________________

___________________________________________________________________________________________________________________________________________
<img width="2000" height="500" alt="Java-Logo-1996" src="https://github.com/user-attachments/assets/1b6f44d8-3752-4eba-b486-06115cd0a316" />

