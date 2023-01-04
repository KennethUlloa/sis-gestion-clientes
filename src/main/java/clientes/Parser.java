package clientes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static LocalDate stringALocalDate(String fecha) {
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}
