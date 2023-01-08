package database;

import global.GLOBAL;

import java.sql.*;

public class ControladorBD {
    private String url;
    private static ControladorBD instance;
    private ControladorBD(String url) {
        this.url = url;
    }

    public static ControladorBD getInstance() {
        if (instance == null){
            instance = new ControladorBD(GLOBAL.getStringDB());
        }
        return instance;
    }

    public SQLTable ejecutarSentencia(String sentencia) throws SQLException {
        Connection connection = DriverManager.getConnection(this.url);
        PreparedStatement preparedStatement = connection.prepareStatement(sentencia);
        if(preparedStatement.execute()){ //Si al ejecutar la sentencia existe un resultado
            SQLTable table = new SQLTable(preparedStatement.getResultSet());
            connection.close();
            return table;
        }
        connection.close();
        return null;
    }

    public void ejecutarSentencias(String... sentencias) throws SQLException {
        Connection connection = DriverManager.getConnection(this.url);
        Statement statement = connection.createStatement();
        for(String sentencia: sentencias){
            statement.addBatch(sentencia);
        }
        statement.executeBatch();
    }
}
