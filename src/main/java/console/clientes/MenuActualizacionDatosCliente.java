package console.clientes;

import clientes.Cliente;
import console.Menu;
import console.OpcionRegresar;

public class MenuActualizacionDatosCliente extends Menu {
    public MenuActualizacionDatosCliente() {
        super("ACTUALIZACIÓN DE DATOS DEL CLIENTE");
        agregarOpcion(new OpcionCambiarNumero(this));
        agregarOpcion(new OpcionCambiarDireccion(this));
        agregarOpcion(new OpcionCambiarNombreContacto(this));
        agregarOpcion(new OpcionCambiarCorreo(this));
        agregarOpcion(new OpcionRegresar(this));
    }

    @Override
    public void antesDeOpciones() {
        try {
            Cliente cliente = (Cliente) getArguments()[0];
            System.out.println("Cliente: " + cliente.getNombreCompleto().toUpperCase());
        }catch (Exception e){
            cerrarMenu();
        }
    }
}
