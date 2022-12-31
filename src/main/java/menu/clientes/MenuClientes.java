package menu.clientes;

import menu.Menu;

public class MenuClientes extends Menu {
    public MenuClientes() {
        super("MÓDULO DE CLIENTES");
        agregarOpcion(new OpcionRegistrarCliente());
    }

    @Override
    public boolean cerrarMenu(int op) {
        return false;
    }

    @Override
    public boolean validarOpcion(int opcion) {
        return false;
    }
}
