package console.autenticacion;

import console.Menu;
import console.OpcionRegresar;
import global.GLOBAL;
import usuarios.Rol;

public class MenuUsuarios extends Menu {
    public MenuUsuarios() {
        super("MODULO DE REGISTRO DE USUARIOS");
        //if (GLOBAL.getUsuarioLoggeado().getRol().equals(Rol.ADMINISTRADOR.name())) {
            agregarOpcion(new OpcionCrearUsuario());
            agregarOpcion(new OpcionEliminarUsuario());
            agregarOpcion(new OpcionModificarUsuario());
            agregarOpcion(new OpcionRegresar(this));
        //}else {
        //    System.out.println("No tiene permisos de ADMINISTRADOR para ejecutar estas opciones");
        //    agregarOpcion(new OpcionRegresar(this));
        //}
    }

    @Override
    public void antesDeOpciones() {
        if(!GLOBAL.existeUsuarioRegistrado()) return;
        System.out.println("Usuario loggeado actualmente: " + GLOBAL.getUsuarioLoggeado().getUsuario().toUpperCase());
    }
}
