package console.autenticacion;

import console.Opcion;
import usuarios.ControladorUsuario;
import usuarios.Usuario;

import java.util.Scanner;

public class OpcionCrearUsuario extends Opcion {
    public OpcionCrearUsuario() {
        super("Crear nuevo usuario");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: crear nuevo usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("* Usuario: >> ");
        String usuario = scanner.next();
        System.out.print("* Contraseña: >> ");
        String contrasenia = scanner.next();
        System.out.print("* Rol: (Administrador,Usuario) >> ");
        String rol = scanner.next();
        Usuario user = new Usuario(usuario,contrasenia,rol);
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        try {
            controladorUsuario.registrarUsuario(user);
            System.out.println("Usuario creado exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
