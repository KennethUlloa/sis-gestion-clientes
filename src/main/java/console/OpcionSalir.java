package console;

import java.util.Scanner;

public class OpcionSalir extends Opcion{
    public OpcionSalir() {
        super("Salir");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        System.out.print("¿Está seguro? (s) >> ");
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        if ("s".equals(op)) {
            System.exit(0);
        }
    }
}
