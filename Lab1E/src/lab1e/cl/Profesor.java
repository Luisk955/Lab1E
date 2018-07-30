package lab1e.cl;

public class Profesor extends Persona {

    private String lugarTrabajo;
    private int annosExp;

    public Profesor() {
        super();
    }

    public Profesor(String lugarTrabajo, int annosExp, String cedula, String nombre,
            String apellido, String direccion, String telefono) {
        super(cedula, nombre, apellido, direccion, telefono);
        this.lugarTrabajo = lugarTrabajo;
        this.annosExp = annosExp;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public int getAnnosExp() {
        return annosExp;
    }

    public void setAnnosExp(int annosExp) {
        this.annosExp = annosExp;
    }

    @Override
    public String toString() {
        return super.toString() + "," + lugarTrabajo + "," + annosExp;
    }

    @Override
    public String toStringUI() {
        return "Profesor: " + super.toStringUI() + ", Lugar de trabajo: " + lugarTrabajo + ", Años de experiencia: " + annosExp;
    }
}
