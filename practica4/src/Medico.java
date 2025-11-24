import java.time.LocalDate;

public class Medico {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
//Declaración de ATRIBUTOS para la Clase (Entidad) Medico
    private String DNI;
    private String nombre;
    private int edad;
    private String sexo;
    private double sueldoBruto;
    private int fechaInicio;
    private Area area;

//CONSTRUCTOR
    public Medico (String DNI, String nombre, int edad, String sexo, double sueldoBruto, int fechaInicio, Area area ){
        this.DNI=DNI;
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
        this.sueldoBruto=sueldoBruto;
        this.fechaInicio=fechaInicio;
        this.area=area;
    }
//METODOS GETTER Y SETTER
    //METODOS GET
    public String getDNI(){
        return DNI;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String getSexo(){
        return sexo;
    }
    public double getSueldoBruto(){
        return sueldoBruto;
    }
    public int getFechaInicio(){
        return fechaInicio;
    }
    public Area getArea(){
        return area;
    }
//---------------------------------------------------------------------------
    //METODOS SET
    public void setDNI (String nuevoDNI){
        this.DNI=nuevoDNI;
    }
    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }
    public void setEdad(int nuevaEdad){
        this.edad=nuevaEdad;
    }
    public void setSexo(String nuevoSexo){
        this.sexo=nuevoSexo;
    }
    public void setSueldoBruto(double nuevoSueldoBruto){
        this.sueldoBruto=nuevoSueldoBruto;
    }
    public void setFechaInicio(int nuevaFechaInicio){
        this.fechaInicio=nuevaFechaInicio;
    }
    public void setArea(Area nuevaArea){
        this.area=nuevaArea;
    }
    //FUNCIONES
    public double sueldoNeto(double retencion){
        return (this.sueldoBruto-(this.sueldoBruto*retencion/100));
    }
    public int añosAntiguedad(int añoActual){
        return (añoActual-(fechaInicio));
    }
    public double impuestoSueldoAnual(double tasaImpuestos){
        return ((this.sueldoBruto*tasaImpuestos/100)*12);
    }
    public boolean comprobarEdad(int mayoriaEdad){
        return (edad>=mayoriaEdad);
    }
}
