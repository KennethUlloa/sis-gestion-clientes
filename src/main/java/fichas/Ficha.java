package fichas;

import clientes.Cliente;
import clientes.Parser;
import console.TableDisplay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class Ficha {
    private String ID;
    private Cliente cliente;
    private ArrayList<Horario> horarios;
    private double altura;
    private double peso;
    private boolean estaActivo = false;
    private LocalDate fechaInicio;
    private LocalDate ultimaAsistencia;

    public Ficha(String ID, Cliente cliente, LocalDate fechaInicio, LocalDate ultimaAsistencia, boolean estaActivo) {
        this.ID = ID;
        this.cliente = cliente;
        horarios = new ArrayList<>();
        this.fechaInicio = fechaInicio;
        this.ultimaAsistencia = ultimaAsistencia;
        this.estaActivo = estaActivo;
    }

    public Ficha(String ID, Cliente cliente, String fechaInicio, String ultimaAsistencia, boolean estaActivo) {
        this(ID, cliente, Parser.toLocalDate(fechaInicio), Parser.toLocalDate(ultimaAsistencia), estaActivo);
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getID() {
        return ID;
    }

    public void registrarHorario(Horario horario) {
        horarios.add(horario);
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void iniciarSeguimiento(LocalDate fecha) {
        this.fechaInicio = fecha;
        this.estaActivo = true;
    }

    public void finalizarSeguimiento(LocalDate fecha) {
        this.ultimaAsistencia = fecha;
        this.estaActivo = false;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getUltimaAsistencia() {
        return ultimaAsistencia;
    }

    public boolean estaActivo() {
        return estaActivo;
    }

    @Override
    public String toString() {
        TableDisplay<ArrayList<Horario>> horario = new TableDisplay<ArrayList<Horario>>() {
            ArrayList<Horario> base;
            String[] dias = new String[]{"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO","DOMINGO"};
            String[] columnNames = new String[]{"DIA","ACTIVIDAD","INICIO","FIN"};
            @Override
            public ArrayList<Horario> getBase() {
                return base;
            }

            @Override
            public void setBase(ArrayList<Horario> base) {
                this.base = base;
            }

            @Override
            public String getValueAt(int row, int column) {
                Horario horario = base.get(row);
                switch (column){
                    case 0: return dias[horario.getDia()-1].toUpperCase();
                    case 1: return horario.getActividad().getNombre();
                    case 2: return Parser.toString(horario.getInicio());
                    case 3: return Parser.toString(horario.getFin());
                }
                return "";
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public int getRowCount() {
                return base.size();
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }
        };

        horario.setBase(this.horarios);

        return "FICHA\n" +
                "CLIENTE: \n" + cliente + "\n" +
                "HORARIOS: \n" + horario + "\n" +
                "ALTURA: " + altura + "\n" +
                "PESO: " + peso + "\n" +
                "ACTIVO: " + (estaActivo? "SI" : "NO") + "\n" +
                "FECHA DE INICIO: " + Parser.toString(fechaInicio) + "\n" +
                "ULTIMA ASISTENCIA: " + Parser.toString(ultimaAsistencia) + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        Ficha ficha = (Ficha) obj;
        return this.ID.equals(ficha.ID) &&
                this.cliente.equals(ficha.cliente) &&
                this.fechaInicio.equals(ficha.fechaInicio) &&
                this.ultimaAsistencia.equals(ficha.ultimaAsistencia) &&
                this.estaActivo == ficha.estaActivo;
    }


}
