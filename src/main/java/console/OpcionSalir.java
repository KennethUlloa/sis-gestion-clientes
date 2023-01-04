package console;

import java.util.Scanner;

public class OpcionSalir extends Opcion{
    private MenuPrincipal targetMenu;
    public OpcionSalir(MenuPrincipal targetMenu) {
        super("Salir");
        this.targetMenu = targetMenu;
    }

    @Override
    public void ejecutar(Object... argumentos) {
        System.out.print("¿Está seguro? (s) >> ");
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        if ("s".equals(op)) {
            targetMenu.cerrarMenu();
            //System.exit(0);
        }
    }
}
