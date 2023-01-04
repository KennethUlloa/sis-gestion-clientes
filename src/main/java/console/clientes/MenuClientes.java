package console.clientes;

import console.Menu;
import console.OpcionRegresar;

public class MenuClientes extends Menu {
    public MenuClientes() {
        super("MÓDULO DE CLIENTES");
        agregarOpcion(new OpcionRegistrarCliente());
        agregarOpcion(new OpcionActualizarDatosCliente());
        agregarOpcion(new OpcionEliminarCliente());
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
