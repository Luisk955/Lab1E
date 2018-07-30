package lab1e.cl;

public class Carrera {

    private String codigo;
    private String nombre;
    private String grado; //Puede ser técnico, diplomado, Bachillerato, Licenciatura y Maestría 
    private Boolean acreditada;

    public Carrera() {
    }

    public Carrera(String codigo, String nombre, String grado, Boolean acreditada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.grado = grado;
        this.acreditada = acreditada;
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

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public Boolean getAcreditada() {
        return acreditada;
    }

    public void setAcreditada(Boolean acreditada) {
        this.acreditada = acreditada;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + grado + "," + acreditada;
    }

    public String toStringUI() {
        return "Carrera: " + " Código: " + codigo + ", Nombre: " + nombre + ", Grado: " + grado + ", Acreditada: " + acreditada;
    }
}
