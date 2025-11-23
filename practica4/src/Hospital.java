import java.util.ArrayList;

public class Hospital {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
//Declaración de ATRIBUTOS para la Clase (Entidad) Hospital
    private String nombre;
    private String CIF;
    private ArrayList<Area>areas;

//CONSTRUCTOR
    public Hospital (String nombre, String CIF){
        this.nombre=nombre;
        this.CIF=CIF;
        this.areas=new ArrayList<>();
    }
//METODOS GETTER Y SETTER
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
    public void setAreas (Area a){
        this.areas.add(a);
    }
}
