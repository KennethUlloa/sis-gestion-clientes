package fichas;

public class RegistroActividad {
    private Actividad actividad;
    private Horario horario;
    private int dia;

    public RegistroActividad(Actividad actividad, Horario horario, int dia) {
        this.actividad = actividad;
        this.horario = horario;
        this.dia = dia;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public Horario getHorario() {
        return horario;
    }

    public int getDia() {
        return dia;
    }

    @Override
    public String toString() {
        return "RegistroActividad{" +
                "actividad=" + actividad +
                ", horario=" + horario +
                ", dia=" + dia +
                '}';
    }
}
