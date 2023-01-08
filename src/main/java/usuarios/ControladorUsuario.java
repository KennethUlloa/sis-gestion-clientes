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
        Usuario usuario1 = consultarUsuario(usuario);

        if(!usuario1.getContrasena().equals(contrasenia)) throw new Exception("Contraseña incorrecta");

        return usuario1;
    }

    public Usuario consultarUsuario(String usuario) throws Exception {
        SQLTable result;
        try {
            result = controladorBD.ejecutarSentencia("select * from usuarios where usuario='"+ usuario +"'");
        } catch (SQLException e) {
            throw new Exception("No se pudo encontrar el  usuario");
        }

        if (result == null || result.getRowCount() == 0 ) throw new Exception("No existe un usuario: " + usuario);
        String rolString = (String) result.getValueAt(0, "rol");
        Rol rol = Rol.valueOf(rolString);
        Usuario usuario1 = new Usuario(
                (String) result.getValueAt(0, "usuario"),
                (String) result.getValueAt(0, "contrasenia"),
                rol
        );
        return usuario1;
    }

    public void actualizarRolCliente(String nombreUsuario,Rol rol) throws Exception {
        Usuario usuario = consultarUsuario(nombreUsuario);
        usuario.setRol(rol);
        try{
            String formato = "UPDATE usuarios " +
                    "SET rol = '%s'" +
                    "WHERE usuario = '%s';";
            String sentencia = String.format(formato,rol,usuario.getUsuario());
            controladorBD.ejecutarSentencia(sentencia);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            throw new Exception("El sistema no pudo actualizar el rol");
        }

    }
    public void eliminarUsuario(String nombreUsuario) throws Exception {
        Usuario usuario = consultarUsuario(nombreUsuario);
        try {
            controladorBD.ejecutarSentencia("delete from usuarios where usuario='" + usuario.getUsuario() + "'");
        } catch (SQLException ex) {
            throw new Exception("El sistema no pudo eliminar el usuario");
        }
    }
    public void consultarTablaUsuarios() throws SQLException {
        SQLTable result = controladorBD.ejecutarSentencia("select usuario,rol from usuarios");
        System.out.println(result);
    }
}
