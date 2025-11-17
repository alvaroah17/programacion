public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario(
                "Alvaro",
                "Aliaño",
                11404,
                "La Plata",
                "aalihur@g.educaand.es",
                "contraseña"
        );
        System.out.println(user.getNombre());
        user.setNombre("Pablo");
        System.out.println(user.getNombre());
        System.out.println(user.getEmail());
        user.setEmail("aalihurgeducaand");
        System.out.println(user.getEmail());
        System.out.println(user.checkUsuario("aalihur@g.educaand.es", "contraseña"));
        System.out.println(user.toString());
    }
}