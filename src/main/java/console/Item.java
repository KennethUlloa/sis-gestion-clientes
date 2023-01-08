package console;

public abstract class Item<T> {
    private T valor;
    public Item(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public abstract String getNombre();
}
