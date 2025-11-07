import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 5
       Crear un programa que cuando se le introduzca números enteros rellene un array de 6 filas por 10 columnas
       con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá:
       dar la posición del número máximo y mínimo
        - la suma total de todas las filas y columnas
        - la suma de todas las columnas Hecho
        - la suma de todas las filas. Hecho
         */
        int [][] array6x10 =new int[6][10];
        for (int i = 0; i < array6x10.length ; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                array6x10[i][j]= (int) (Math.random()*1001);
            }
        }
        int sumaTotalFilas=0;
        int sumaTotalColumnas=0;
        int posicionNumeroMaximo=0;
        int indiceMaximo_i =0;
        int indiceMaximo_j=0;
        int posicionNumeroMinimo=array6x10[0][0];
        int indiceMinimo_i =0;
        int indiceMinimo_j=0;
        System.out.println("Array con 6x10 de numeros aleatorios entre el 0 al 1000");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                System.out.printf("|"+"%12s", array6x10[i][j]);
                sumaTotalFilas+=array6x10[i][j];
                if (array6x10[i][j]>posicionNumeroMaximo){
                    posicionNumeroMaximo=array6x10[i][j];
                    indiceMaximo_i=i;
                    indiceMaximo_j=j;
                }
                if (array6x10[i][j]<posicionNumeroMinimo){
                    posicionNumeroMinimo=array6x10[i][j];
                    indiceMinimo_i=i;
                    indiceMinimo_j=j;
                }
            }
            System.out.printf("|");
            System.out.println();
            System.out.println("|------------|------------|------------|------------|------------|------------|------------|------------|------------|------------|");
        }
        for (int j = 0; j < array6x10[0].length; j++) {
            for (int i = 0; i < array6x10.length; i++) {
                    sumaTotalColumnas+=array6x10[i][j];
            }
            //System.out.println();
            //System.out.printf("|"+"%12s","∑"+ posicionMayorColumna);
        }
        System.out.printf("- "+"%12s","El numero máximo es = "+posicionNumeroMaximo+" y su indice es "+"["+indiceMaximo_i+"]"+"["+indiceMaximo_j+"]");
        System.out.println();
        System.out.printf("- "+"%12s","El numero mínimo es = "+posicionNumeroMinimo+" y su indice es "+"["+indiceMinimo_i+"]"+"["+indiceMinimo_j+"]");
        System.out.println();
        System.out.printf("- "+"%12s","La suma total de las filas y columnas es = "+ (sumaTotalFilas+sumaTotalColumnas));
        System.out.println();
        System.out.printf("- "+"%12s","La suma total de las filas es = "+sumaTotalFilas);
        System.out.println();
        System.out.printf("- "+"%12s","La suma total de las columnas es = "+ sumaTotalColumnas);
    }
}
