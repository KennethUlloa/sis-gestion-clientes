package menu.clientes;

import menu.Opcion;

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
