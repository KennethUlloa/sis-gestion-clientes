package console.input;

public class IntegerCaster implements CustomCaster<Integer, String> {
    @Override
    public Integer cast(String argument) throws Exception {
        try {
            return Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new Exception("Error de formato numérico: " + argument);
        }
    }
}
