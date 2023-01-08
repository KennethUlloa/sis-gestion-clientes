package console;

import console.input.Input;
import console.input.IntegerCaster;
import validacion.ValidadorInactivo;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSeleccion<T> {
    private ArrayList<Item<T>> items;
    private String titulo;

    public MenuSeleccion(String titulo) {
        this.titulo = titulo;
        items = new ArrayList<>();
    }

    public void agregarItem(Item<T> e) {
        items.add(e);
    }

    public T mostrarItems() {
        if (items.size() == 0) return null;
        System.out.println(titulo);
        for(int i = 0; i < items.size() ; i++) {
            System.out.printf("    (%d) %s\n", i + 1, items.get(i).getNombre());
        }
        Input input = new Input(Input.NEXT_LINE, new Scanner(System.in));
        try {
            int op = input.get("* Selección >> ", new ValidadorInactivo<>(), new IntegerCaster());
            return items.get(op - 1).getValor();
        } catch (Exception e) {
            return null;
        }
    }


}
