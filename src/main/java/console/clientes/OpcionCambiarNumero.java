package console.clientes;

import clientes.Cliente;
import console.Menu;
import console.Opcion;
import console.input.Input;

public class OpcionCambiarNumero extends Opcion {
    public OpcionCambiarNumero(Menu menu) {
        super("Cambiar teléfono del cliente", menu);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: Cambiar número del cliente
        ActualizarCampoCliente actualizarCampoCliente = new ActualizarCampoCliente() {
            @Override
            public void actualizacionEspecifica(Cliente cliente, Input input) {
                System.out.println("* Teléfono actual: " + cliente.getTelefono());
                String nuevo = input.get("* Ingresa el nuevo teléfono >> ");
                cliente.setTelefono(nuevo);
            }
        };
        actualizarCampoCliente.actualizar(argumentos);
    }
}
