import java.util.Scanner;

public class ejercicio7 {
    public static boolean NumeroEsPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
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
        int [][] array6x10 =new int[6][10];
        System.out.println("- Introduce el número mínimo y número máximo del rango de números que contendrá el array de 6x10 ");
        System.out.println("|Introduce el número mínimo|");
        int rangoMinimo= sc.nextInt();
        System.out.println("Introduce el número máximo");
        int rangoMaximo= sc.nextInt();
        for (int i = 0; i < array6x10.length ; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                array6x10[i][j]= (int) (Math.random()*(rangoMinimo-1-rangoMaximo)+rangoMaximo+1);
            }
        }
        //MAYORIA DE VARIABLES
//--------------------------------------------------------------------------------------------------------------
        int sumaTotalFilas=0;
        int sumaTotalColumnas=0;
        int posicionNumeroMaximo=0;
        int indiceMaximo_i =0;
        int indiceMaximo_j=0;
        int posicionNumeroMinimo=array6x10[0][0];
        int indiceMinimo_i =0;
        int indiceMinimo_j=0;
        int valoresArray=0;
        int posicionesArrayTotal=0;
//--------------------------------------------------------------------------------------------------------------
        //BUCLE DOBLE DENTRO DE BUCLE DOBLE, EL 1er BUCLE DOBLE PARA RECORRER EL ARRAY Y EL 2do PARA COMPARAR
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
//--------------------------------------------------------------------------------------------------------------
        //BUCLE DOBLE PARA RECORRER EL ARRAY EN EL QUE PONEMOS LAS CONDICIONES.
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                //DECLARAMOS AQUI LA VARIABLE NÚMERO ASTERISCO QUE HARÁ DE CONTADOR Y QUE SE REINCIARA A 0 CADA VEZ QUE EL BUCLE INTERNO
                //TERMINE
                int numeroAsterisco=0;

                if (array6x10[i][j]==0){
                    System.out.printf("|"+"%12s", " ");
                }
                else {
                    numeroAsterisco=(array6x10[i][j]-rangoMinimo)+1;
                    String asterisco="*".repeat(numeroAsterisco);
                    sumaTotalFilas += array6x10[i][j];
                    System.out.printf("|"+"%12s", asterisco);
                }
                if (array6x10[i][j]>posicionNumeroMaximo){
                    posicionNumeroMaximo=array6x10[i][j];
                    indiceMaximo_i=i;
                    indiceMaximo_j=j;
                }
                if (array6x10[i][j]==rangoMinimo){
                    posicionNumeroMinimo=array6x10[i][j];
                    indiceMinimo_i=i;
                    indiceMinimo_j=j;
                }
            }
            System.out.printf("|");
            System.out.println();
            System.out.println("|------------|------------|------------|------------|------------|------------|------------|------------|------------|------------|");
        }
//--------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < array6x10.length; i++) {
            for (int j = 0; j < array6x10[i].length; j++) {
                valoresArray+=array6x10[i][j];
                posicionesArrayTotal++;
                sumaTotalColumnas+=array6x10[i][j];
            }
        }
//--------------------------------------------------------------------------------------------------------------
        System.out.printf("- "+"%12s","El numero máximo es = "+posicionNumeroMaximo+" y su indice es "+"["+indiceMaximo_i+"]"+"["+indiceMaximo_j+"]");
        System.out.println();
        System.out.printf("- "+"%12s","El numero mínimo es = "+posicionNumeroMinimo+" y su indice es "+"["+indiceMinimo_i+"]"+"["+indiceMinimo_j+"]");
        System.out.println();
        System.out.printf("- "+"%12s","La suma total de las filas y columnas es = "+ (sumaTotalFilas+sumaTotalColumnas));
        System.out.println();
        System.out.printf("- "+"%12s","La suma total de las filas es = "+sumaTotalFilas);
        System.out.println();
        System.out.printf("- "+"%12s","La suma total de las columnas es = "+ sumaTotalColumnas);
        System.out.println();
        System.out.printf("- "+"%12s","La media aritmética es = "+ (double)valoresArray/ (double)posicionesArrayTotal);
//--------------------------------------------------------------------------------------------------------------
        for (int i = 0; i <array6x10.length ; i++) {
            for (int j = 0; j <array6x10[i].length ; j++) {
                if (NumeroEsPrimo(array6x10[i][j])){
                    System.out.println("- El número "+array6x10[i][j]+" es primo, y esta en la posicion --> "+"["+i+"]"+"["+j+"]"+" del array" );
                }
            }
        }
    }
}
