package menu.clientes;

import clientes.Cliente;
import menu.Opcion;

import java.util.Scanner;

public class OpcionRegistrarCliente extends Opcion {
    public OpcionRegistrarCliente() {
        super("Registrar cliente");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("* Número de cédula >> ");
        String cedula = scanner.next();
        System.out.print("* Nombres >> ");
        scanner.nextLine();
        String nombres = scanner.nextLine();
        System.out.print("* Apellidos >> ");
        String apellidos = scanner.nextLine();
        System.out.println("* Fecha de nacimiento (dd-mm-aaaa) >> ");
        String fechaNacimiento = scanner.next();
        System.out.print("* Sexo (M/F) >> ");
        char sexo = scanner.next().charAt(0);
        System.out.print("* Teléfono >> ");
        String telefono = scanner.next();
        scanner.nextLine();
        System.out.print("* Nombre del contacto >> ");
        String nombreContacto = scanner.nextLine();
        System.out.print("* Teléfono del contacto >> ");
        String telefonoContacto = scanner.next();
        System.out.print("* Correo electrónico >> ");
        String correoElectronico = scanner.next();
        scanner.nextLine();
        System.out.print("* Dirección >> ");
        String direccion = scanner.nextLine();
        Cliente c = new Cliente(
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

        System.out.println(c);

    }
}
