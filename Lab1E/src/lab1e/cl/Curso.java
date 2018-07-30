package lab1e.cl;

public class Curso {

    private String codigo;
    private String nombre;
    private int creditos;

    public Curso() {
    }

    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + creditos;
    }

    public String toStringUI() {
        return "Curso: " + " Código: " + codigo + ", Nombre: " + nombre + ", Créditos: " + creditos;
    }
}