package console.autenticacion;

import console.Opcion;
import console.input.Input;
import console.input.IntegerCaster;
import database.ControladorBD;
import database.SQLTable;
import usuarios.ControladorUsuario;
import usuarios.Rol;
import usuarios.Usuario;
import validacion.Validador;


import java.sql.SQLException;
import java.util.Scanner;

public class OpcionModificarUsuario extends Opcion {
    public OpcionModificarUsuario() {
        super("Modificar rol usuario");
    }

    @Override
    public void ejecutar(Object... argumentos) {

        Scanner scanner = new Scanner(System.in);
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        Input input = new Input(new Scanner(System.in));
        try {
            controladorUsuario.consultarTablaUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Validador<Integer> rango = new Validador<Integer>() {
                @Override
                public void validar() throws Exception {

                }

                @Override
                public void validar(Integer argument) throws Exception {
                    int length = Rol.values().length;
                    if(argument < 1 || argument > length) throw new Exception("Selección no válida: " + argument);
                }
            };
            Usuario usuario =
                    controladorUsuario.consultarUsuario
                            (input.get("* Ingresa el nombre del usuario a cambiar su rol>> ", 0));
//            System.out.print("* Elegir nuevo Rol: (1.Administrador,2.Usuario) >> ");
            int rol = input.get("* Elegir nuevo Rol: (1.Administrador,2.Usuario) >> ",
                    rango,
                    new IntegerCaster(), 1);
            Rol[] roles = Rol.values();
            controladorUsuario.actualizarRolCliente(usuario.getUsuario(),roles[rol-1]);
            System.out.println("Cambio de rol exitoso!");
            SQLTable result = ControladorBD.getInstance().ejecutarSentencia(
                    "select usuario, rol from usuarios where usuario='" + usuario.getUsuario() + "'");
            System.out.println(result);
        } catch (SQLException ignored) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
