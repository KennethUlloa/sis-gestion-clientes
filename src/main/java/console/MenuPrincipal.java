package console;

import console.autenticacion.OpcionModuloUsuarios;
import console.clientes.OpcionModuloClientes;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("MENU PRINCIPAL");
        agregarOpcion(new OpcionModuloUsuarios());
        agregarOpcion(new OpcionModuloClientes());
        agregarOpcion(new OpcionSalir(this));
    }

    @Override
    public boolean validarOpcion(int opcion) {
        return opcion-1 >= 0 && opcion-1 < contarOpciones();
    }
}
