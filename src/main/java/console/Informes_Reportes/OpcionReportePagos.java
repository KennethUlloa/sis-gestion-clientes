package console.Informes_Reportes;

import clientes.Cliente;
import clientes.ControladorCliente;
import console.Menu;
import console.Opcion;
import console.input.Input;
import fichas.ControladorFicha;
import fichas.Ficha;
import reportes.controladorReporte;

import java.util.Scanner;

public class OpcionReportePagos extends Opcion {
    public OpcionReportePagos() {
        super("Reporte Pagos");
    }
    public OpcionReportePagos(Menu menu) {super("Reporte Pagos", menu);}

    @Override
    public void ejecutar(Object... argumentos) {
        try {
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            ControladorCliente controladorCliente = new ControladorCliente();
            ControladorFicha controladorFicha = new ControladorFicha();
            Cliente cliente = controladorCliente.consultarCliente(input.get("* Ingresa la cédula del cliente >> ", 1));
            controladorReporte controladorreporte = new controladorReporte();
            System.out.println(controladorreporte.reportePagos(cliente.getCedula()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
