package menu.clientes;

import menu.Opcion;

import java.util.Scanner;

public class OpcionActualizarDatosCliente extends Opcion {
    public OpcionActualizarDatosCliente() {
        super("Actualizar datos de cliente");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        MenuActualizacionDatosCliente menu = new MenuActualizacionDatosCliente();
        menu.mostrarSeleccion();

    }
}
