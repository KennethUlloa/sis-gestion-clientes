package console.clientes;

import console.Opcion;

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
