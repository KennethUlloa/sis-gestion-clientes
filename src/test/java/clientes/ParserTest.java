package clientes;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;
public class ParserTest {
    @Test
    public void given_local_time_when_parsed_to_string_then_ok() {
        String expected = "10:50";
        String actual = Parser.toString(LocalTime.of(10,50));
        assertEquals(expected, actual);
    }
    @Test
    public void given_local_date_when_parsed_to_string_then_ok() {
        String expected = "05-02-2000";
        String actual = Parser.toString(LocalDate.of(2000,2,5));
        assertEquals(expected, actual);
    }

}
