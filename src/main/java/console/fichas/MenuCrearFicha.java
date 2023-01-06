package console.fichas;

import clientes.Cliente;
import console.Menu;
import console.OpcionRegresar;

public class MenuCrearFicha extends Menu {
    public MenuCrearFicha() {
        super("REGISTRO DE FICHA");
        agregarOpcion(new OpcionRegresar(this));
    }

    @Override
    public void mostrarOpciones() {
        if(getArguments() != null && getArguments().length >= 1){
            System.out.println("Cliente seleccionado: " + ((Cliente) getArguments()[0]).getNombreCompleto());
        }
        super.mostrarOpciones();
    }
}
