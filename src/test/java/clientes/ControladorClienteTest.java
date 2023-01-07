package clientes;

import clientes.excepciones.ErrorCedula;
import database.ControladorBD;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class ControladorClienteTest {
    private static ControladorCliente controladorCliente;
    private static Cliente cliente;
    @BeforeClass
    public static void setUpTest() {
        controladorCliente = new ControladorCliente();
        cliente = new Cliente("1725292542","Angelo Alexandro",
                "Abad Abarca","15-08-1997",
                'M',"0963870957",
                "Diana Abad","0964255255",
                "abad14@gmail.com","Av.Maldonado");
    }

    @Test
    public void given_client_when_insert_then_ok() throws Exception {
        try {
            ControladorBD.getInstance().ejecutarSentencia(String.format("DELETE FROM clientes WHERE cedula='%s'", cliente.getCedula()));
        } catch (SQLException e) {}
        controladorCliente.registrarCliente(cliente);
    }

    @Test
    public void given_client_cedula_when_consult_client_then_ok() throws ErrorCedula {
        try {
            controladorCliente.registrarCliente(cliente);
        } catch (Exception e) {}

        Cliente clienteConsultado = null;
        clienteConsultado = controladorCliente.consultarCliente("1725292542");
        assertEquals(clienteConsultado, cliente);
    }

    @Test
    public void given_update_client_when_updated_client_then_ok() throws Exception {
        try {
            controladorCliente.registrarCliente(cliente);
        } catch (Exception e) {}

        String direccion_nuevo = "Pedro Abad";
        String nombre_contacto_nuevo = "Jose Muños";
        String telefono_nuevo = "0964255791";

        String telefonoContacto_nuevo = "0964255092";
        String correoElectronico_nuevo = "abad42@hotmail.com";

        cliente.setNombreContacto(nombre_contacto_nuevo);
        cliente.setTelefono(telefono_nuevo);
        cliente.setDireccion(direccion_nuevo);
        cliente.setTelefonoContacto(telefonoContacto_nuevo);
        cliente.setCorreoElectronico(correoElectronico_nuevo);

        controladorCliente.actualizarCliente(cliente);
        Cliente clienteConsultado = controladorCliente.consultarCliente("1725292542");
        assertEquals(clienteConsultado, cliente);
    }

    @Test
    public void given_client_cedula_when_delete_client_then_ok() throws Exception {
        try {
            controladorCliente.registrarCliente(cliente);
        } catch (Exception e) {}
        controladorCliente.eliminarCliente("1725292542");
    }
    @Test(expected = ErrorCedula.class)
    public void given_wrong_cedula_when_registry_then_error() throws Exception {
        Cliente cliente = new Cliente("172635479", "Angelo Alexandro",
                "Abad Abarca", "15-08-1997",
                'M', "0963870957",
                "Diana Abad", "0964255255",
                "abad14@gmail.com", "Av.Maldonado");
        controladorCliente.registrarCliente(cliente);
    }

    @AfterClass
    public static void tearDownClass() {
        try {
            ControladorBD.getInstance().ejecutarSentencia(String.format("DELETE FROM clientes WHERE cedula='%s'", cliente.getCedula()));
        } catch (SQLException e) {}
    }
}