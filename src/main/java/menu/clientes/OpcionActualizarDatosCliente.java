package menu.clientes;

import menu.Opcion;

import java.util.Scanner;

public class OpcionActualizarDatosCliente extends Opcion {
    public OpcionActualizarDatosCliente() {
        super("Actualizar datos de cliente");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        System.out.print("* Número de cédula del cliente >> ");
        Scanner scanner = new Scanner(System.in);
        String numeroCedula = scanner.next();

    }
}
