package fichas;

import java.time.LocalTime;

public class Horario {
    private LocalTime inicio;
    private LocalTime fin;

    public Horario(LocalTime inicio, LocalTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
}
