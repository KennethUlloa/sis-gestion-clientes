package console.autenticacion;


import clientes.ControladorCliente;
import console.Opcion;
import console.input.Input;
import global.GLOBAL;
import usuarios.ControladorUsuario;
import usuarios.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class OpcionEliminarUsuario extends Opcion {
    public OpcionEliminarUsuario() {
        super("Eliminar usuario");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //ELiminar usuario
        Input input = new Input(new Scanner(System.in));
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        try {
            controladorUsuario.consultarTablaUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            controladorUsuario.eliminarUsuario(input.get("* Ingresa el nombre del usuario a eliminar>> ", 0));
            System.out.println("Usuario eliminado exitosamente!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            controladorUsuario.consultarTablaUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
