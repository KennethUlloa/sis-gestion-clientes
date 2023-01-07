package console.fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import console.Opcion;
import console.input.*;
import fichas.ControladorFicha;
import fichas.Ficha;
import validacion.Validador;
import validacion.ValidadorCedula;
import validacion.ValidadorInactivo;
import validacion.ValidadorPesoAltura;

import java.time.LocalDate;
import java.util.Scanner;

public class OpcionCrearFicha extends Opcion {
    public OpcionCrearFicha() {
        super("Crear ficha");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        try {
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            ControladorCliente controladorCliente = new ControladorCliente();
            ControladorFicha controladorFicha = new ControladorFicha();
            ValidadorPesoAltura validadorPesoAltura = new ValidadorPesoAltura();
            DoubleCaster doubleCaster = new DoubleCaster();
            ValidadorInactivo<LocalDate> validadorInactivo = new ValidadorInactivo<>();
            DateCaster dateCaster = new DateCaster();
            Cliente cliente = controladorCliente.consultarCliente(
                    input.get("* Ingresa la cédula del cliente para la ficha >> ",1));
            Ficha ficha = controladorFicha.consultarFicha("F"+cliente.getCedula());
            if(ficha != null) {
                throw new Exception("El cliente ya posee una ficha registrada");
            }
            double peso = input.get("* Ingresa el peso (kg) >> ", validadorPesoAltura, doubleCaster, 1);
            double altura = input.get("* Ingresa el peso (cm) >> ", validadorPesoAltura, doubleCaster, 1);
            LocalDate fechaInicio = input.get("* Ingresa la fecha de inicio (dd-MM-aaaa) >> ",
                    validadorInactivo, dateCaster, 1);
            LocalDate fechaFin = input.get("* Ingresa la fecha de fin (dd-MM-aaaa) >> ", validadorInactivo,
                    dateCaster, 1);
            boolean estaActivo = input.get("* Ingresa el estado: activo (números > 0) | inactivo (números <= 0)",
                    new ValidadorInactivo<>(), new BooleanCaster());
            ficha = new Ficha("F" + cliente.getCedula(), cliente, fechaInicio, fechaFin,estaActivo);
            ficha.setPeso(peso);
            ficha.setAltura(altura);
            controladorFicha.registrarFicha(ficha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
