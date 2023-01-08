package console;

public class Console {
    public static String repeat(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.append(string.repeat(Math.max(0, n)));
        return stringBuilder.toString();
    }
}
