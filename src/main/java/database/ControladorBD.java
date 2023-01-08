package database;

import global.GLOBAL;

import java.sql.*;

public class ControladorBD {
    private String url;
    private String user;
    private String password;
    private boolean useAuth;
    private static ControladorBD instance;
    private ControladorBD(String url, String user, String password, boolean useAuth) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.useAuth = useAuth;
    }
    private ControladorBD(String url){
        this(url, null, null, false);
    }

    public static ControladorBD getInstance() {
        if (instance == null){
                instance = new ControladorBD(GLOBAL.getStringDB(), GLOBAL.getUsuarioDB(), GLOBAL.getContraseniaDB(), GLOBAL.getUseAuth());
        }
        return instance;
    }

    public SQLTable ejecutarSentencia(String sentencia) throws SQLException {
        Connection connection = getConnection();
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
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        for(String sentencia: sentencias){
            statement.addBatch(sentencia);
        }
        statement.executeBatch();
    }

    private Connection getConnection() throws SQLException {
        if(useAuth) {
            return DriverManager.getConnection(this.url, user, password);
        }else{
            return DriverManager.getConnection(this.url);
        }
    }
}
