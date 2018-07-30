package lab1e.cl;

public class Empleado extends Persona {

    private String puesto;

    public Empleado() {
        super();
    }

    public Empleado(String puesto, String cedula, String nombre, String apellido, String direccion, String telefono) {
        super(cedula, nombre, apellido, direccion, telefono);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return super.toString() + "," + puesto;
    }

    @Override
    public String toStringUI() {
        return "Empleado: " + super.toStringUI() + ", Puesto: " + puesto;
    }
}
