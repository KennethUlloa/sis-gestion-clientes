package fichas;

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
}
