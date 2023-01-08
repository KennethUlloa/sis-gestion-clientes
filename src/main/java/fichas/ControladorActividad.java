package fichas;

import database.ControladorBD;
import database.SQLTable;
import database.exceptions.NoSuchColumn;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Actividad> consultarActividades() {
        ArrayList<Actividad> actividades = new ArrayList<>();
        try {
            SQLTable result = controladorBD.ejecutarSentencia("select * from actividades");
            for(int i = 0 ; i < result.getRowCount() ; i++) {
                actividades.add(new Actividad(
                        (String) result.getValueAt(i,"id"),
                        (String) result.getValueAt(i, "nombre"),
                        (String) result.getValueAt(i, "descripcion")));
            }
        } catch (Exception ignored) {}
        return actividades;
    }
}
