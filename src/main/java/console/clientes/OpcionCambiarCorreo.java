package console.clientes;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.Menu;
import console.Opcion;
import console.input.Input;
import console.input.NoActionCaster;
import validacion.ValidadorCedula;

import java.util.Scanner;

public class OpcionCambiarCorreo extends Opcion {
    public OpcionCambiarCorreo(Menu parent) {
        super("Cambiar el correo electrónico del cliente", parent);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: Verificar el correo ingresado
        ActualizarCampoCliente actualizarCampoCliente = new ActualizarCampoCliente() {
            @Override
            public void actualizacionEspecifica(Cliente cliente, Input input) throws Exception {
                System.out.println("* Correo actual: " + cliente.getCorreoElectronico());
                String correo = input.get("* Ingresa el nuevo correo >> ");
                cliente.setCorreoElectronico(correo);
            }
        };

        actualizarCampoCliente.actualizar(argumentos);
        /*
        Input input = new Input(new Scanner(System.in));
        Cliente cliente = null;
        ControladorCliente controladorCliente = new ControladorCliente();
        if(argumentos.length == 0 || !(argumentos[0] instanceof Cliente)) {
            try {
                String cedula = input.get("* Ingresa la cédula del cliente >> ", new ValidadorCedula(""), new NoActionCaster<String>(), true);
                cliente = controladorCliente.consultarCliente(cedula);
            } catch (ErrorCedula e) {
                System.out.println(e.getMessage());
            }
        }
        try{
            cliente = (cliente == null)? (Cliente) argumentos[0] : cliente;
            System.out.println("* Correo actual: " + cliente.getCorreoElectronico());
            String correo = input.get("* Ingresa el nuevo correo >> ");
            cliente.setCorreoElectronico(correo);
            controladorCliente.actualizarCliente(cliente);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }
}
