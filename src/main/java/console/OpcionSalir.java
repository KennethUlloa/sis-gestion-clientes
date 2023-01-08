package console;

import console.input.CustomCaster;
import console.input.Input;
import validacion.Validador;

import java.util.Scanner;

public class OpcionSalir extends Opcion{
    private MenuPrincipal targetMenu;
    public OpcionSalir(MenuPrincipal targetMenu) {
        super("Salir");
        this.targetMenu = targetMenu;
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Input input = new Input(Input.NEXT, new Scanner(System.in));
        Validador<String> validador = new Validador<>() {
            @Override
            public void validar() throws Exception {

            }

            @Override
            public void validar(String argument) throws Exception {
                switch (argument) {
                    case "s":
                    case "n":break;
                    default: throw new Exception(argument + " no es una opción válida");
                }
            }
        };

        CustomCaster<String, String> caster = new CustomCaster<String, String>() {
            @Override
            public String cast(String argument) throws Exception {
                return String.valueOf(argument.charAt(0));
            }
        };

        try {
            String op = input.get("* Estas seguro? (s|n) >> ", validador, caster,1);
            if (op.equals("s")) {
                targetMenu.cerrarMenu();
            }
        } catch (Exception ignored) {}

    }
}
