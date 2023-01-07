package console;

public abstract class Opcion {
    private String descripcion;
    private Menu parent;
    public Opcion(String descripcion, Menu menu) {
        this.parent = menu;
        this.descripcion = descripcion;
    }

    public Opcion(String descripcion) {
        this(descripcion, null);
    }
    public Menu getParent() {
        return parent;
    }

    public abstract void ejecutar(Object... argumentos);

    @Override
    public String toString() {
        return descripcion;
    }
}
