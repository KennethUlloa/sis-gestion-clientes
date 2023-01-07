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

public class OpcionCambiarNombreContacto extends Opcion {
    public OpcionCambiarNombreContacto(Menu menu){
        super("Cambiar nombre de contacto del cliente", menu);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: Cambiar nombre de contacto
        ActualizarCampoCliente actualizarCampoCliente = new ActualizarCampoCliente() {
            @Override
            public void actualizacionEspecifica(Cliente cliente, Input input) throws Exception {
                System.out.println("* Nombre de contacto actual: " + cliente.getNombreContacto());
                String nuevo = input.get("* Ingresa el nuevo nombre de contacto >> ");
                cliente.setNombreContacto(nuevo);
            }
        };
        actualizarCampoCliente.actualizar(argumentos);
    }
}
