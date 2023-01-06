package usuarios;

import database.ControladorBD;
import database.SQLTable;
import java.sql.SQLException;

public class ControladorUsuario {
    public static void main(String[] args) {
        ControladorBD controladorBD = ControladorBD.getInstance();
        try {
            SQLTable sqltable = controladorBD.ejecutarSentencia("select * from usuarios");
            System.out.println(sqltable.getRowCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
