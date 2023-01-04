package console.clientes;

import console.Opcion;

public class OpcionModuloClientes extends Opcion {
    public OpcionModuloClientes() {
        super("Clientes");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        MenuClientes menuClientes = new MenuClientes();
        menuClientes.mostrarSeleccion();
    }
}
