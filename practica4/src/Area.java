public class Area {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
///Declaración de ATRIBUTOS para la Clase (Entidad) Area
    private String nombre;
    private String identificador;
    private int planta;
    private Hospital hospital;
    private int numMedicos;
///CONSTRUCTOR
    public Area (String nombre, String identificador, int planta, Hospital hospital){
        this.nombre=nombre;
        this.identificador=identificador;
        this.planta=planta;
        this.hospital=hospital;
        this.numMedicos=0;
    }
///METODOS GETTER Y SETTER
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
    public int getNumMedicos(){
        return numMedicos;
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
    public void setNumMedicos(int nuevoNumMedicos){
        this.numMedicos=nuevoNumMedicos;
    }
///FUNCIONES
    public void aniadirMedico(){
        numMedicos++;
    }
    public String compararNºMedicos (Area otraArea){
        if (this.numMedicos>otraArea.numMedicos){
            return this.nombre+" tiene más Nº de medicos que "+otraArea.getNombre();
        }
        else if (this.numMedicos==otraArea.numMedicos) {
            return "El Nº de medicos de "+this.nombre+" y "+otraArea.nombre+" son iguales";
        }
        else {
            return otraArea.nombre+" tiene mas Nº de medicos que "+this.nombre;
        }
    }
    public int capacidadRestanteNºMedicos (int capacidadMaxima){
        return (capacidadMaxima-this.numMedicos);
    }
}
