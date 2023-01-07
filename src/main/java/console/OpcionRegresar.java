package console;

public class OpcionRegresar extends Opcion{
    //private Menu targetMenu;
    public OpcionRegresar(Menu targetMenu) {
        super("Regresar", targetMenu);
    }

    @Override
    public void ejecutar(Object... argumentos) {
        if(getParent() != null)
            getParent().cerrarMenu();
    }
}
