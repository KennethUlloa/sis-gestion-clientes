package console.input;
/**
 * @param <T> Output type
 * @param <K> Input type
 */
public interface CustomCaster<T, K> {

    T cast(K argument) throws Exception;
}
