package validacion;

public class ValidadorPesoAltura implements Validador<Double>{

    private double valor;

    public ValidadorPesoAltura(double valor) {
        this.valor = valor;
    }

    public ValidadorPesoAltura() {}
    @Override
    public void validar() throws Exception {
        validar(valor);
    }

    @Override
    public void validar(Double argument) throws Exception {
        if(argument < 0) throw new Exception("No se permiten valores negativos: " + argument);
    }
}
