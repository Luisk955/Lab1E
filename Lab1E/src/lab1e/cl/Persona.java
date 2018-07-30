package lab1e.cl;

public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellido, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return cedula + "," + nombre + "," + apellido + "," + direccion + "," + telefono;
    }

    public String toStringUI() {
        return "Cédula: " + cedula + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Dirección: " + direccion + ", Teléfono: " + telefono;
    }
}
