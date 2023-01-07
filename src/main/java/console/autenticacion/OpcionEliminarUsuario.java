package console.autenticacion;


import clientes.ControladorCliente;
import console.Opcion;
import console.input.Input;
import usuarios.ControladorUsuario;

import java.util.Scanner;

public class OpcionEliminarUsuario extends Opcion {
    public OpcionEliminarUsuario() {
        super("Eliminar usuario");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: ELiminar usuario
        Input input = new Input(new Scanner(System.in));
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        try {
            controladorUsuario.eliminarUsuario(input.get("* Ingresa el nombre del usuario >> ", 1));
            System.out.println("Usuario eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
