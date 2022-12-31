package menu;

public abstract class Opcion {
    private String descripcion;

    public Opcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract void ejecutar(Object... argumentos);

    @Override
    public String toString() {
        return descripcion;
    }
}
