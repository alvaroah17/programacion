import java.util.ArrayList;

public class Hospital {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
///Declaración de ATRIBUTOS para la Clase (Entidad) Hospital
    private String nombre;
    private String CIF;
    private ArrayList<Area>areas;

///CONSTRUCTOR
    public Hospital (String nombre, String CIF){
        this.nombre=nombre;
        this.CIF=CIF;
        this.areas=new ArrayList<>();
    }
///METODOS GETTER Y SETTER
    //METODOS GET
    public String getNombre() {
        return nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }
//---------------------------------------------------------------------------
    //METODOS SET
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCIF (String CIF){
        this.CIF = CIF;
    }
    //PREGUNTAR SI ESTO SIRVE PARA ALGO
    public void setAreas (Area a){
        this.areas.add(a);
    }
///FUNCIONES
    public void agregarAreas (Area nueva){
        this.areas.add(nueva);
    }
    public int numeroTotalMedicos (){
        int totalmedicos=0;
        for (int i = 0; i < areas.size(); i++) {
            totalmedicos+=this.areas.get(i).getNumMedicos();
        }
        return totalmedicos;
    }
    public double proporcionMedicosArea(String idArea){
        double proporcionXarea = 0.0;
        for (int i = 0; i < this.areas.size(); i++) {
            if (this.areas.get(i).getIdentificador().equals(idArea)){
                proporcionXarea+=(double) areas.get(i).getNumMedicos()/ numeroTotalMedicos()*100;
            }
        }
        return proporcionXarea;
    }
    public boolean existeArea (String idArea) {
        boolean resultado=false;
        for (int i = 0; i < areas.size(); i++) {
            if (this.areas.get(i).getIdentificador().equals(idArea)){
                resultado=true;
                break;
            }
            else {
                resultado=false;
            }
        }
        return resultado;
    }
}
