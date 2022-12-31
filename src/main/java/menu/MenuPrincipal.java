package menu;

import menu.clientes.OpcionModuloClientes;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("MENU PRINCIPAL");
        agregarOpcion(new OpcionModuloClientes());
        agregarOpcion(new OpcionSalir());
    }

    @Override
    public boolean cerrarMenu(int op) {
        return op == 2;
    }

    @Override
    public boolean validarOpcion(int opcion) {
        return opcion-1 >= 0 && opcion-1 < contarOpciones();
    }
}
