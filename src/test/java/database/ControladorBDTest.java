package database;

import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ControladorBDTest {

    @Test
    public void given_sql_sentence_when_not_null_then_ok() throws SQLException {
        ControladorBD controladorBD = ControladorBD.getInstance();
        SQLTable result = controladorBD.ejecutarSentencia("select * from Test");
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void given_sql_table_when_get_row_then_ok() throws SQLException {
        ControladorBD controladorBD = ControladorBD.getInstance();
        SQLTable result = controladorBD.ejecutarSentencia("select * from Test");
        HashMap<String, Object> row = result.getRow(0);
        HashMap<String, Object> expected = new HashMap<>();
        expected.put("id", 1);
        expected.put("Column2", 0.25);
        expected.put("Column1", "Algo2");
        System.out.println(row);
        System.out.println(expected);
        assertEquals(row, expected);
    }

}