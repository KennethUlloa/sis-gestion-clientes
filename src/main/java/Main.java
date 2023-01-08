import console.MenuPrincipal;
import console.autenticacion.OpcionCrearUsuario;
import console.autenticacion.OpcionIngresarUsuario;
import global.GLOBAL;
import usuarios.ControladorUsuario;

public class Main {
    public static void main(String[] args) throws Exception {

        ControladorUsuario controladorUsuario = new ControladorUsuario();
        if (!controladorUsuario.verificarExistenciaUsuario()){
            System.out.println("No existen usuarios registrados, por favor, registre uno");
            new OpcionCrearUsuario().ejecutar();
        }
        do{
            new OpcionIngresarUsuario().ejecutar();
        }while (!GLOBAL.existeUsuarioRegistrado());
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.mostrarSeleccion();
    }
}
