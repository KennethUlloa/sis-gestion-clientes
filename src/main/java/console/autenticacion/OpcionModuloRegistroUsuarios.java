package console.autenticacion;

import console.Opcion;
public class OpcionModuloRegistroUsuarios extends Opcion {

    public OpcionModuloRegistroUsuarios() {
        super("Usuarios de Sistema");
    }
    @Override
    public void ejecutar(Object... argumentos) {
        MenuRegistroUsuarios menuRegistroUsuarios = new MenuRegistroUsuarios();
        menuRegistroUsuarios.mostrarSeleccion();
    }
}
