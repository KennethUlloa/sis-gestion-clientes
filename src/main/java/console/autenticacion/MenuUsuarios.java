package console.autenticacion;

import console.Menu;
import console.OpcionRegresar;

public class MenuUsuarios extends Menu {
    public MenuUsuarios() {
        super("MODULO DE REGISTRO DE USUARIOS");
        agregarOpcion(new OpcionCrearUsuario());
        agregarOpcion(new OpcionEliminarUsuario());
        agregarOpcion(new OpcionModificarUsuario());
        agregarOpcion(new OpcionRegresar(this));
    }
}
