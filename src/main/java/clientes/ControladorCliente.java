package clientes;

import clientes.excepciones.ErrorCedula;
import database.ControladorBD;
import database.SQLTable;
import validacion.ValidadorCedula;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControladorCliente {
    private ControladorBD controladorBD;

    public ControladorCliente(ControladorBD controladorBD) {
        this.controladorBD = controladorBD;
    }
    public ControladorCliente() {this.controladorBD = ControladorBD.getInstance();}

    public void registrarCliente(Cliente cliente) throws Exception{
        ValidadorCedula validadorCedula = new ValidadorCedula(cliente.getCedula());
        validadorCedula.validar();
        String cedula = cliente.getCedula();
        String nombres = cliente.getNombres();
        String apellidos = cliente.getApellidos();
        LocalDate fecha = cliente.getFecha();
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        char sexo = cliente.getSexo();
        String telefono=cliente.getTelefono();
        String nombreContacto = cliente.getNombreContacto();
        String telefonoContacto = cliente.getTelefonoContacto();
        String correoElectronico = cliente.getCorreoElectronico();
        String direccion = cliente.getDireccion();

        String formato = "INSERT INTO clientes VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
        String sentencia = String.format(formato, cedula, nombres, apellidos, sexo, fechaFormateada, correoElectronico, telefono, nombreContacto, telefonoContacto, direccion);
        try{
            controladorBD.ejecutarSentencia(sentencia);
        }catch (SQLException ex){

            throw new Exception("El sistema no pudo registrar al cliente");
        }
    }

    public Cliente consultarCliente(String cedula) throws ErrorCedula {
        new ValidadorCedula(cedula).validar();
        try{
            SQLTable resultado = controladorBD.ejecutarSentencia("select * from clientes where cedula="+cedula);
            if(resultado.getRowCount() == 0) return null;
            String nombres = (String) resultado.getValueAt(0,"nombres");
            String apellidos = (String) resultado.getValueAt(0,"apellidos");
            String fecha = (String)resultado.getValueAt(0,"fecha_nacimiento");
            char sexo = ((String)resultado.getValueAt(0,"sexo")).charAt(0);
            String telefono = (String)resultado.getValueAt(0,"telefono");
            String nombreContacto = (String)resultado.getValueAt(0,"nombre_contacto");
            String telefonoContacto = (String)resultado.getValueAt(0,"telefono_contacto");
            String correoElectronico = (String)resultado.getValueAt(0,"correo_electronico");
            String direccion = (String)resultado.getValueAt(0,"direccion");

            return new Cliente(cedula,nombres,apellidos,fecha,sexo,telefono,nombreContacto,
                    telefonoContacto,correoElectronico,direccion);
        }catch (Exception ex){
            return null;
        }
    }

    public void actualizarCliente(Cliente cliente) throws Exception{
        //TODO: borrar comentarios guia
        String cedula = cliente.getCedula();
        String nombres = cliente.getNombres();
        String apellidos = cliente.getApellidos();
        LocalDate fecha = cliente.getFecha();
        String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        char sexo = cliente.getSexo();
        String telefono=cliente.getTelefono();
        String nombreContacto = cliente.getNombreContacto();
        String telefonoContacto = cliente.getTelefonoContacto();
        String correoElectronico = cliente.getCorreoElectronico();
        String direccion = cliente.getDireccion();

        try{
            String formato = "UPDATE clientes\n" +
                    //"   SET cedula = '%s',\n" + NO SE ACTUALIZA EL ID JAMÁS!!!!
                    "       nombres = '%s',\n" +
                    "       apellidos = '%s',\n" +
                    "       sexo = '%s',\n" +
                    "       fecha_nacimiento = '%s',\n" +
                    "       correo_electronico = '%s',\n" +
                    "       telefono = '%s',\n" +
                    "       nombre_contacto = '%s',\n" +
                    "       telefono_contacto = '%s',\n" +
                    "       direccion = '%s'\n" +
                    " WHERE cedula = '%s';";

            String sentencia = String.format(formato, cedula, nombres, apellidos, sexo, fechaFormateada, correoElectronico, telefono, nombreContacto, telefonoContacto, direccion,cedula);
            controladorBD.ejecutarSentencia(sentencia);
        }catch (Exception ex){

            throw new Exception("El sistema no pudo actualizar el cliente");
        }

    }

    public void eliminarCliente(String cedula) throws Exception {
        try{
        controladorBD.ejecutarSentencia("delete from clientes where cedula="+cedula);
        }catch (SQLException ex){

            throw new Exception("El sistema no pudo eliminar al cliente");
        }
    }


}
