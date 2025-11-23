public class Area {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
//Declaración de ATRIBUTOS para la Clase (Entidad) Area
    private String nombre;
    private String identificador;
    private int planta;
    private Hospital hospital;
    private int numMedicos;
//CONSTRUCTOR
    public Area (String nombre, String identificador, int planta, Hospital hospital){
        this.nombre=nombre;
        this.identificador=identificador;
        this.planta=planta;
        this.hospital=hospital;
        this.numMedicos=0;
    }
//METODOS GETTER Y SETTER
    //METODO GET
    public String getNombre(){
        return nombre;
    }
    public String getIdentificador(){
        return identificador;
    }
    public int getPlanta(){
        return planta;
    }
    public Hospital getHospital(){
        return hospital;
    }
//---------------------------------------------------------------------------
    //METODO SET
    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }
    public void setidentificador (String nuevoIdentificador){
        this.identificador=nuevoIdentificador;
    }
    public void setPlanta(int nuevaPlanta){
        this.planta=nuevaPlanta;
    }
    public void sethospital(Hospital nuevoHospital){
        this.hospital=nuevoHospital;
    }
}
