import java.util.Scanner;

public class ejercicio7 {

    // Función que comprueba si un número es primo.
    // Devuelve false si el número es <=1.
    // Compruebo todos los divisores desde 2 hasta número-1.
    // Si encuentro algún divisor, no es primo; si no, es primo.
    public static boolean NumeroEsPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 7
        Modifica el programa del Ejercicio 6 para que:
        Los números NO se repitan (como en el ejercicio anterior).
        Los números estén comprendidos en un rango dinámico (el usuario introduce el valor mínimo y máximo).
        Al final, el programa muestre:
        La media aritmética de todos los números del array.
        La posición de todos los números primos que haya en el array.
        Una representación gráfica en consola de cada fila, donde cada número se represente con un número de * proporcional
        a su valor dentro del rango dado (por ejemplo, si el rango es 10-20 y aparece el 15, se mostrarán 5 *).
        */
//--------------------------------------------------------------------------------------------------------------

        // Pedimos el rango mínimo y máximo para los números del array
        int [][] array6x10 = new int[6][10];
        System.out.println("- Introduce el número mínimo y número máximo del rango de números que contendrá el array de 6x10 ");
        System.out.println("|Introduce el número mínimo|");
        int rangoMinimo = sc.nextInt();
        System.out.println("Introduce el número máximo");
        int rangoMaximo = sc.nextInt();

        // Relleno el array con números aleatorios dentro del rango
        for (int i = 0; i < array6x10.length ; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                array6x10[i][j] = (int) (Math.random()*(rangoMinimo-1-rangoMaximo)+rangoMaximo+1);
            }
        }

        // Variables que usaré para cálculos y comparaciones
        int sumaTotalFilas = 0;
        int sumaTotalColumnas = 0;
        int posicionNumeroMaximo = 0;
        int indiceMaximo_i = 0;
        int indiceMaximo_j = 0;
        int posicionNumeroMinimo = array6x10[0][0];
        int indiceMinimo_i = 0;
        int indiceMinimo_j = 0;
        int valoresArray = 0;
        int posicionesArrayTotal = 0;

        // Imprimimos el array diciendo con que se va a rellenar
        System.out.println("- Array con 6x10 de numeros aleatorios entre el rango que le hayamos dado sin que se repitan -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        // Ahora voy a eliminar números repetidos:
        // para cada número del array, comparo con todos los que vienen después.
        // Si hay un duplicado, lo pongo a 0 para marcarlo como repetido.
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                for (int k = 0; k < array6x10.length; k++) {
                    // Si estoy en la misma fila, empiezo a comparar desde la columna siguiente
                    // Si estoy en otra fila, comparo desde la columna 0
                    for (int l = (k==i ? j+1 : 0); l < array6x10[k].length; l++) {
                        if (array6x10[i][j] == array6x10[k][l]) {
                            array6x10[k][l] = 0; // marco duplicado con 0
                        }
                    }
                }
            }
        }

        // Recorro el array para mostrar los asteriscos y calcular máximos, mínimos y sumas
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {

                int numeroAsterisco = 0; // contador de cuántos '*' voy a pintar

                if (array6x10[i][j] == 0) {
                    // si la celda es 0 (duplicado), la dejo vacía
                    System.out.printf("|" + "%12s", " ");
                } else {
                    // Para la representación gráfica con asteriscos hago esto:
                    //1. Calculo la diferencia entre el valor de la celda y el rango mínimo:
                    //      array6x10[i][j] - rangoMinimo
                    //    Esto me dice cuántos "pasos" hay desde el mínimo hasta el valor actual.
                    //2. Le sumo 1 para asegurar que el valor mínimo tenga al menos un '*' visible.
                    //3. Resultado final = número de asteriscos que se van a imprimir
                    numeroAsterisco = (array6x10[i][j] - rangoMinimo) + 1;

                    // Construyo la cadena de asteriscos usando repeat
                    // Ejemplo: si numeroAsterisco = 5, asterisco = "*****"
                    String asterisco = "*".repeat(numeroAsterisco);

                    // Sumo el valor para calcular después la suma de las filas
                    sumaTotalFilas += array6x10[i][j];

                    // Imprimo los asteriscos en formato de tabla
                    System.out.printf("|" + "%12s", asterisco);
                }

                // Actualizo el número máximo si este valor es mayor que el que tenía
                if (array6x10[i][j] > posicionNumeroMaximo) {
                    posicionNumeroMaximo = array6x10[i][j];
                    indiceMaximo_i = i;
                    indiceMaximo_j = j;
                }

                // Para el mínimo solo miro si coincide con el valor mínimo del rango
                if (array6x10[i][j] == rangoMinimo) {
                    posicionNumeroMinimo = array6x10[i][j];
                    indiceMinimo_i = i;
                    indiceMinimo_j = j;
                }
            }

            // Al final de cada fila, imprimo la separación para la tabla
            System.out.printf("|");
            System.out.println();
            System.out.println("|------------|------------|------------|------------|------------|------------|------------|------------|------------|------------|");
        }

        // Sumamos todos los valores del array y contamos las posiciones para la media
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                valoresArray += array6x10[i][j];
                posicionesArrayTotal++;
                sumaTotalColumnas += array6x10[i][j];
            }
        }

        // Mostrar resultados finales
        System.out.printf("- " + "%12s","El numero máximo es = " + posicionNumeroMaximo + " y su indice es " + "[" + indiceMaximo_i + "]" + "[" + indiceMaximo_j + "]");
        System.out.println();
        System.out.printf("- " + "%12s","El numero mínimo es = " + posicionNumeroMinimo + " y su indice es " + "[" + indiceMinimo_i + "]" + "[" + indiceMinimo_j + "]");
        System.out.println();
        System.out.printf("- " + "%12s","La suma total de las filas y columnas es = " + (sumaTotalFilas + sumaTotalColumnas));
        System.out.println();
        System.out.printf("- " + "%12s","La suma total de las filas es = " + sumaTotalFilas);
        System.out.println();
        System.out.printf("- " + "%12s","La suma total de las columnas es = " + sumaTotalColumnas);
        System.out.println();
        System.out.printf("- " + "%12s","La media aritmética es = " + (double) valoresArray / (double) posicionesArrayTotal);

        // Por último busco los números primos y muestro su posición
        for (int i = 0; i < array6x10.length ; i++) {
            for (int j = 0; j < array6x10[i].length ; j++) {
                if (NumeroEsPrimo(array6x10[i][j])) {
                    System.out.println("- El número " + array6x10[i][j] + " es primo, y esta en la posicion --> " + "[" + i + "]" + "[" + j + "]" + " del array" );
                }
            }
        }
    }
}