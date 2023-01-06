package fichas;

import clientes.Parser;

import java.time.LocalTime;

public class Horario {
    private LocalTime inicio;
    private LocalTime fin;

    public Horario(LocalTime inicio, LocalTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Horario(String inicio, String fin) {
        this.inicio = Parser.toLocalTime(inicio);
        this.fin = Parser.toLocalTime(fin);
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                '}';
    }
}
