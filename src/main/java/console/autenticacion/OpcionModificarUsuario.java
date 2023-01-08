package console.autenticacion;

import console.Opcion;
import console.input.Input;
import usuarios.ControladorUsuario;
import usuarios.Rol;
import usuarios.Usuario;


import java.sql.SQLException;
import java.util.Scanner;

public class OpcionModificarUsuario extends Opcion {
    public OpcionModificarUsuario() {
        super("Modificar rol usuario");
    }

    @Override
    public void ejecutar(Object... argumentos) {

        Scanner scanner = new Scanner(System.in);
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Input input = new Input(new Scanner(System.in));
        try {
            controladorUsuario.consultarTablaUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Usuario usuario =
                    controladorUsuario.consultarUsuario
                            (input.get("* Ingresa el nombre del usuario a cambiar su rol>> ", 0));
            System.out.print("* Elegir nuevo Rol: (1.Administrador,2.Usuario) >> ");
            int rol = scanner.nextInt();
            Rol roles[] = Rol.values();
            controladorUsuario.actualizarRolCliente(usuario.getUsuario(),roles[rol-1]);
            System.out.println("Cambio de rol exitoso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            controladorUsuario.consultarTablaUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
