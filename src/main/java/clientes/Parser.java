package clientes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Parser {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    public static LocalDate toLocalDate(String fecha) {
        return LocalDate.parse(fecha, DATE_FORMATTER);
    }

    public static LocalTime toLocalTime(String hora) {
        return LocalTime.parse(hora, TIME_FORMATTER);
    }
    public static String toString(LocalDate fecha) {
        return fecha.format(DATE_FORMATTER);
    }
    public static String toString(LocalTime hora) {
        return hora.format(TIME_FORMATTER);
    }




}
