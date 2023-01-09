package console.Informes_Reportes;

import clientes.Cliente;
import clientes.ControladorCliente;
import reportes.controladorReporte;
import console.Menu;
import console.Opcion;
import console.input.Input;
import fichas.ControladorFicha;
import fichas.Ficha;

import java.util.Scanner;

public class OpcionReporteAvances extends Opcion {
    public OpcionReporteAvances() {
        super("Reporte Avances");
    }
    public OpcionReporteAvances(Menu menu) {super("Reporte Avances", menu);}

    @Override
    public void ejecutar(Object... argumentos) {
        try {
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            ControladorCliente controladorCliente = new ControladorCliente();
            Cliente cliente = controladorCliente.consultarCliente(input.get("* Ingresa la cédula del cliente >> ", 1));
            controladorReporte controladorreporte = new controladorReporte();
            System.out.println(controladorreporte.informacionCliente(cliente.getCedula()));
            System.out.println(controladorreporte.reporteAvance("F"+cliente.getCedula()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
