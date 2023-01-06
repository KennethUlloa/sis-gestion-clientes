package console;

import console.autenticacion.OpcionModuloUsuarios;
import console.clientes.OpcionModuloClientes;
import console.fichas.OpcionModuloFichas;
import global.GLOBAL;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("MENU PRINCIPAL");
        agregarOpcion(new OpcionModuloUsuarios());
        agregarOpcion(new OpcionModuloClientes());
        agregarOpcion(new OpcionModuloFichas());
        agregarOpcion(new OpcionSalir(this));
    }

    @Override
    public void antesDeOpciones() {
        if(!GLOBAL.existeUsuarioRegistrado()) return;
        System.out.println("Bienvenido " + GLOBAL.getUsuarioLoggeado().getUsuario().toUpperCase());

    }
}
