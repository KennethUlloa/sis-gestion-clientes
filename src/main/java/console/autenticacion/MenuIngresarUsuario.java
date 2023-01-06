package console.autenticacion;

import console.Menu;

public class MenuIngresarUsuario extends Menu {
    public MenuIngresarUsuario(){
        super("Ingreso de credenciales");
        agregarOpcion(new OpcionIngresarUsuario());
    }

}
