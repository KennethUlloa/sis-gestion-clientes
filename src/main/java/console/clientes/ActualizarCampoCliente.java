package console.clientes;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.input.Input;
import console.input.NoActionCaster;
import validacion.ValidadorCedula;

import java.util.Scanner;

public abstract class ActualizarCampoCliente {

    public ActualizarCampoCliente() {
    }

    public void actualizar(Object... argumentos) {
        Input input = new Input(new Scanner(System.in));
        Cliente cliente = null;
        ControladorCliente controladorCliente = new ControladorCliente();
        if(argumentos.length == 0 || !(argumentos[0] instanceof Cliente)) {
            try {
                String cedula = input.get("* Ingresa la cédula del cliente >> ", new ValidadorCedula(""), new NoActionCaster<String>(), 3);
                cliente = controladorCliente.consultarCliente(cedula);
            } catch (ErrorCedula e) {
                System.out.println(e.getMessage());
            }
        }
        try{
            cliente = (cliente == null)? (Cliente) argumentos[0] : cliente;
            actualizacionEspecifica(cliente, input);
            controladorCliente.actualizarCliente(cliente);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void actualizacionEspecifica(Cliente cliente, Input input);
}
