package console.clientes;

import console.Menu;
import console.OpcionRegresar;

public class MenuActualizacionDatosCliente extends Menu {
    public MenuActualizacionDatosCliente() {
        super("ACTUALIZACIÓN DE DATOS DEL CLIENTE");
        agregarOpcion(new OpcionCambiarNumero());
        agregarOpcion(new OpcionCambiarDireccion());
        agregarOpcion(new OpcionCambiarNombreContacto());
        agregarOpcion(new OpcionCambiarCorreo());
        agregarOpcion(new OpcionRegresar(this));
    }
}
