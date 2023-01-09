package console.Informes_Reportes;

import clientes.Cliente;
import clientes.ControladorCliente;
import console.Menu;
import console.Opcion;
import console.input.Input;
import fichas.ControladorFicha;
import fichas.Ficha;
import informes.controladorInformes;

import java.util.Scanner;

public class OpcionInformeCumpleaños extends Opcion {
    public OpcionInformeCumpleaños() {
        super("Informe Cumpleaños");
    }
    public OpcionInformeCumpleaños(Menu menu) {super("Informe Cumpleaños", menu);}

    @Override
    public void ejecutar(Object... argumentos) {
        try{
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            controladorInformes controladorinformes = new controladorInformes();
            System.out.println(controladorinformes.consultarCumpleaños());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
