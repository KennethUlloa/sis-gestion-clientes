package console.input;

public class NoActionCaster<T> implements CustomCaster<T, T>{
    @Override
    public T cast(T argument) throws Exception {
        return argument;
    }
}
