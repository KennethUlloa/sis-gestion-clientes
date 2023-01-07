package console.clientes;

import clientes.Cliente;
import clientes.ControladorCliente;
import console.Opcion;
import console.input.Input;
import console.input.NoActionCaster;
import validacion.ValidadorCedula;
import validacion.ValidadorInactivo;

import java.util.Scanner;

public class OpcionRegistrarCliente extends Opcion {
    public OpcionRegistrarCliente() {
        super("Registrar cliente");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));

        ControladorCliente controladorCliente = new ControladorCliente();
        try {
            String cedula = input.get("* Número de cédula >> ", new ValidadorCedula(""), new NoActionCaster<>());
            String nombres = input.get("* Nombres >> ");
            String apellidos = input.get("* Apellidos >> ");
            String fechaNacimiento = input.get("* Fecha de nacimiento (dd-mm-aaaa) >> ");
            char sexo = input.get("* Sexo (M/F) >> ").charAt(0);
            String telefono = input.get("* Teléfono >> ");
            String nombreContacto = input.get("* Nombre del contacto >> ");
            String telefonoContacto = input.get("* Teléfono del contacto >> ");
            String correoElectronico = input.get("* Correo electrónico >> ");
            String direccion = input.get("* Dirección >> ");
            Cliente cliente = new Cliente(
                    cedula,
                    nombres,
                    apellidos,
                    fechaNacimiento,
                    sexo,
                    telefono,
                    nombreContacto,
                    telefonoContacto,
                    correoElectronico,
                    direccion
            );
            controladorCliente.registrarCliente(cliente);
            System.out.println(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
