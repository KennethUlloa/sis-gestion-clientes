package menu.autenticacion;

import menu.Menu;
import menu.OpcionRegresar;

public class MenuRegistroUsuarios extends Menu {
    public MenuRegistroUsuarios() {
        super("MODULO DE REGISTRO DE USUARIOS");
        agregarOpcion(new OpcionCrearUsuario());
        agregarOpcion(new OpcionEliminarUsuario());
        agregarOpcion(new OpcionModificarUsuario());
        agregarOpcion(new OpcionRegresar());
    }

    @Override
    public boolean cerrarMenu(int op) {
        return op == contarOpciones();
    }

    @Override
    public boolean validarOpcion(int opcion) {
        return opcion-1 >= 0 && opcion-1 < contarOpciones();
    }
}
