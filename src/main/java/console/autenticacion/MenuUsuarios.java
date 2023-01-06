package console.autenticacion;

import console.Menu;
import console.OpcionRegresar;
import global.GLOBAL;

public class MenuUsuarios extends Menu {
    public MenuUsuarios() {
        super("MODULO DE REGISTRO DE USUARIOS");
        agregarOpcion(new OpcionCrearUsuario());
        agregarOpcion(new OpcionEliminarUsuario());
        agregarOpcion(new OpcionModificarUsuario());
        agregarOpcion(new OpcionRegresar(this));
    }

    @Override
    public void antesDeOpciones() {
        if(!GLOBAL.existeUsuarioRegistrado()) return;
        System.out.println("Usuario loggeado actualmente: " + GLOBAL.getUsuarioLoggeado().getUsuario().toUpperCase());
    }
}
