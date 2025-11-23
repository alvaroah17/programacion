import java.time.LocalDate;

public class Contrato {
/*ESTRUCTURA:
    ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING
------------------------------------------------------------------*/
//Declaración de ATRIBUTOS para la Clase (Entidad) Contrato
    private LocalDate fechaCreacion;
    private Medico medico;
    private Hospital hospital;
//CONSTRUCTOR
    public Contrato(LocalDate fechaCreacion, Medico medico, Hospital hospital){
        this.fechaCreacion=fechaCreacion;
        this.medico=medico;
        this.hospital=hospital;
    }
//METODOS GETTER Y SETTER
    //METODOS GET
    public LocalDate getFechaCreacion(){
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
    public void setFechaCreacion(LocalDate nuevaFechaCreacion){
        this.fechaCreacion=nuevaFechaCreacion;
    }
    public void setMedico(Medico nuevoMedico){
        this.medico=nuevoMedico;
    }
    public void setHospital(Hospital nuevoHospital){
        this.hospital=nuevoHospital;
    }
}
