public class Usuario {
    private String nombre;
    private String apellidos;
    private String codigoPostal;
    private String direccion;
    private String email;
    private String contraseña;

    public Usuario(String no, String ap, String cod, String dir, String em, String con) {
        nombre = no;
        apellidos = ap;
        codigoPostal = cod;
        direccion = dir;
        email = em;
        contraseña = con;
    }
    public String getNombre(){
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCodigoPostal() {
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

    public String setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
        return nuevoNombre;

    }

    public String setApellidos(String nuevoApellidos) {
        this.apellidos = nuevoApellidos;
        return nuevoApellidos;
    }

    public String setCodigoPostal(String nuevoCodigoPostal) {
        this.codigoPostal = nuevoCodigoPostal;
        return nuevoCodigoPostal;
    }

    public String setDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
        return nuevaDireccion;
    }

    public String setEmail(String nuevoEmail) {
        if (email.contains("@")){
            this.email = nuevoEmail;
        }
        else {
            System.out.println("Error: Email inválido ");
        }
        return nuevoEmail;
    }

    public String setContraseña(String nuevaContraseña) {
        this.contraseña = nuevaContraseña;
        return nuevaContraseña;
    }

}
