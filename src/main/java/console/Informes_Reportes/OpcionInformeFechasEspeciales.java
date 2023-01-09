package console.Informes_Reportes;

import clientes.Cliente;
import clientes.ControladorCliente;
import console.Menu;
import console.Opcion;
import console.input.Input;
import fichas.ControladorFicha;
import informes.controladorInformes;

import java.util.Scanner;

public class OpcionInformeFechasEspeciales extends Opcion {
    public OpcionInformeFechasEspeciales() {
        super("Informe Fechas Especiales");
    }
    public OpcionInformeFechasEspeciales(Menu menu) {super("Informe Fechas Especiales", menu);}

    @Override
    public void ejecutar(Object... argumentos) {
        try{
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            controladorInformes controladorinformes = new controladorInformes();
            System.out.println(controladorinformes.consultarFechasEspeciales());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
