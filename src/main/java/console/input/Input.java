package console.input;

import validacion.Validador;
import validacion.ValidadorInactivo;

import java.util.Scanner;

public class Input {
    private int mode;
    public static final int NEXT = 0, NEXT_LINE = 1;
    private Scanner scanner;
    private int MAX_INTENTS = 3;

    public Input(int mode, Scanner scanner) {
        this.mode = (mode == NEXT_LINE)? NEXT_LINE : NEXT;
        this.scanner = scanner;
    }

    public Input(){
        this(NEXT, new Scanner(System.in));
    }

    public Input(Scanner scanner){
        this(NEXT, scanner);
    }

    public <T> T get(String prompt, Validador<T> validador, CustomCaster<T, String> caster, int attempts) throws Exception {
        T parameter = null;
        int posibleAttempts = Math.max(1, Math.min(100, attempts));
        int currentAttempt = 0;
        Exception exception = null;
        while (currentAttempt < posibleAttempts) {
            System.out.print(prompt);
            String op = getInput();
            try {
                parameter = caster.cast(op);
                validador.validar(parameter);
                currentAttempt = posibleAttempts;
                exception = null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                currentAttempt += 1;
                exception = e;
            }
        }

        if(exception != null) {
            throw exception;
        }

        return parameter;
    }

    public <T> T get(String prompt, Validador<T> validador, CustomCaster<T, String> caster) throws Exception {
        return get(prompt, validador, caster, MAX_INTENTS);
    }

    public void setMaxChances(int numChances) {
        MAX_INTENTS = numChances;
    }

    private String getInput() {
        return (mode == NEXT_LINE)? scanner.nextLine() : scanner.next();
    }

    public void setMode(int mode) {
        this.mode = (mode == NEXT_LINE)? NEXT_LINE : NEXT;
    }

    public String get() throws Exception {
        return get("", new ValidadorInactivo<>(), new NoActionCaster<>(), MAX_INTENTS);
    }

    public String get(String prompt) throws Exception {
        return get(prompt, new ValidadorInactivo<>(), new NoActionCaster<>(), MAX_INTENTS);
    }

    public String get(int mode) throws Exception {
        setMode(mode);
        return get("", new ValidadorInactivo<>(), new NoActionCaster<>(), MAX_INTENTS);
    }

    public String get(String prompt, int attempts) throws Exception {
        return get(prompt, new ValidadorInactivo<>(), new NoActionCaster<>(), attempts);
    }
}
