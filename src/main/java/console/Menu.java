package console;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private final String titulo;
    private ArrayList<Opcion> opciones;
    private boolean repetir = true;
    private Object[] arguments;

    public Menu(String titulo) {
        this.titulo = titulo;
        opciones = new ArrayList<Opcion>();
    }

    public void mostrarOpciones() {
        System.out.println("====== " + titulo + " ======");
        antesDeOpciones();
        for(int i = 0; i < opciones.size() ; i++) {
            System.out.println("    " + (i+1) + ") " + opciones.get(i));
        }
        despuesDeOpciones();
    }

    public void setArguments(Object... arguments) {
        this.arguments = arguments;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
    }

    public Opcion obtenerOpcion(int index) {
        return opciones.get(index);
    }

    public void antesDeOpciones() {}

    public void despuesDeOpciones() {}

    public void mostrarSeleccion() {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        while(repetir){
            mostrarOpciones();
            System.out.print(">> ");
            op = scanner.nextInt();
            if(validarOpcion(op)){
                obtenerOpcion(op - 1).ejecutar(arguments);
            }

        };
    }

    public int contarOpciones() {
        return opciones.size();
    }

    public boolean validarOpcion(int opcion) {
        return opcion-1 >= 0 && opcion-1 < contarOpciones();
    }

    public void cerrarMenu() {
        repetir = false;
    }



}
