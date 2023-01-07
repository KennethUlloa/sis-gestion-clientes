package console.input;

import validacion.Validador;
import validacion.ValidadorInactivo;

import java.io.InputStream;
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

    public <T> T get(String prompt, Validador<T> validador, CustomCaster<T, String> caster, boolean multiple) {
        boolean continue_ = true;
        T parameter = null;
        int currentTry = 1;
        do {
            System.out.print(prompt);
            String op = getInput();
            try {
                parameter = caster.cast(op);
                validador.validar(parameter);
                if(!multiple || currentTry >= MAX_INTENTS) {
                    break;
                }
                continue_ = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                currentTry += 1;
            }
        }while(continue_);
        return parameter;
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

    public String get() {
        return get("", new ValidadorInactivo<String>(), new NoActionCaster<String>(), false);
    }

    public String get(String prompt) {
        return get(prompt, new ValidadorInactivo<String>(), new NoActionCaster<String>(), false);
    }

    public String get(int mode) {
        setMode(mode);
        return get("", new ValidadorInactivo<String>(), new NoActionCaster<String>(), false);
    }
}
