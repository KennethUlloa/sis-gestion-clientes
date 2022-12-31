package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Opcion> opciones;

    public Menu() {
        opciones = new ArrayList<Opcion>();
    }

    public void mostrarOpciones() {
        System.out.println("====== MENU ======");
        for(int i = 0; i < opciones.size() ; i++) {
            System.out.println((i+1) + ") " + opciones.get(i));
        }
    }

    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
    }

    public Opcion obtenerOpcion(int index) {
        return opciones.get(index);
    }

    public void mostrarSeleccion() {
        mostrarOpciones();
        Scanner scanner = new Scanner(System.in);
        System.out.print(">> ");
        int op = scanner.nextInt();
        obtenerOpcion(op - 1).ejecutar();
    }
}
