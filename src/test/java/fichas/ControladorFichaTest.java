package fichas;

import clientes.Cliente;
import clientes.ControladorCliente;
import database.exceptions.NoSuchColumn;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ControladorFichaTest {
    private ControladorFicha controladorFicha;
    @Before
    public void setUpTest() {
        controladorFicha = new ControladorFicha();
    }

    @Test
    public void given_record_when_success_query_then_ok() throws SQLException, NoSuchColumn {
        Ficha f = controladorFicha.consultarFicha("F1");
        System.out.println(f);
        assertNotNull(f);
    }

    @Test
    public void given_record_when_update_then_ok() throws SQLException, NoSuchColumn {
        Ficha ficha = controladorFicha.consultarFicha("F1");
        double nuevoPeso = 65.0;
        ficha.setPeso(nuevoPeso);
        controladorFicha.actualizarFicha(ficha);
        Ficha ficha2 = controladorFicha.consultarFicha("F1");
        assertEquals(ficha.getPeso(), ficha2.getPeso(), 0.009);
    }

}