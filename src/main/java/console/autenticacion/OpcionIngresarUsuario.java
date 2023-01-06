package console.autenticacion;

import console.Opcion;
import global.GLOBAL;
import usuarios.ControladorUsuario;
import usuarios.Usuario;

import java.util.Scanner;

public class OpcionIngresarUsuario extends Opcion {
    public OpcionIngresarUsuario(){
        super("Ingreso de credenciales");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        System.out.println("Hola, ingresa tus credenciales");
        Scanner scanner = new Scanner(System.in);
        System.out.print("* Usuario: >> ");
        String usuario = scanner.next();
        System.out.print("* Contraseña: >> ");
        String contrasenia = scanner.next();
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        try {
            Usuario usuario1 = controladorUsuario.validarCredenciales(usuario, contrasenia);
            GLOBAL.setUsuarioLoggeado(usuario1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
