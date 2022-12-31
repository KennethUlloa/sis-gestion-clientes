package menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class MenuParameterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayInputStream inputStream;
    private String option, optionOutput, menuOutput;
    private Menu menu;

    public MenuParameterTest(String option, String optionOutput) {
        inputStream = new ByteArrayInputStream((option + System.lineSeparator()).getBytes());
        System.setIn(inputStream);
        this.option = option;
        this.optionOutput = optionOutput;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> input() {
        List<Object[]> objects = new ArrayList<>();
        objects.add(new Object[]{"1", "Se ejecutó la opción 1"});
        objects.add(new Object[]{"2", "Se ejecutó la opción 2"});
        objects.add(new Object[]{"3", "Se ejecutó la opción 3"});
        return objects;
    }

    @Before
    public void setUpTest() {
        System.out.println("Test with " + option);
        System.setOut(new PrintStream(outContent));
        menu = new Menu();
        menuOutput = "====== MENU ======\r\n";
        for(Object[] param : MenuParameterTest.input()){
            menu.agregarOpcion(new Opcion("Opción " + param[0]) {
                @Override
                public void ejecutar(Object... argumentos) {
                    System.out.println(param[1]);
                }
            });
            menuOutput += param[0] + ") " + "Opción " + param[0] + "\r\n";
        }
        menuOutput += ">> "+optionOutput+"\r\n";

    }



    @Test
    public void given_menu_when_select_option_then_ok() {
        menu.mostrarSeleccion();
        assertEquals(menuOutput, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        System.out.println("Ended test with " + option);

    }
}