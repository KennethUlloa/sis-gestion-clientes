package validacion;

import clientes.Cliente;
import clientes.excepciones.ErrorCedula;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidadorCedulaTest {

    @Test(expected = ErrorCedula.class)
    public void given_new_client_when_not_valid_cedula_then_error() throws ErrorCedula {
        Cliente c= new Cliente("1514","Angelo Alexandro",
                "Abad Abarca","15-08-1997",
                'M',"0963870957",
                "Diana Abad","0964255255",
                "abad14@gmail.com","Av.Maldonado");
        ValidadorCedula val = new ValidadorCedula(c.getCedula());
        val.validar();
    }

    @Test
    public void given_new_client_when_valid_cedula_then_ok() throws ErrorCedula {
        Cliente c= new Cliente("1753953866","Angelo Alexandro",
                "Abad Abarca","15-08-1997",
                'M',"0963870957",
                "Diana Abad","0964255255",
                "abad14@gmail.com","Av.Maldonado");
        ValidadorCedula val=new ValidadorCedula(c.getCedula());
        val.validar();
    }

}

