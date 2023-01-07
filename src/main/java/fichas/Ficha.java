package fichas;

import clientes.Cliente;
import clientes.Parser;

import java.time.LocalDate;
import java.util.ArrayList;

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
        return "Ficha{" + "\n" +
                "cliente=" + cliente + "\n" +
                ", horarios=" + horarios + "\n" +
                ", altura=" + altura + "\n" +
                ", peso=" + peso + "\n" +
                ", estaActivo=" + estaActivo + "\n" +
                ", fechaInicio=" + fechaInicio + "\n" +
                ", ultimaAsistencia=" + ultimaAsistencia + "\n" +
                '}';
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
