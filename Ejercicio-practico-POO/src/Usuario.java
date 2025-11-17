public class Usuario {
    /*ESTRUCTURA:
        ATRIBUTOS-->CONTRUCTOR-->METODOS GET Y SET-->METODO TOSTRING

    */
    //ATRIBUTOS
    private String nombre;
    private String apellidos;
    private Integer codigoPostal;
    private String direccion;
    private String email;
    private String contraseña;
    //CONSTRUCTOR
    public Usuario(String no, String ap, Integer cod, String dir, String em, String con) {
        this.nombre = no;
        this.apellidos = ap;
        this.codigoPostal = cod;
        this.direccion = dir;
        this.email = em;
        this.contraseña = con;
    }
    //METODOS GET Y SET
    public String getNombre(){
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }
//-----------------------------------------------------------

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;

    }

    public void setApellidos(String nuevoApellidos) {
        this.apellidos = nuevoApellidos;
    }

    public void setCodigoPostal(Integer nuevoCodigoPostal) {
        this.codigoPostal = nuevoCodigoPostal;
    }

    public void setDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public void setEmail(String nuevoEmail) {
        if (nuevoEmail.contains("@")){
            this.email = nuevoEmail;
        }
        else {
            System.out.println("Error: Email inválido ");
        }
    }

    public void setContraseña(String nuevaContraseña) {
        this.contraseña = nuevaContraseña;
    }
    public boolean checkUsuario(String email, String contraseña){
        return (this.email.equals(email) && this.contraseña.equals(contraseña));
    }
    @Override
    public String toString() {
        return "El nombre es "+ this.nombre+ " y el apellido es "+this.apellidos+" la direccion es "+this.direccion+" el email es "+this.email+" el codigo postal es "+this.codigoPostal;
    }
}
