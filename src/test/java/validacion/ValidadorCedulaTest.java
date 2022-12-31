package validacion;

import clientes.Cliente;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidadorCedulaTest {

    @Test
    public void given_new_client_when_not_valid_cedula_then_error(){
        Cliente c= new Cliente("1514","Angelo Alexandro",
                "Abad Abarca","15-08-1997",
                'M',"0963870957",
                "Diana Abad","0964255255",
                "abad14@gmail.com","Av.Maldonado");
        ValidadorCedula val=new ValidadorCedula(c);
        Exception error=null;
        try {
            val.validar();
        } catch (Exception e) {
            error=e;
        }

        assertNotNull(error);
    }

    @Test
    public void given_new_client_when_valid_cedula_then_ok(){
        Cliente c= new Cliente("1753953866","Angelo Alexandro",
                "Abad Abarca","15-08-1997",
                'M',"0963870957",
                "Diana Abad","0964255255",
                "abad14@gmail.com","Av.Maldonado");
        ValidadorCedula val=new ValidadorCedula(c);
        Exception error=null;
        try {
            val.validar();
        } catch (Exception e) {
            error=e;
        }

        assertNull(error);
    }

}

