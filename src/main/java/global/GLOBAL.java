package global;

import usuarios.Usuario;

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

}
