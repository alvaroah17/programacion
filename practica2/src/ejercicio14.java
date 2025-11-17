import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio14 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*ENUNCIADO
        Crea un programa que:
        Cree una lista de Strings (ArrayList<String>).
        Pida al usuario nombres por teclado hasta que introduzca la palabra "fin".
        Luego pida un nombre a buscar y diga si está en la lista o no,
        mostrando también en qué posición se encuentra si existe.
         */
        //1 Creamos el ArrayList
        ArrayList<String> ListaNombres = new ArrayList<>();
        //2 Declaramos las variables String
        String nombreXteclado="";
        String nombreAbuscar="";
        //3 Creamos el bucle do (no pregunta ni mira condicion) para meter los nombres por teclados en el ArrayList y al
        //while y le damos la condición de que si lo introducido por teclado no es igual a "Fin"
        //sigue el bucle hasta que le pongamos la palabra "Fin"
        do {
            System.out.println("- Introduce nombres por teclado hasta que introduzca la palabra Fin");
             nombreXteclado=sc.nextLine();
             ListaNombres.add(nombreXteclado);
            if (nombreXteclado.equals("Fin")){
                ListaNombres.remove(ListaNombres.size()-1);
            }
        }while (!nombreXteclado.equals("Fin"));
        //4 Terminaria el bucle poniendo "Fin" y imprimimos lo siguiente
        System.out.println("- Busca en la lista el nombre que quieres buscar en ella para saber si está o no, y en que posición se encuentra si está en ella ");
        //5 ponemos un escaner para los nombres a buscar dentro del ArrayList
        nombreAbuscar=sc.nextLine();
        //6 Hacemos un bucle "for" para mirar las posiciones del ArrayList.
        //7 Creamos un if con la condición de que si el nombre a buscar es igual que lo que hay en las posiciones del ArrayList imprima
        //"Esta en la lista" y su posición (i) en el ArrayList y haga break.
        //8 Y con otro if(si) le decimos que si (i) llegase al valor del tamaño del array list -1 imprima.(con 3 nombres seria i=3-1) ya que nunca llegaria
        // i a ser = 3 ya que se quedaria en el 3er nombre teniendo el valor 2 aunque el valor total del arraylist sea 3 y no imprimiria "No esta en la lista"
        //asi que para que imprimiese habria que poner ese -1.
        //y si encontrara el nombre aunque fuera el ultimo añadido a la lista no daria conflicto ya que se quedaria en el 1er if y haria break al
        //encontrar el nombre
        for (int i=0;i<ListaNombres.size();i++){
            if (nombreAbuscar.equals(ListaNombres.get(i))){
                System.out.println("- Esta en la lista -");
                System.out.println("Posicion = "+ (i));
                break;
            }
            if (i == ListaNombres.size()-1) {
                System.out.println("- No esta en la lista -");
            }
        }
    }
}