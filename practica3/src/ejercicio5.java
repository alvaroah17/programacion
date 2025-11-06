import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 5
       Crear un programa que cuando se le introduzca números enteros rellene un array de 6 filas por 10 columnas
       con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá:
        dar la posición del número máximo y mínimo
        - la suma total de todas las filas y columnas
        - la suma de todas las columnas
        - la suma de todas las filas.
         */
        int sumaFilas=0;
        int sumaColumnas=0;
        int numMayorColumna=0;
        int posicionMayorColumna=0;
        int posicionMinimaColumna=0;
        int sumaTotal=0;
        System.out.println("Array con 6x10 de numeros aleatorios entre el 0 al 1000");
        int [][] array4x5 =new int[6][10];
        for (int i = 0; i < array4x5.length ; i++) {
            for (int j = 0; j < array4x5[i].length; j++) {
                array4x5[i][j]= (int) (Math.random()*1001);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < array4x5.length; i++) {
            sumaFilas=0;
            for (int j = 0; j < array4x5[i].length; j++) {
                System.out.printf("|"+"%12s", array4x5[i][j]);
                sumaFilas+=array4x5[i][j];
                sumaTotal+=array4x5[i][j];//Forma de hacerlo que va recogiendo los valores de las Filas y Columnas. Sin inicialiarse a 0 a diferencia de sumaFIlas
            }
            System.out.printf("|"+"%12s","∑"+sumaFilas+"|");
            System.out.println();
            System.out.println("|------------|------------|------------|------------|------------|------------|------------|------------|------------|------------|-----------|");
            // sumaTotal+=sumaFilas; Forma de Hacerlo sumandole los valores que va recogiendo sumaFilas antes de inicializarse a 0 de nuevo
        }
        for (int j = 0; j < array4x5[0].length; j++) {
            numMayorColumna=0;//Volvemos a poner la variable a 0 aunque arriba ya este iniciada para que recoja los valores de la nueva columna
            sumaColumnas=0;
            for (int i = 0; i < array4x5.length; i++) {
                sumaColumnas+=array4x5[i][j];
                if (array4x5[i][j] > numMayorColumna){
                    numMayorColumna=array4x5[i][j];
                }
            }
            System.out.printf("|"+"%12s","∑"+ numMayorColumna);
            //System.out.println();
            //System.out.printf("|"+"%12s","∑"+ posicionMayorColumna);
        }
        System.out.printf("%12s","|TOTAL="+sumaTotal+"|");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
