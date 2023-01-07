package console.input;

import org.junit.Before;
import org.junit.Test;
import validacion.Validador;
import validacion.ValidadorInactivo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InputTest {

    @Test(timeout = 100)
    public void given_user_input_when_correct_then_ok() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(("Hello" + System.lineSeparator()).getBytes());
        Validador<String> validador = new ValidadorInactivo<>();
        CustomCaster<String, String> customCaster = new NoActionCaster<>();
        Input input = new Input(new Scanner(inputStream));
        String output = input.get("", validador, customCaster, 1);
        assertEquals("Hello", output);
    }

    @Test(timeout = 5000)
    public void given_user_input_when_incorrect_and_correct_after_then_ok() throws Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(("H" + System.lineSeparator() + "1").getBytes());
        CustomCaster<Integer, String> customCaster = new CustomCaster<Integer, String>() {
            @Override
            public Integer cast(String argument) throws Exception {
                return Integer.parseInt(argument);
            }
        };

        Validador<Integer> validador = new ValidadorInactivo<>();
        Input input = new Input(new Scanner(inputStream));
        int actual = input.get("", validador, customCaster);
        int expected = 1;
        assertEquals(expected, actual);
    }

}