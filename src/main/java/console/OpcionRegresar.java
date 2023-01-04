package console;

public class OpcionRegresar extends Opcion{
    private Menu targetMenu;
    public OpcionRegresar(Menu targetMenu) {
        super("Regresar");
        this.targetMenu = targetMenu;
    }

    @Override
    public void ejecutar(Object... argumentos) {
        targetMenu.cerrarMenu();
    }
}
