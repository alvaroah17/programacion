public class Main {
    public static void main(String[] args) {
        Usuario user0 = new Usuario(
                "Alvaro",
                "Aliaño",
                11404,
                "La Plata",
                "aalihurg.educaand.es",
                "contraseña"
        );
        Usuario user1 = new Usuario(
                "Sergio",
                "Mondrigon",
                11405,
                "Avenida Lola Flores",
                "smatval@g.educaand",
                "Mondri"
        );
        Usuario user2 = new Usuario(
                "Marco",
                "Paloma",
                11404,
                "Icovesa, Nº1",
                "Mpalmon@g.educaand.es",
                "Paloma"
        );
        Usuario [] arrayUsuarios = {user0, user1, user2};
        System.out.println(user0.getNombre());
        user0.setNombre("Pablo");
        System.out.println(user0.getNombre());
        System.out.println(user0.getEmail());
        //user0.setEmail("aalihurgeducaand");
        //System.out.println(user0.getEmail());
        System.out.println(user0.checkUsuario("aalihur@g.educaand.es", "contraseña"));
        System.out.println(user0.toString());
    }
}