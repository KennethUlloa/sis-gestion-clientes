package fichas;

import database.ControladorBD;
import database.SQLTable;
import database.exceptions.NoSuchColumn;

import java.sql.SQLException;

public class ControladorActividad {
    private ControladorBD controladorBD;

    public ControladorActividad() {
        controladorBD = ControladorBD.getInstance();
    }

    public Actividad consultarActividad(String id) throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select * from actividades where id='" + id + "'");
        return new Actividad(
                (String) result.getValueAt(0,"id"),
                (String) result.getValueAt(0, "nombre"),
                (String) result.getValueAt(0, "descripcion")
        );
    }
}
