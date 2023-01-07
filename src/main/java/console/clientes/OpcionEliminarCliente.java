package console.clientes;

import console.Menu;
import console.Opcion;

public class OpcionEliminarCliente extends Opcion {
    public OpcionEliminarCliente(Menu menu) {
        super("Eliminar cliente", menu);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        //TODO: Eliminar cliente
    }
}
