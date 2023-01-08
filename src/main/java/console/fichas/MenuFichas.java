package console.fichas;

import console.Menu;
import console.Opcion;
import console.OpcionRegresar;

public class MenuFichas extends Menu {
    public MenuFichas() {
        super("MENÚ FICHAS");
        agregarOpcion(new OpcionConsultarFicha(this));
        agregarOpcion(new OpcionCrearFicha());
        agregarOpcion(new OpcionRegistrarHorario());
        agregarOpcion(new OpcionRegresar(this));
    }
}
