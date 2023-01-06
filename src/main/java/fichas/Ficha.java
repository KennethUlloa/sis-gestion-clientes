package fichas;

import clientes.Cliente;
import clientes.Parser;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ficha {
    private String ID;
    private Cliente cliente;
    private ArrayList<RegistroActividad> registroActividades;
    private double altura;
    private double peso;
    private boolean estaActivo = false;
    private LocalDate fechaInicio;
    private LocalDate ultimaAsistencia;

    public Ficha(String ID, Cliente cliente, LocalDate fechaInicio, LocalDate ultimaAsistencia, boolean estaActivo) {
        this.ID = ID;
        this.cliente = cliente;
        registroActividades = new ArrayList<>();
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

    public ArrayList<RegistroActividad> getRegistroActividades() {
        return registroActividades;
    }

    public void registrarActividad(RegistroActividad registroActividad){
        registroActividades.add(registroActividad);
    }

    public String getID() {
        return ID;
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
                ", registroActividades=" + registroActividades + "\n" +
                ", altura=" + altura + "\n" +
                ", peso=" + peso + "\n" +
                ", estaActivo=" + estaActivo + "\n" +
                ", fechaInicio=" + fechaInicio + "\n" +
                ", ultimaAsistencia=" + ultimaAsistencia + "\n" +
                '}';
    }
}
