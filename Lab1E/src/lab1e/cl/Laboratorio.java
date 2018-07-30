package lab1e.cl;

public class Laboratorio {

    private int codigo;
    private String nombre;
    private int capacidad;

    public Laboratorio() {
    }

    public Laboratorio(int codigo, String nombre, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + capacidad;
    }

    public String toStringUI() {
        return "Laboratorio: Código: " + codigo + ", Nombre: " + nombre + ", Capacidad: " + capacidad;
    }
}
