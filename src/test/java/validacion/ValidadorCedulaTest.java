package validacion;

import clientes.Cliente;
import clientes.excepciones.ErrorCedula;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidadorCedulaTest {

    @Test(expected = ErrorCedula.class)
    public void given_string_when_not_valid_cedula_then_error() throws ErrorCedula {
        ValidadorCedula val = new ValidadorCedula("1514");
        val.validar();
    }

    @Test(expected = ErrorCedula.class)
    public void given_string_when_not_numeric_then_error() throws ErrorCedula {
        ValidadorCedula val = new ValidadorCedula("c125ad#");
        val.validar();
    }

    @Test
    public void given_new_client_when_valid_cedula_then_ok() throws ErrorCedula {
        ValidadorCedula val=new ValidadorCedula("2256512712");
        val.validar();
    }

}

