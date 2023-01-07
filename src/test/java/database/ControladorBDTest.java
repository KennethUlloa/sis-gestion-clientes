package database;

import database.exceptions.NoSuchColumn;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ControladorBDTest {
    private ControladorBD  controladorBD;
    @BeforeClass
    public static void beforeClass() {
        ControladorBD controladorBD = ControladorBD.getInstance();
        try {
            controladorBD.ejecutarSentencias("INSERT INTO Test VALUES('1','Dato 1','Dato 2')");
            controladorBD.ejecutarSentencias("INSERT INTO Test VALUES('2','Dato 3','Dato 4')");
            controladorBD.ejecutarSentencias("INSERT INTO Test VALUES('3','Dato 5','Dato 6')");
            controladorBD.ejecutarSentencias("INSERT INTO Test VALUES('4','Dato 7','Dato 8')");
        } catch (SQLException ignored) {}
    }

    @Before
    public void setUpTest() {
        controladorBD = ControladorBD.getInstance();
    }

    @Test
    public void given_sql_sentence_when_not_null_then_ok() throws SQLException {
        SQLTable result = controladorBD.ejecutarSentencia("select * from Test");
        assertNotNull(result);
    }

    @Test
    public void given_sql_table_when_get_row_then_ok() throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select * from Test");
        int actualId = (Integer)result.getValueAt(0, "id");
        String actualColumn1 = (String) result.getValueAt(0,"Column1");
        String actualColumn2 = (String) result.getValueAt(0,"Column2");
        assertEquals(actualId, 1);
        assertEquals(actualColumn1, "Dato 1");
        assertEquals(actualColumn2, "Dato 2");
    }
    @Test
    public void given_connection_when_multiple_sentences_then_ok() throws SQLException, NoSuchColumn {
        String[] sentencias = new String[] {
                "UPDATE Test SET Column1='Dato 3' WHERE id=1",
                "UPDATE Test SET Column1='Dato 42' WHERE id=4"};
        controladorBD.ejecutarSentencias(sentencias);
        SQLTable result = controladorBD.ejecutarSentencia("select * from Test where id=1 or id=4");
        assertEquals(result.getValueAt(0,"Column1"), "Dato 3");
        assertEquals(result.getValueAt(1,"Column1"), "Dato 42");
    }

    @AfterClass
    public static void tearDown() {
        try {
            ControladorBD.getInstance().ejecutarSentencias("DELETE from Test");
        } catch (SQLException ignored) {
        }
    }

}