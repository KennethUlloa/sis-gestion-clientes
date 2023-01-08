package console.fichas;

import console.Opcion;
import console.input.Input;
import console.input.NoActionCaster;
import fichas.ControladorFicha;
import fichas.Ficha;
import validacion.ValidadorCedula;
import validacion.ValidadorSiNo;

import java.time.LocalDate;
import java.util.Scanner;

public class OpcionFinalizarSeguimiento extends Opcion {
    public OpcionFinalizarSeguimiento() {
        super("Finalizar seguimiento");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Input input = new Input(new Scanner(System.in));
        ControladorFicha controladorFicha = new ControladorFicha();
        try {
            Ficha ficha = controladorFicha.consultarFichaPorCliente(input.get("* Ingresa el número de cédula >> ",
                    new ValidadorCedula(""), new NoActionCaster<>(),1));
            if(ficha == null) throw new Exception("No se encontró la ficha");
            String op = input.get("* ¿Está seguro? (s|n) >> ",
                    new ValidadorSiNo("s","n"),
                    new NoActionCaster<>(),1);
            if(op.equals("s")) {
                ficha.finalizarSeguimiento(LocalDate.now());

                controladorFicha.actualizarFicha(ficha);
                System.out.println("Seguimiento finalizado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
