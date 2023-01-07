package console.clientes;

import clientes.ControladorCliente;
import console.Menu;
import console.Opcion;
import console.input.Input;

import java.util.Scanner;

public class OpcionEliminarCliente extends Opcion {
    public OpcionEliminarCliente(Menu menu) {
        super("Eliminar cliente", menu);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: Eliminar cliente
        Input input = new Input(new Scanner(System.in));
        ControladorCliente controladorCliente = new ControladorCliente();

        try {
            controladorCliente.eliminarCliente(input.get("* Ingresa el número de cédula >> ", 1));
            System.out.println("Cliente eliminado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
