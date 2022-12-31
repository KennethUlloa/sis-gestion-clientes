package clientes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private String cedula;
    private String nombres;
    private String apellidos;
    private LocalDate fecha;
    private char sexo;
    private String telefono;
    private String nombreContacto;
    private String telefonoContacto;
    private String correoElectronico;
    private String direccion;

    public Cliente(String cedula, String nombres, String apellidos, String fecha, char sexo, String telefono, String nombreContacto,
                   String telefonoContacto, String correoElectronico, String direccion) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha = stringALocalDate(fecha);
        this.sexo = sexo;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;

    }

    public static LocalDate stringALocalDate(String fecha) {
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public char getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha=" + fecha +
                ", sexo=" + sexo +
                ", telefono='" + telefono + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", telefonoContacto='" + telefonoContacto + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
