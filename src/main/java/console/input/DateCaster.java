package console.input;

import clientes.Parser;

import java.time.LocalDate;

public class DateCaster implements CustomCaster<LocalDate, String> {
    @Override
    public LocalDate cast(String argument) throws Exception {
        return Parser.toLocalDate(argument);
    }
}
