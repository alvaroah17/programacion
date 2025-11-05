import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*EJERCICIO 2
        Escribe un programa que solicite 20 números enteros. Estos números debemos de introducirlo en un array de 4 filas por 5 columnas.
        El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna.
        La suma total debe aparecer en la esquina inferior derecha.
         */
        int sumaFilas=0;
        int numMayorColumna=0;
        int sumaTotal=0;
        System.out.println("Introduce 20 numeros enteros");
        int [][] array4x5 =new int[4][5];
        for (int i = 0; i < array4x5.length ; i++) {
            for (int j = 0; j < array4x5[i].length; j++) {
                array4x5[i][j]= sc.nextInt();
            }
        }
        for (int i = 0; i < array4x5.length; i++) {
            sumaFilas=0;
            for (int j = 0; j < array4x5[i].length; j++) {
                System.out.printf("%10s", array4x5[i][j]);
                sumaFilas+=array4x5[i][j];
            }
            System.out.printf("%10s",sumaFilas);
            System.out.println();
        }
        for (int i = 0; i < array4x5[0].length; i++) {
            for (int j = 0; j < array4x5.length; j++) {
                
            }
        }
    }
}
