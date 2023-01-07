package validacion;

public interface Validador<T> {
    void validar() throws Exception;
    void validar(T argument) throws Exception;
}
