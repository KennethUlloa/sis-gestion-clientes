package console;

import console.autenticacion.OpcionModuloRegistroUsuarios;
import console.clientes.OpcionModuloClientes;
import console.fichas.OpcionModuloFichas;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("MENU PRINCIPAL");
        agregarOpcion(new OpcionModuloRegistroUsuarios());
        agregarOpcion(new OpcionModuloClientes());
        agregarOpcion(new OpcionModuloFichas());
        agregarOpcion(new OpcionSalir(this));
    }
}
