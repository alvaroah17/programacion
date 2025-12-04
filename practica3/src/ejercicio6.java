import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* EJERCICIO 6
           Modifica el programa anterior de tal forma que no se repita ningún número en el array
           además de que tiene que estar comprendido en un rango entre 20-40.
        */

        // Creo un array de 6 filas por 10 columnas
        int [][] array6x10 = new int[6][10];

        // Relleno el array con números aleatorios entre 20 y 40
        for (int i = 0; i < array6x10.length ; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                array6x10[i][j] = (int) (Math.random() * 21) + 20; // Math.random()*21 = 0 a 20, +20 = 20 a 40
            }
        }

        // Variables para cálculos de sumas, máximos y mínimos
        int sumaTotalFilas = 0;
        int sumaTotalColumnas = 0;
        int posicionNumeroMaximo = 0;
        int indiceMaximo_i = 0;
        int indiceMaximo_j = 0;
        int posicionNumeroMinimo = array6x10[0][0];
        int indiceMinimo_i = 0;
        int indiceMinimo_j = 0;

        // Imprimimos el array diciendo con que se va a rellenar (numeros aleatorios entre el 20 y el 40)
        System.out.println("- Array con 6x10 de numeros aleatorios entre el 20 y el 40 sin que se repitan -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        // -----------------------------------------------
        // Este for 4tuple elimina números repetidos en el array:
        // Para cada celda (i,j), comparo con todas las celdas "posteriores"
        // Si encuentro un duplicado, lo pongo a 0
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {

                // Comparo (i,j) con todas las demás posiciones del array
                for (int k = 0; k < array6x10.length; k++) {

                    // Si estoy en la misma fila (k==i), empiezo en la columna siguiente (j+1)
                    // Si estoy en otra fila, empiezo desde la columna 0
                    for (int l = (k == i ? j + 1 : 0); l < array6x10[k].length; l++) {

                        // Si el número se repite, lo pongo a 0
                        if (array6x10[i][j] == array6x10[k][l]) {
                            array6x10[k][l] = 0;
                        }
                    }
                }
            }
        }

        // -----------------------------------------------
        // Recorro el array para imprimirlo y calcular máximos, mínimos y suma de filas
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {

                if (array6x10[i][j] == 0) {
                    // Si la celda es 0 (duplicado), dejo el espacio vacío
                    System.out.printf("|" + "%12s", " ");
                } else {
                    // Si no es 0, imprimo el número y sumo a la fila
                    System.out.printf("|" + "%12s", array6x10[i][j]);
                    sumaTotalFilas += array6x10[i][j];
                }

                // Compruebo si el número actual es el máximo
                if (array6x10[i][j] > posicionNumeroMaximo) {
                    posicionNumeroMaximo = array6x10[i][j];
                    indiceMaximo_i = i;
                    indiceMaximo_j = j;
                }

                // Compruebo si el número actual es el mínimo (igual a 20)
                if (array6x10[i][j] == 20) {
                    posicionNumeroMinimo = array6x10[i][j];
                    indiceMinimo_i = i;
                    indiceMinimo_j = j;
                }
            }

            // Al final de cada fila, cierro la fila y pongo la separación visual
            System.out.printf("|");
            System.out.println();
            System.out.println("|------------|------------|------------|------------|------------|------------|------------|------------|------------|------------|");
        }

        // -----------------------------------------------
        // Calculo la suma total de las columnas
        for (int j = 0; j < array6x10[0].length; j++) {
            for (int i = 0; i < array6x10.length; i++) {
                sumaTotalColumnas += array6x10[i][j];
            }
        }

        // -----------------------------------------------
        // Imprimo resultados finales
        System.out.printf("- " + "%12s", "El numero máximo es = " + posicionNumeroMaximo + " y su indice es [" + indiceMaximo_i + "][" + indiceMaximo_j + "]");
        System.out.println();
        System.out.printf("- " + "%12s", "El numero mínimo es = " + posicionNumeroMinimo + " y su indice es [" + indiceMinimo_i + "][" + indiceMinimo_j + "]");
        System.out.println();
        System.out.printf("- " + "%12s", "La suma total de las filas y columnas es = " + (sumaTotalFilas + sumaTotalColumnas));
        System.out.println();
        System.out.printf("- " + "%12s", "La suma total de las filas es = " + sumaTotalFilas);
        System.out.println();
        System.out.printf("- " + "%12s", "La suma total de las columnas es = " + sumaTotalColumnas);
    }
}