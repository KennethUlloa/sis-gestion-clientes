package usuarios;

import database.ControladorBD;
import database.SQLTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ControladorUsuarioTest {
    private Usuario usuario;
    private ControladorBD controladorBD;
    private ControladorUsuario controladorUsuario;

    @Before
    public void setUpTest() {
        usuario = new Usuario(
                "test",
                "1234",
                "Admin"
        );

        controladorBD = ControladorBD.getInstance();
        controladorUsuario = new ControladorUsuario();
    }

    @Test
    public void given_user_when_registration_then_ok() throws Exception {
        controladorUsuario.registrarUsuario(usuario);
        ControladorBD controladorBD = ControladorBD.getInstance();
        SQLTable result = controladorBD.ejecutarSentencia("select * from usuarios where usuario='" + usuario.getUsuario() + "'");
        assertEquals(result.getValueAt(0, "usuario"), usuario.getUsuario());
        assertEquals(result.getValueAt(0, "contrasenia"), usuario.getContrasena());
        assertEquals(result.getValueAt(0, "rol"), usuario.getRol());
    }
    @Test(expected = Exception.class)
    public void given_inexistent_username_when_authentication_then_error() throws Exception {
        controladorUsuario.validarCredenciales("admin","1234");
    }

    @After
    public void after() {
        try {
            controladorBD.ejecutarSentencia("delete from usuarios where usuario='" + usuario.getUsuario() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}