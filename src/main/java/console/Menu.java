package console;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private final String titulo;
    private ArrayList<Opcion> opciones;

    public Menu(String titulo) {
        this.titulo = titulo;
        opciones = new ArrayList<Opcion>();
    }

    public void mostrarOpciones() {
        System.out.println("====== " + titulo + " ======");
        for(int i = 0; i < opciones.size() ; i++) {
            System.out.println("    " + (i+1) + ") " + opciones.get(i));
        }
    }

    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
    }

    public Opcion obtenerOpcion(int index) {
        return opciones.get(index);
    }

    public void mostrarSeleccion() {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        do{
            mostrarOpciones();
            System.out.print(">> ");
            op = scanner.nextInt();
            if(validarOpcion(op)){
                obtenerOpcion(op - 1).ejecutar();
            }
        }while(!cerrarMenu(op));
    }

    public int contarOpciones() {
        return opciones.size();
    }

    public abstract boolean cerrarMenu(int op);

    public abstract boolean validarOpcion(int opcion);


}
