package usuarios;

import database.ControladorBD;
import database.SQLTable;
import java.sql.SQLException;

public class ControladorUsuario {

    private ControladorBD controladorBD;

    public ControladorUsuario( ControladorBD controladorBD){
        this.controladorBD = controladorBD;
    }
    public ControladorUsuario(){
        this.controladorBD = ControladorBD.getInstance();
    }

    public Boolean verificarExistenciaUsuario() throws Exception{
        SQLTable resultado = controladorBD.ejecutarSentencia("select * from usuarios");
        return resultado.getRowCount() != 0;
    }

    public void registrarUsuario(Usuario usuario) throws Exception {
        String nombreUsuario = usuario.getUsuario();
        String contrasenia = usuario.getContrasena();
        String rol = usuario.getRol();

        String formato = "INSERT INTO usuarios VALUES('%s','%s','%s')";
        String sentencia = String.format(formato, nombreUsuario, contrasenia, rol);
        try{
            controladorBD.ejecutarSentencia(sentencia);
        }catch (SQLException ex) {
            throw new Exception("El sistema no pudo registrar el usuario");
        }
    }

    public Usuario validarCredenciales(String usuario, String contrasenia) throws Exception {
        SQLTable result = null;
        try {
            result = controladorBD.ejecutarSentencia("select * from usuarios where usuario='"+ usuario +"'");
        } catch (SQLException e) {
            throw new Exception("No se pudo validar el usuario");
        }

        if (result == null || result.getRowCount() == 0 ) throw new Exception("No existe un usuario: " + usuario);

        Usuario usuario1 = new Usuario(
                (String) result.getValueAt(0, "usuario"),
                (String) result.getValueAt(0, "contrasenia"),
                (String) result.getValueAt(0, "rol")
        );

        if(!usuario1.getContrasena().equals(contrasenia)) throw new Exception("Contraseña incorrecta");
        return usuario1;
    }
}
