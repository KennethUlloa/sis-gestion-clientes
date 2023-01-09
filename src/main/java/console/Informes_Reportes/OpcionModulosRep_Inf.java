package console.Informes_Reportes;

import console.Opcion;
import console.fichas.MenuFichas;

public class OpcionModulosRep_Inf extends Opcion {
    public OpcionModulosRep_Inf() {
        super("Reportes e Informes");
    }

    @Override
    public void ejecutar(Object... argumentos) {
        Menu_Informes_Reportes menu_informes_reportes = new Menu_Informes_Reportes();
        menu_informes_reportes.mostrarSeleccion();
    }
}
