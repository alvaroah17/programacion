import java.time.LocalDate;

public class Contrato {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
///Declaración de ATRIBUTOS para la Clase (Entidad) Contrato
    private int fechaCreacion;
    private Medico medico;
    private Hospital hospital;
///CONSTRUCTOR
    public Contrato(int fechaCreacion, Medico medico, Hospital hospital){
        this.fechaCreacion=fechaCreacion;
        this.medico=medico;
        this.hospital=hospital;
    }
///METODOS GETTER Y SETTER
    //METODOS GET
    public int getFechaCreacion(){
        return fechaCreacion;
    }
    public Medico getMedico(){
        return medico;
    }
    public Hospital getHospital(){
        return hospital;
    }
//---------------------------------------------------------------------------
    //METODOS SET
    public void setFechaCreacion(int nuevaFechaCreacion){
        this.fechaCreacion=nuevaFechaCreacion;
    }
    public void setMedico(Medico nuevoMedico){
        this.medico=nuevoMedico;
    }
    public void setHospital(Hospital nuevoHospital){
        this.hospital=nuevoHospital;
    }
///FUNCIONES
    public boolean comprobacionAnio (int anio) {
        return (anio == fechaCreacion);
    }
    public int diasDesdeCreacion (int anioActual){
        int diasTranscurridos=0;
        diasTranscurridos+=(anioActual-this.fechaCreacion)*365;
        return diasTranscurridos;
    }
}

