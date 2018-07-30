package lab1e.cl;

import java.time.LocalDate;

public class ReservaLaboratorio {

    private int codigo;
    private Laboratorio laboratorio;
    private Curso curso;
    private Profesor profesor;
    private int cantEstudiantes;
    private LocalDate fechaReserva;

    public ReservaLaboratorio() {
    }

    public ReservaLaboratorio(int codigo, Laboratorio laboratorio, Curso curso, Profesor profesor, int cantEstudiantes, LocalDate fechaReserva) {
        this.codigo = codigo;
        this.laboratorio = laboratorio;
        this.curso = curso;
        this.profesor = profesor;
        this.cantEstudiantes = cantEstudiantes;
        this.fechaReserva = fechaReserva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    @Override
    public String toString() {
        return codigo + "," + laboratorio.getCodigo() + "," + curso.getCodigo() + "," + profesor.getCedula() + "," + cantEstudiantes + "," + fechaReserva;
    }

    public String toStringUI() {
        return "Reserva de Laboratorio: Código: " + codigo + ", Laboratorio: " + laboratorio.getCodigo() + ", Curso: " + curso.getCodigo() + ", Profesor: " + profesor.getCedula() + ", Cantidad de estudiantes: " + cantEstudiantes + ", Fecha de reserva: " + fechaReserva;
    }
}
