package fichas;

import clientes.Cliente;
import clientes.Parser;
import database.SQLStorable;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Horario implements SQLStorable {
    private LocalTime inicio;
    private LocalTime fin;
    private Actividad actividad;
    private int dia;

    private String ID;

    public Horario(String ID, LocalTime inicio, LocalTime fin, Actividad actividad, int dia) {
        this.ID = ID;
        this.inicio = inicio;
        this.fin = fin;
        this.actividad = actividad;
        this.dia = dia;
    }

    public Horario(String ID, String inicio, String fin, Actividad actividad, int dia) {
        this(ID, Parser.toLocalTime(inicio), Parser.toLocalTime(fin), actividad, dia);
    }

    public static Horario generarHorario(String inicio, String fin, Actividad actividad, int dia){
        StringBuilder id = new StringBuilder("H");
        int current = 0;
        for(int i = 0 ; i < 10 ; i++) {
            current = 65 + (int) (Math.random()*25);
            id.append((char) current);
        }
        return new Horario(id.toString(), inicio, fin, actividad, dia);
    }

    public static Horario generarHorario(LocalTime inicio, LocalTime fin, Actividad actividad, int dia){
        StringBuilder id = new StringBuilder("H");
        int current = 0;
        for(int i = 0 ; i < 10 ; i++) {
            current = 65 + (int) (Math.random()*25);
            id.append((char) current);
        }
        return new Horario(id.toString(), inicio, fin, actividad, dia);
    }


    public String getID() {
        return ID;
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
        return "DIA: " + DayOfWeek.of(dia).getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("es-ES")) +
                "inicio: " + inicio +
                "fin=" + fin +
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

    @Override
    public String insert(String... args) {
        String ficha = args[0];
        return "INSERT INTO horarios_actividades('hora_inicio','hora_fin','actividad','ficha','dia','id') " +
                "VALUES(" +
                "'"+Parser.toString(inicio)+"'," +
                "'"+Parser.toString(fin)+"'," +
                "'"+actividad.getID()+"'," +
                "'"+ficha+"'," +
                "'"+dia+"'," +
                "'"+ID+"'" +
                ")";
    }

    @Override
    public String select(String... args) {
        return null;
    }

    @Override
    public String delete(String... args) {
        return null;
    }

    @Override
    public String update(String... args) {
        return "UPDATE horarios_actividades " +
                "SET hora_inicio = '" + Parser.toString(inicio) + "', " +
                "hora_fin = '" + Parser.toString(fin) + "', " +
                "dia = '" + dia + "'," +
                "actividad = '" + actividad.getID() + "' " +
                "WHERE id = '" + getID() + "'"
                ;
    }
}
