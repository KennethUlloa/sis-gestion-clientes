package console.input;

public class BooleanCaster implements CustomCaster<Boolean, String>{
    @Override
    public Boolean cast(String argument) throws Exception {
        if(argument.matches("(-)?[0-9]+")) {
            int value = Integer.parseInt(argument);
            return value > 0;
        }
        return Boolean.parseBoolean(argument);
    }
}
