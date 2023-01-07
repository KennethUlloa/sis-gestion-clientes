package console.clientes;

import console.Menu;
import console.OpcionRegresar;

public class MenuClientes extends Menu {
    public MenuClientes() {
        super("MENÚ DE CLIENTES");
        agregarOpcion(new OpcionRegistrarCliente());
        agregarOpcion(new OpcionActualizarDatosCliente());
        agregarOpcion(new OpcionEliminarCliente(this));
        agregarOpcion(new OpcionRegresar(this));
    }
}
