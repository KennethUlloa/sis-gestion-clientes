package fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import clientes.excepciones.ErrorCedula;
import database.ControladorBD;
import database.exceptions.NoSuchColumn;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ControladorFichaTest {
    private static ControladorFicha controladorFicha;
    private static Ficha ficha;
    @BeforeClass
    public static void initTest() {
        controladorFicha = new ControladorFicha();
        Cliente cliente = new Cliente(
                "2256512712",
                "Fulano",
                "Perez",
                "25-06-1989",
                'M',
                "0987654321",
                "Fulana",
                "0912345678",
                "fulano@fulanos.com",
                "Algún lugar"
        );
        ficha = new Ficha(
                "F0",
                cliente,
                "03-01-2023",
                "05-01-2023",
                true
        );
        ficha.setAltura(165.2);
        ficha.setPeso(58.0);
        try {
            controladorFicha.registrarFicha(ficha);
            ControladorCliente controladorCliente = new ControladorCliente();
            controladorCliente.registrarCliente(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Before
    public void setUpTest() {
        controladorFicha = new ControladorFicha();
    }

    @Test
    public void given_ficha_when_query_then_ok() throws Exception {
        Ficha f = controladorFicha.consultarFicha(ficha.getID());
        assertEquals(ficha, f);
    }

    @Test
    public void given_record_when_update_then_ok() throws Exception {
        ficha.setPeso(60);
        controladorFicha.actualizarFicha(ficha);
        Ficha fichaConsultada = controladorFicha.consultarFicha(ficha.getID());
        assertEquals(fichaConsultada, ficha);
    }
    @AfterClass
    public static void tearDown() {
        try {
            ControladorBD.getInstance().ejecutarSentencia("DELETE FROM ficha_cliente WHERE ID='" + ficha.getID() + "'");
            ControladorBD.getInstance().ejecutarSentencia("DELETE FROM clientes WHERE cedula='" + ficha.getCliente().getCedula() + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}