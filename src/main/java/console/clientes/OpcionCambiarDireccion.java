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

public class OpcionCambiarDireccion extends Opcion {
    public OpcionCambiarDireccion(Menu menu) {
        super("Cambiar dirección del cliente", menu);
    }
    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: Cambiar dirección
        ActualizarCampoCliente actualizarCampoCliente = new ActualizarCampoCliente() {
            @Override
            public void actualizacionEspecifica(Cliente cliente, Input input) {
                System.out.println("* Dirección actual: " + cliente.getDireccion());
                String direccion = input.get("* Ingresa la nueva dirección >> ");
                cliente.setDireccion(direccion);
            }
        };
        actualizarCampoCliente.actualizar(argumentos);
    }
}
