package usuarios;

public class Usuario {
    private String usuario;
    private String contrasena;
    private Rol rol;

    public Usuario(String usuario, String contrasena, Rol rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;

    }

    public String getUsuario() {
        return usuario;
    }

    public String getRol() {
        return rol.name();
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRol(Rol rol){
        this.rol = rol;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "   usuario='" + usuario + "'\n" +
                "   contrasena='" + contrasena + "'\n" +
                "   rol='" + rol.name() + "'\n" +
                '}';
    }

}

