package usuarios;

public class Usuario {
    String usuario;
    String contrasena;
    String rol;

    public Usuario(String usuario, String contrasena, String rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }
    public String getRol(){
        return rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setRol(String rol){
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
                '}';
    }

}

