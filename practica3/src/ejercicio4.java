import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 4
       Modifica el programa anterior de tal forma que las sumas parciales y la suma total aparezcan en la pantalla
       con un pequeño retraso, dando la impresión de que el ordenador se queda “pensando” antes de mostrar los números.
         */
        int sumaFilas=0;
        int numMayorColumna=0;
        int sumaTotal=0;
        System.out.println("Array con 20 numeros aleatorios del 1 al 1999 (Salida con retraso para sumas parciales y totales)");
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
            Thread.sleep(2000);
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
        Thread.sleep(2000);
        System.out.printf("%12s","|TOTAL="+sumaTotal+"|");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
    }
}
