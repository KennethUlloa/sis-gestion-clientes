package console.clientes;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.Opcion;
import console.input.Input;

import java.util.Scanner;

public class OpcionActualizarDatosCliente extends Opcion {
    public OpcionActualizarDatosCliente() {
        super("Actualizar datos de cliente");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
        String cedula = input.get("* Número de cédula del cliente >> ");
        ControladorCliente controladorCliente = new ControladorCliente();
        try {
            Cliente cliente = controladorCliente.consultarCliente(cedula);
            if(cliente == null) {
                System.out.println("Cliente no encontrado");
                return;
            }
            MenuActualizacionDatosCliente menu = new MenuActualizacionDatosCliente();
            menu.setArguments(cliente);
            menu.mostrarSeleccion();
        } catch (ErrorCedula e) {
            System.out.println(e.getMessage());
        }


    }
}
