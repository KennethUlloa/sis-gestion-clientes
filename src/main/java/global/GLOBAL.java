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
    public static String getUsuarioDB() {
        try (FileInputStream fileInputStream = new FileInputStream("./init.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty("JDBC_USER");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getContraseniaDB() {
        try (FileInputStream fileInputStream = new FileInputStream("./init.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty("JDBC_PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean getUseAuth() {
        try (FileInputStream fileInputStream = new FileInputStream("./init.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String value = properties.getProperty("JDBC_USE_AUTH","false");
            return value.equals("true");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
