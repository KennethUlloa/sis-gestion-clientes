package global;

import usuarios.Usuario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GLOBAL {
    private static Usuario usuarioLoggeado = null;
    private GLOBAL instance;
    public static boolean existeUsuarioRegistrado() {
        return usuarioLoggeado != null;
    }

    public static void setUsuarioLoggeado(Usuario usuario1) {
        usuarioLoggeado = usuario1;
    }

    public static Usuario getUsuarioLoggeado() {
        return usuarioLoggeado;
    }
    public static String getStringDB() {

        try (FileInputStream fileInputStream = new FileInputStream("./init.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty("JDBC_STRING","jdbc:sqlite:database.db");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
