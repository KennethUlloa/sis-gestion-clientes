package clientes;

import database.ControladorBD;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class ControladorClienteTest {
    ControladorBD controladorBD = ControladorBD.getInstance();
    ControladorCliente controladorCliente=new ControladorCliente(controladorBD);

    @Test
    public void given_client_when_insert_then_ok() throws Exception {




        Exception error=null;

        controladorCliente.registrarCliente(new Cliente("1725292542","Angelo Alexandro",
                    "Abad Abarca","15-08-1997",
                    'M',"0963870957",
                    "Diana Abad","0964255255",
                    "abad14@gmail.com","Av.Maldonado"));


    }

    @Test
    public void given_client_cedula_when_consult_client_then_ok(){

        Cliente cliente = new Cliente("1725292542", "Angelo Alexandro",
                "Abad Abarca", "15-08-1997",
                'M', "0963870957",
                "Diana Abad", "0964255255",
                "abad14@gmail.com", "Av.Maldonado");

        try {

            controladorCliente.registrarCliente(cliente);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Cliente clienteConsultado =controladorCliente.consultarCliente("1725292542");
        System.out.println(clienteConsultado.toString());

        assertNotNull(clienteConsultado);
    }

    @Test
    public void given_client_cedula_when_delete_client_then_ok() throws Exception {

        Cliente cliente = new Cliente("1725292542", "Angelo Alexandro",
                "Abad Abarca", "15-08-1997",
                'M', "0963870957",
                "Diana Abad", "0964255255",
                "abad14@gmail.com", "Av.Maldonado");

        try {

            controladorCliente.registrarCliente(cliente);

        } catch (Exception e) {
            e.printStackTrace();
        }

        controladorCliente.eliminarCliente("1725292542");


    }


    @After
    public void tearDown(){

        controladorBD = ControladorBD.getInstance();
        try {
            controladorBD.ejecutarSentencia("DELETE FROM clientes;");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}