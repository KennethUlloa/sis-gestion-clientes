package clientes;

import database.ControladorBD;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class ControladorClienteTest {
    ControladorBD controladorBD = ControladorBD.getInstance();

    @Test
    public void given_client_when_insert_then_ok(){

        ControladorCliente controladorCliente=new ControladorCliente(controladorBD);


        Exception error=null;
        try {
            controladorCliente.registrarCliente(new Cliente("1725292542","Angelo Alexandro",
                    "Abad Abarca","15-08-1997",
                    'M',"0963870957",
                    "Diana Abad","0964255255",
                    "abad14@gmail.com","Av.Maldonado"));

        } catch (Exception e) {
            error=e;
        }

        assertNull(error);
    }

    @Test
    public void given_client_cedula_when_consult_client_then_ok(){
        ControladorCliente controladorCliente=new ControladorCliente(controladorBD);
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