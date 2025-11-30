public class Contrato {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
///Declaración de ATRIBUTOS para la Clase (Entidad) Contrato
    private int fechaCreacion;
    private Medico medico;
    private Hospital hospital;
    private String codContrato;
///CONSTRUCTOR
    public Contrato(int fechaCreacion, Medico medico, Hospital hospital, String codContrato){
        this.fechaCreacion=fechaCreacion;
        this.medico=medico;
        this.hospital=hospital;
        this.codContrato=codContrato;
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
    public String getCodContrato(){
        return codContrato;
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
    public void setCodContrato(String nuevoCodContrato){
        this.codContrato=nuevoCodContrato;
    }
///FUNCIONES
    public boolean comprobacionAnio (int anio) {
        return (anio == fechaCreacion);
    }
    public int diasDesdeCreacion (int anioActual){
        return anioActual-this.fechaCreacion;
    }
}

