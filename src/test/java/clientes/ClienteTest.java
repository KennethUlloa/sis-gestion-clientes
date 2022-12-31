package clientes;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class ClienteTest {
    @Test
    public void given_client_parameters_when_new_client_with_parameters_then_ok(){
        String cedula = "1725292542";
        String nombres = "Angelo Alexandro";
        String apellidos = "Abad Abarca";
        String fecha = "15-08-1997";
        char sexo = 'M';
        String telefono = "0963870957";
        String nombreContacto = "Diana Abad";
        String telefonoContacto = "0964255255";
        String correoElectronico = "abad14@gmail.com";
        String direccion = "Av.Maldonado";



        Cliente cli=new Cliente(cedula, nombres,
                apellidos, fecha,
                sexo, telefono,
                nombreContacto, telefonoContacto,
                correoElectronico, direccion);


        assertNotNull(cli);
        assertEquals(cedula,cli.getCedula());
        assertEquals(nombres,cli.getNombres());
        assertEquals(apellidos,cli.getApellidos());
        assertEquals(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy")),cli.getFecha());
        assertEquals(sexo,cli.getSexo());
        assertEquals(telefono,cli.getTelefono());
        assertEquals(nombreContacto,cli.getNombreContacto());
        assertEquals(telefonoContacto,cli.getTelefonoContacto());
        assertEquals(correoElectronico,cli.getCorreoElectronico());
        assertEquals(direccion,cli.getDireccion());

    }
}