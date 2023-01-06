package console.fichas;

import console.Opcion;

public class OpcionModuloFichas extends Opcion {
    public OpcionModuloFichas() {
        super("Fichas");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        MenuFichas menuFichas = new MenuFichas();
        menuFichas.mostrarSeleccion();
    }
}
