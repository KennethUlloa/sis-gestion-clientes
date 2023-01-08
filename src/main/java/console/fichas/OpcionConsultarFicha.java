package console.fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.Menu;
import console.Opcion;
import console.input.Input;
import database.exceptions.NoSuchColumn;
import fichas.ControladorFicha;
import fichas.Ficha;

import java.sql.SQLException;
import java.util.Scanner;

public class OpcionConsultarFicha extends Opcion {
    public OpcionConsultarFicha() {
        super("Consultar Ficha");
    }
    public OpcionConsultarFicha(Menu menu) {
        super("Consultar Ficha", menu);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        try {
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            ControladorCliente controladorCliente = new ControladorCliente();
            ControladorFicha controladorFicha = new ControladorFicha();
            Cliente cliente = controladorCliente.consultarCliente(input.get("* Ingresa la cédula del cliente >> ", 1));
            Ficha ficha = controladorFicha.consultarFicha("F"+cliente.getCedula());
            if(ficha == null) {
                throw new Exception("No se encontró la ficha");
            }
            System.out.println(ficha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
