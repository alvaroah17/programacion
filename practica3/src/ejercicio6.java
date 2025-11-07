import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 6
        Modifica el programa anterior de tal forma que no se repita ningún número en el array
        además de que tiene que estar comprendido en un rango entre 20-40.
        */
        int [][] array6x10 =new int[6][10];
        for (int i = 0; i < array6x10.length ; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                array6x10[i][j]= (int) (Math.random()*21)+20;
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
        System.out.println("- Array con 6x10 de numeros aleatorios entre el 20 y el 40 sin que se repitan -");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                for (int k = 0; k < array6x10.length; k++) {
                    for (int l = (k==i ? j+1:0); l < array6x10[k].length; l++) {
                        if (array6x10[i][j]==array6x10[k][l]) {
                            array6x10[k][l]=0;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                if (array6x10[i][j]==0){
                    System.out.printf("|"+"%12s", " ");
                }
                else {
                    System.out.printf("|" + "%12s", array6x10[i][j]);
                    sumaTotalFilas += array6x10[i][j];
                }
                if (array6x10[i][j]>posicionNumeroMaximo){
                    posicionNumeroMaximo=array6x10[i][j];
                    indiceMaximo_i=i;
                    indiceMaximo_j=j;
                }
                if (array6x10[i][j]==20){
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