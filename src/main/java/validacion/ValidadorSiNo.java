package validacion;

public class ValidadorSiNo implements Validador<String> {

    private final String SI, NO;

    public ValidadorSiNo(String SI, String NO) {
        this.SI = SI;
        this.NO = NO;
    }

    @Override
    public void validar() throws Exception {

    }

    @Override
    public void validar(String argument) throws Exception {
        if(!argument.equals(SI) && !argument.equals(NO)) throw new Exception(argument + " no es una opción válida");
    }
}
