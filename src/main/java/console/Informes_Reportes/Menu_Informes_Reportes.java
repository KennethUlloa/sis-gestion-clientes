package console.Informes_Reportes;

import console.Menu;
import console.OpcionRegresar;
import console.Opcion;


import console.clientes.OpcionRegistrarCliente;

public class Menu_Informes_Reportes extends Menu {
    public Menu_Informes_Reportes() {
        super("MENÚ DE REPORTES E INFORMES");
        agregarOpcion(new OpcionInformeCumpleaños());
        agregarOpcion(new OpcionInformeFechasEspeciales());
        agregarOpcion(new OpcionReporteAvances());
        agregarOpcion(new OpcionReportePagos());
        agregarOpcion(new OpcionReporteTiempoInscripcion());
        agregarOpcion(new OpcionRegresar(this));
    }
}
