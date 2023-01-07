package console.fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.Opcion;

import java.util.Scanner;

public class OpcionCrearFicha extends Opcion {
    public OpcionCrearFicha() {
        super("Crear ficha");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de cédula del cliente >> ");
        String cedula = scanner.next();
        ControladorCliente controladorCliente = new ControladorCliente();
        Cliente cliente = null;
        try {
            cliente = controladorCliente.consultarCliente(cedula);
            if (cliente == null){
                System.out.println("El cliente no existe");
                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        MenuCrearFicha menuCrearFicha = new MenuCrearFicha();
        menuCrearFicha.setArguments(cliente);
        menuCrearFicha.mostrarSeleccion();
    }
}
