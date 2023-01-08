package console.fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.Parser;
import console.Item;
import console.MenuSeleccion;
import console.Opcion;
import console.input.CustomCaster;
import console.input.Input;
import console.input.IntegerCaster;
import fichas.*;
import validacion.Validador;
import validacion.ValidadorInactivo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class OpcionRegistrarHorario extends Opcion {
    public OpcionRegistrarHorario() {
        super("Registrar horario");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        try {
            Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
            ControladorFicha controladorFicha = new ControladorFicha();
            ControladorCliente controladorCliente = new ControladorCliente();

            Ficha ficha = consultarFicha(input, controladorFicha, controladorCliente);
            Validador<Integer> validador = new Validador<Integer>() {
                @Override
                public void validar() throws Exception {

                }

                @Override
                public void validar(Integer argument) throws Exception {
                    if(argument < 1 || argument > 7) throw new Exception("Dato en el rango equivocado: " + argument);
                }
            };
            CustomCaster<LocalTime, String> caster = new CustomCaster<LocalTime, String>() {
                @Override
                public LocalTime cast(String argument) throws Exception {
                    return Parser.toLocalTime(argument);
                }
            };

            LocalTime horaInicio = input.get("* Ingresa la hora de inicio (HH:mm) >> ", new ValidadorInactivo<>(), caster);
            LocalTime horaFin = input.get("* Ingresa la hora de fin (HH:mm) >> ", new ValidadorInactivo<>(), caster);
            int dia = input.get("* Ingresa el día de la semana (1-7) >> ", validador, new IntegerCaster());
            System.out.println(dia);
            Actividad actividad = seleccionarActividad();
            if(actividad == null) throw new Exception("Error al seleccionar actividades");
            Horario horario = new Horario(horaInicio, horaFin, actividad, dia);
            ficha.registrarHorario(horario);
            System.out.println(ficha);
            controladorFicha.actualizarFicha(ficha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Ficha consultarFicha(Input input, ControladorFicha controladorFicha, ControladorCliente controladorCliente) throws Exception {
        String cedula = input.get("* Ingresar el número de cédula del cliente >> ");
        Cliente cliente = controladorCliente.consultarCliente(cedula);
        Ficha ficha = controladorFicha.consultarFicha("F" + cliente.getCedula());
        if(ficha == null) {
            throw new Exception("No se encontró la ficha");
        }
        return ficha;
    }

    private Actividad seleccionarActividad() {
        ControladorActividad controladorActividad = new ControladorActividad();
        MenuSeleccion<Actividad> menuSeleccion = new MenuSeleccion<>("ACTIVIDADES");
        for (Actividad actividad : controladorActividad.consultarActividades()){
            Item<Actividad> item = new Item<Actividad>(actividad) {
                @Override
                public String getNombre() {
                    return getValor().getNombre();
                }
            };
            menuSeleccion.agregarItem(item);
        }
        return menuSeleccion.mostrarItems();
    }
}
