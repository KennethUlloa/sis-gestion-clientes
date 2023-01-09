import console.MenuPrincipal;
import console.autenticacion.OpcionCrearUsuario;
import console.autenticacion.OpcionIngresarUsuario;
import global.GLOBAL;
import usuarios.ControladorUsuario;
import usuarios.Rol;
import usuarios.Usuario;

public class InitPoint {
    public static void withLogin() throws Exception {
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        if (!controladorUsuario.verificarExistenciaUsuario()){
            System.out.println("No existen usuarios registrados, por favor, registre uno");
            new OpcionCrearUsuario().ejecutar();
        }
        for(int i = 0 ; i < GLOBAL.getNumeroIntentosLogin() ; i++){
            new OpcionIngresarUsuario().ejecutar();
            if(GLOBAL.existeUsuarioRegistrado()) {
                break;
            }
        }
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarSeleccion();
    }

    public static void withOutLogin() {
        GLOBAL.setUsuarioLoggeado(new Usuario(
                "DEV",
                "1234",
                Rol.ADMINISTRADOR
        ));
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarSeleccion();
    }

    public static void start() {
        try {
            withOutLogin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
