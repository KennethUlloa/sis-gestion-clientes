package informes;

import database.ControladorBD;
import database.SQLTable;
import database.exceptions.NoSuchColumn;

import java.sql.SQLException;

public class controladorInformes {
    private ControladorBD controladorBD;

    public controladorInformes() {
        controladorBD = ControladorBD.getInstance();
    }

    public SQLTable consultarFechasEspeciales() throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select * from fechas_especiales");
        return result;
    }

    public SQLTable consultarCumpleanios() throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select cedula, apellidos, nombres, fecha_nacimiento from clientes");
        return result;
    }
}
