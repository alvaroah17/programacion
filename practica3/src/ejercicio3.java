import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 3
        Modifica el programa anterior de tal forma que los números que se introducen
        en el array se generen de forma aleatoria (valores entre 1 y 1999).
         */
        int sumaFilas=0;
        int numMayorColumna=0;
        int sumaTotal=0;
        System.out.println("Array con 20 numeros aleatorios del 1 al 1999");
        int [][] array4x5 =new int[4][5];
        for (int i = 0; i < array4x5.length ; i++) {
            for (int j = 0; j < array4x5[i].length; j++) {
                array4x5[i][j]= (int) (Math.random()*1999) +1;
            }
        }
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i < array4x5.length; i++) {
            sumaFilas=0;
            for (int j = 0; j < array4x5[i].length; j++) {
                System.out.printf("|"+"%12s", array4x5[i][j]);
                sumaFilas+=array4x5[i][j];
                sumaTotal+=array4x5[i][j];//Forma de hacerlo que va recogiendo los valores de las Filas y Columnas. Sin inicialiarse a 0 a diferencia de sumaFIlas
            }
            System.out.printf("|"+"%12s","∑"+sumaFilas+"|");
            System.out.println();
            System.out.println("|------------|------------|------------|------------|------------|-----------|");
            // sumaTotal+=sumaFilas; Forma de Hacerlo sumandole los valores que va recogiendo sumaFilas antes de inicializarse a 0 de nuevo
        }
        for (int j = 0; j < array4x5[0].length; j++) {
            numMayorColumna=0;//Volvemos a poner la variable a 0 aunque arriba ya este iniciada para que recoja los valores de la nueva columna
            for (int i = 0; i < array4x5.length; i++) {
                if (array4x5[i][j] > numMayorColumna){
                    numMayorColumna=array4x5[i][j];
                }
            }
            System.out.printf("|"+"%12s","∑"+ numMayorColumna);
        }
        System.out.printf("%12s","|TOTAL="+sumaTotal+"|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
    }
}