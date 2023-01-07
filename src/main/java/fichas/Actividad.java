package fichas;

import clientes.Cliente;

public class Actividad {
    private final String ID;
    private String nombre;
    private String descripcion;

    public Actividad(String ID, String nombre, String descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Actividad{" + "\n" +
                "ID='" + ID + '\'' + "\n" +
                ", nombre='" + nombre + '\'' + "\n" +
                ", descripcion='" + descripcion + '\'' + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        Actividad actividad = (Actividad) obj;
        return this.ID.equals(actividad.ID) &&
                this.nombre.equals(actividad.nombre) &&
                this.descripcion.equals(actividad.descripcion);
    }
}
