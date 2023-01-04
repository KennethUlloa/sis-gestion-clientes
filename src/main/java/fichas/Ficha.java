package fichas;

import clientes.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ficha {
    private Cliente cliente;
    private ArrayList<RegistroActividad> registroActividades;
    private double altura;
    private double peso;
    private boolean estaActivo = false;
    private LocalDate fechaInicio;
    private LocalDate ultimaAsistencia;

    public Ficha(Cliente cliente) {
        this.cliente = cliente;
        registroActividades = new ArrayList<>();
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

    public void registrarActividad(Actividad actividad, Horario horario) {
        registroActividades.add(new RegistroActividad(actividad, horario));
    }

    public void iniciarSeguimiento(LocalDate fecha) {
        this.fechaInicio = fecha;
        this.estaActivo = true;
    }

    public void finalizarSeguimiento(LocalDate fecha) {
        this.ultimaAsistencia = fecha;
        this.estaActivo = false;
    }
}
