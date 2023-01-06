package console.autenticacion;

import console.Opcion;
public class OpcionModuloUsuarios extends Opcion {

    public OpcionModuloUsuarios() {
        super("Usuarios de Sistema");
    }
    @Override
    public void ejecutar(Object... argumentos) {
        MenuUsuarios menuUsuarios = new MenuUsuarios();
        menuUsuarios.mostrarSeleccion();
    }
}
