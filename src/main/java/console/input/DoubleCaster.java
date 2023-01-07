package console.input;

public class DoubleCaster implements CustomCaster<Double, String >{
    @Override
    public Double cast(String argument) throws Exception {
        try {
            return Double.parseDouble(argument);
        }catch (NumberFormatException e) {
            throw new Exception("Formato numérico incorrecto: " + argument);
        }
    }
}
