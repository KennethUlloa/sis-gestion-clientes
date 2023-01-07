package console.autenticacion;

import console.Opcion;
import usuarios.ControladorUsuario;
import usuarios.Rol;
import usuarios.Usuario;

import java.util.Scanner;

public class OpcionCrearUsuario extends Opcion {
    public OpcionCrearUsuario() {
        super("Crear nuevo usuario");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //crear nuevo usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("* Usuario: >> ");
        String usuario = scanner.next();
        System.out.print("* Contraseña: >> ");
        String contrasenia = scanner.next();
        System.out.print("* Rol: (1.Administrador,2.Usuario) >> ");
        int rol = scanner.nextInt();
        Rol roles[] = Rol.values();
        Usuario user = new Usuario(usuario,contrasenia,roles[rol-1]);
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        try {
            controladorUsuario.registrarUsuario(user);
            System.out.println("Usuario creado exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
