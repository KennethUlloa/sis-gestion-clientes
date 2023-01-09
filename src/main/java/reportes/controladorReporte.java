package reportes;

import clientes.ControladorCliente;
import database.ControladorBD;
import database.SQLTable;
import database.exceptions.NoSuchColumn;

import java.sql.SQLException;

public class controladorReporte {
    private ControladorBD controladorBD;
    private ControladorCliente controladorCliente;
    public controladorReporte() {
        controladorBD = ControladorBD.getInstance();
        controladorCliente = new ControladorCliente();
    }

    public SQLTable informacionCliente (String ci) throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select * from clientes where cedula='" + ci + "'");
        return result ;
    }

    public SQLTable reporteAvance (String id) throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select peso, altura, esta_activo from ficha_cliente where id='" + id + "'");
        return result ;
    }

    public SQLTable reportePagos (String ci) throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select * from registro_pagos where ci='" + ci + "'");
        return result ;
    }
    public SQLTable reporteTiempoInscripcion (String id) throws SQLException, NoSuchColumn {
        SQLTable result = controladorBD.ejecutarSentencia("select fecha_inicio, ultima_asistencia from ficha_cliente where id='" + id + "'");
        return result ;
    }
}
