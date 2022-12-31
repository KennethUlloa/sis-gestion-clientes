package menu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.out.println("Test start");
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void given_menu_when_show_options_then_ok() {
        Menu menu = new Menu();
        menu.agregarOpcion(new Opcion("Opción 1") {
            @Override
            public void ejecutar(Object... argumentos) {

            }
        });
        menu.mostrarOpciones();
        assertEquals("====== MENU ======\r\n1) Opción 1\r\n", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.out.println("Test ended");

    }

}