package fichas;

import clientes.Cliente;
import clientes.Parser;

import java.time.LocalTime;

public class Horario {
    private LocalTime inicio;
    private LocalTime fin;
    private Actividad actividad;
    private int dia;

    public Horario(LocalTime inicio, LocalTime fin, Actividad actividad, int dia) {
        this.inicio = inicio;
        this.fin = fin;
        this.actividad = actividad;
        this.dia = dia;
    }

    public Horario(String inicio, String fin, Actividad actividad, int dia) {
        this(Parser.toLocalTime(inicio), Parser.toLocalTime(fin), actividad, dia);
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }
    public int getDia() {return dia;}

    public Actividad getActividad() {
        return actividad;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                ", actividad=" + actividad +
                ", dia=" + dia +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        Horario horario = (Horario) obj;
        return this.inicio.equals(horario.inicio) &&
                this.fin.equals(horario.fin) &&
                this.actividad.equals(horario.actividad) &&
                this.dia == horario.dia;
    }
}
