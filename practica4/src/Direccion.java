public class Direccion {
//Declaración de ATRIBUTOS para la Clase (Entidad) Dirección
    private String calle;
    private String numero;
    private int codigoPostal;
    private String localidad;
    private String provincia;

//CONSTRUCTOR
    public Direccion (String calle, String numero, int codigoPostal, String localidad, String provincia){
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }
//METODOS GETTER Y SETTER
    //METODOS GET
    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }
    //METODOS SET
}
