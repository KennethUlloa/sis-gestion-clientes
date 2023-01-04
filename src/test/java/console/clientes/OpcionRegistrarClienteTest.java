package console.clientes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OpcionRegistrarClienteTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.out.println("Test start");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void given_valid_client_data_when_registry_then_ok() {
        String expected = "* Número de cédula >> * Nombres >> * Apellidos >> * Fecha de nacimiento (dd-mm-aaaa) >> " + System.lineSeparator() +
                "* Sexo (M/F) >> * Teléfono >> * Nombre del contacto >> * Teléfono del contacto >> * Correo electrónico >> * Dirección >> Cliente{cedula='1750105585', nombres='Kenneth Leonardo', apellidos='Ulloa Tobar', fecha=2000-07-03, sexo=M, telefono='0987175255', nombreContacto='Pablo Ulloa', telefonoContacto='0987353846', correoElectronico='greenlantern0@hotmail.com', direccion='Av. La Bota'}" +
                System.lineSeparator();
        String[] data = new String[]{
                "1750105585",
                "Kenneth Leonardo",
                "Ulloa Tobar",
                "03-07-2000",
                "M",
                "0987175255",
                "Pablo Ulloa",
                "0987353846",
                "greenlantern0@hotmail.com",
                "Av. La Bota"
        };

        StringBuilder inputBuffer = new StringBuilder();
        for(String s: data) {
            inputBuffer.append(s).append(System.lineSeparator());
        }

        System.setIn(new ByteArrayInputStream(inputBuffer.toString().getBytes()));
        OpcionRegistrarCliente opcionRegistrarCliente = new OpcionRegistrarCliente();
        opcionRegistrarCliente.ejecutar();
        assertEquals(expected, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        System.out.println("Test ended");

    }
}