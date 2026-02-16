import java.util.ArrayList;

public class Tesoreria {
    private ArrayList<Obra> obras;

    public Tesoreria() {
        this.obras = new ArrayList<>();
    }
    public double calcularMontoPagar(){
        double precioXvisita=0.02;
        double montoApagar=0.0;
        for (Obra obra:obras){
            if (obra.esMonetizable()){
                montoApagar+= precioXvisita;
            }
        }
        return montoApagar;
    }
}
