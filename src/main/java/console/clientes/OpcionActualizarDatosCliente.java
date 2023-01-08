package console.clientes;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.Opcion;
import console.input.Input;
import console.input.NoActionCaster;
import validacion.ValidadorCedula;

import java.util.Scanner;

public class OpcionActualizarDatosCliente extends Opcion {
    public OpcionActualizarDatosCliente() {
        super("Actualizar datos de cliente");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));

        try {
            String cedula = input.get("* Número de cédula del cliente >> ", new ValidadorCedula(""), new NoActionCaster<>());
            ControladorCliente controladorCliente = new ControladorCliente();
            Cliente cliente = controladorCliente.consultarCliente(cedula);
            if(cliente == null) {
                System.out.println("Cliente no encontrado");
                return;
            }
            MenuActualizacionDatosCliente menu = new MenuActualizacionDatosCliente();
            menu.setArguments(cliente);
            menu.mostrarSeleccion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
