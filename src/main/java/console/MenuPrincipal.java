package console;

import console.Informes_Reportes.OpcionModulosRep_Inf;
import console.autenticacion.OpcionModuloUsuarios;
import console.clientes.OpcionModuloClientes;
import console.fichas.OpcionModuloFichas;
import global.GLOBAL;
import usuarios.Rol;

public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        super("MENU PRINCIPAL");
        if (GLOBAL.getUsuarioLoggeado().getRol().equals(Rol.ADMINISTRADOR.name())){
            agregarOpcion(new OpcionModuloUsuarios());
        }
        agregarOpcion(new OpcionModuloClientes());
        agregarOpcion(new OpcionModuloFichas());
        agregarOpcion(new OpcionModulosRep_Inf());
        agregarOpcion(new OpcionSalir(this));
    }

    @Override
    public void antesDeOpciones() {
        if(!GLOBAL.existeUsuarioRegistrado()) return;
        System.out.println("Bienvenido " + GLOBAL.getUsuarioLoggeado().getUsuario().toUpperCase());

    }
}
