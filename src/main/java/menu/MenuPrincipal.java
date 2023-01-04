package menu;

import menu.autenticacion.OpcionModuloRegistroUsuarios;
import menu.clientes.OpcionModuloClientes;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("MENU PRINCIPAL");
        agregarOpcion(new OpcionModuloClientes());
        agregarOpcion(new OpcionModuloRegistroUsuarios());
        agregarOpcion(new OpcionSalir());

    }

    @Override
    public boolean cerrarMenu(int op) {
        return op == 3;
    }

    @Override
    public boolean validarOpcion(int opcion) {
        return opcion-1 >= 0 && opcion-1 < contarOpciones();
    }

}
