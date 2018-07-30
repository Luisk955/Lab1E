package lab1eui.gestor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import lab1e.cl.*;

public class Gestor {

    public Gestor() {
    }

    //Empleado
    public void registrarEmpleado(String puestoEmpleado, String cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String direccionEmpleado, String telefonoEmpleado) throws Exception {
        Empleado miEmpleado = new Empleado(puestoEmpleado, cedulaEmpleado, nombreEmpleado, apellidoEmpleado, direccionEmpleado, telefonoEmpleado);
        new MultiEmpleado().registrarEmpleado(miEmpleado);
    }

    public void actualizarEmpleado(String puestoEmpleado, String cedulaEmpleado, String nombreEmpleado, String apellidoEmpleado, String direccionEmpleado, String telefonoEmpleado) throws Exception {
        Empleado empleado = new Empleado(puestoEmpleado, cedulaEmpleado, nombreEmpleado, apellidoEmpleado, direccionEmpleado, telefonoEmpleado);
        new MultiEmpleado().actualizarEmpleado(empleado);
    }

    public void borrarEmpleado(String cedula) throws Exception {
        new MultiEmpleado().borrarEmpleado(cedula);
    }

    public String buscarEmpleadoPorCedula(String cedula) throws Exception {
        Empleado empleado = new MultiEmpleado().buscarEmpleadoPorCedula(cedula);
        String resp = empleado.toStringUI();
        return resp;
    }

    public ArrayList<String> listarEmpleados() throws Exception {
        ArrayList<String> empleadosString = new ArrayList<>();
        for (Empleado empleado : (new MultiEmpleado()).listarEmpleados()) {
            empleadosString.add(empleado.toStringUI());
        }
        return empleadosString;
    }
    //Empleado

    //Profesor
    public void registrarProfesor(String lugarTrabajoProfesor, int annosExperienciaProfesor, String cedulaProfesor, String nombreProfesor, String apellidoProfesor, String direccionProfesor, String telefonoProfesor) throws Exception {
        Profesor miProfesor = new Profesor(lugarTrabajoProfesor, annosExperienciaProfesor, cedulaProfesor, nombreProfesor, apellidoProfesor, direccionProfesor, telefonoProfesor);
        new MultiProfesor().registrarProfesor(miProfesor);
    }

    public void actualizarProfesor(String lugarTrabajoProfesor, int annosExperienciaProfesor, String cedulaProfesor, String nombreProfesor, String apellidoProfesor, String direccionProfesor, String telefonoProfesor) throws Exception {
        Profesor profesor = new Profesor(lugarTrabajoProfesor, annosExperienciaProfesor, cedulaProfesor, nombreProfesor, apellidoProfesor, direccionProfesor, telefonoProfesor);
        new MultiProfesor().actualizarProfesor(profesor);
    }

    public void borrarProfesor(String cedula) throws Exception {
        new MultiProfesor().borrarProfesor(cedula);
    }

    public String buscarProfesorPorCedula(String cedula) throws Exception {
        Profesor profesor = new MultiProfesor().buscarProfesorPorCedula(cedula);
        String resp = profesor.toStringUI();
        return resp;
    }

    public ArrayList<String> listarProfesores() throws Exception {
        ArrayList<String> profesoresString = new ArrayList<>();
        for (Profesor profesor : (new MultiProfesor()).listarProfesores()) {
            profesoresString.add(profesor.toStringUI());
        }
        return profesoresString;
    }
    //Profesor

    //Laboratorio
    public void registrarLaboratorio(int codigoLaboratorio, String nombreLaboratorio, int capacidadLaboratorio) throws Exception {
        Laboratorio miLaboratorio = new Laboratorio(codigoLaboratorio, nombreLaboratorio, capacidadLaboratorio);
        new MultiLaboratorio().registrarLaboratorio(miLaboratorio);
    }

    public void actualizarLaboratorio(int codigoLaboratorio, String nombreLaboratorio, int capacidadLaboratorio) throws Exception {
        Laboratorio miLaboratorio = new Laboratorio(codigoLaboratorio, nombreLaboratorio, capacidadLaboratorio);
        new MultiLaboratorio().actualizarLaboratorio(miLaboratorio);
    }

    public void borrarLaboratorio(int codigo) throws Exception {
        new MultiLaboratorio().borrarLaboratorio(codigo);
    }

    public String buscarLaboratorioPorCodigo(int codigo) throws Exception {
        Laboratorio miLaboratorio = new MultiLaboratorio().buscarLaboratorioPorCodigo(codigo);
        String resp = miLaboratorio.toStringUI();
        return resp;
    }

    public ArrayList<String> listarLaboratorios() throws Exception {
        ArrayList<String> laboratoriosString = new ArrayList<>();
        for (Laboratorio miLaboratorio : (new MultiLaboratorio()).listarLaboratorios()) {
            laboratoriosString.add(miLaboratorio.toStringUI());
        }
        return laboratoriosString;
    }
    //Laboratorio

    //Curso
    public void registrarCurso(String codigoCurso, String nombreCurso, int creditosCurso) throws Exception {
        Curso miCurso = new Curso(codigoCurso, nombreCurso, creditosCurso);
        new MultiCurso().registrarCurso(miCurso);
    }

    public void actualizarCurso(String codigoCurso, String nombreCurso, int creditosCurso) throws Exception {
        Curso curso = new Curso(codigoCurso, nombreCurso, creditosCurso);
        new MultiCurso().actualizarCurso(curso);
    }

    public void borrarCurso(String codigo) throws Exception {
        new MultiCurso().borrarCurso(codigo);
    }

    public String buscarCursoPorCodigo(String codigo) throws Exception {
        Curso curso = new MultiCurso().buscarCursoPorCodigo(codigo);
        String resp = curso.toStringUI();
        return resp;
    }

    public ArrayList<String> listarCursos() throws Exception {
        ArrayList<String> cursosString = new ArrayList<>();
        for (Curso curso : (new MultiCurso()).listarCursos()) {
            cursosString.add(curso.toStringUI());
        }
        return cursosString;
    }
    //Curso

    //Carrera
    public void registrarCarrera(String codigo, String nombre, String grado, Boolean acreditada) throws Exception {
        Carrera carrera;
        carrera = (new MultiCarrera()).registrarCarrera(codigo, nombre, grado, acreditada);
    }

    public void actualizarCarrera(String codigo, String nombre, String grado, Boolean acreditada) throws Exception {
        Carrera carrera = new Carrera(codigo, nombre, grado, acreditada);
        new MultiCarrera().actualizarCarrera(carrera);
    }

    public void borrarCarrera(String codigo) throws Exception {
        new MultiCarrera().borrarCarrera(codigo);
    }

    public String buscarCarreraPorCodigo(String codigo) throws Exception {
        Carrera carrera = new MultiCarrera().buscarCarreraPorCodigo(codigo);
        String resp = carrera.toStringUI();
        return resp;
    }

    public ArrayList<String> listarCarreras() throws Exception {
        ArrayList<String> carrerasString = new ArrayList<>();
        for (Carrera carrera : (new MultiCarrera()).listarCarreras()) {
            carrerasString.add(carrera.toStringUI());
        }
        return carrerasString;
    }
    //Carrera

    //ReservaLaboratorio
    public void registrarReservaLaboratorio(int codigoUniqLaboratorioReserva, int codigoLaboratorioReserva, String codigoCursoReserva, String cedulaProfesorReserva, int cantEstudiantesReserva, LocalDate fechaReserva) throws IOException, Exception {
        ReservaLaboratorio miReservaLaboratorio = new ReservaLaboratorio(codigoUniqLaboratorioReserva, (new MultiLaboratorio().buscarLaboratorioPorCodigo(codigoLaboratorioReserva)), (new MultiCurso().buscarCursoPorCodigo(codigoCursoReserva)), (new MultiProfesor().buscarProfesorPorCedula(cedulaProfesorReserva)), cantEstudiantesReserva, fechaReserva);
        new MultiReservaLaboratorio().registrarReservaLaboratorio(miReservaLaboratorio);
    }

    public ArrayList<String> listarReservasLaboratorio() throws Exception {
        ArrayList<String> reservasLaboratorioString = new ArrayList<>();
        for (ReservaLaboratorio reservaLaboratorio : (new MultiReservaLaboratorio()).listarReservasLaboratorio()) {
            reservasLaboratorioString.add(reservaLaboratorio.toStringUI());
        }
        return reservasLaboratorioString;
    }

    public void actualizarReservaLaboratorio(int codigoUniqLaboratorioReserva, int codigoLaboratorioReserva, String codigoCursoReserva, String cedulaProfesorReserva, int cantEstudiantesReserva, LocalDate fechaReserva) throws IOException, Exception {
        ReservaLaboratorio miReservaLaboratorio = new ReservaLaboratorio(codigoUniqLaboratorioReserva, (new MultiLaboratorio().buscarLaboratorioPorCodigo(codigoLaboratorioReserva)), (new MultiCurso().buscarCursoPorCodigo(codigoCursoReserva)), (new MultiProfesor().buscarProfesorPorCedula(cedulaProfesorReserva)), cantEstudiantesReserva, fechaReserva);
        new MultiReservaLaboratorio().actualizarReservaLaboratorio(miReservaLaboratorio);
    }

    public void borrarReservaLaboratorio(int codigo) throws Exception {
        new MultiReservaLaboratorio().borrarReservaLaboratorio(codigo);
    }

    public String buscarReservaLaboratorioPorCodigo(int codigo) throws Exception {
        ReservaLaboratorio reservaLaboratorio = new MultiReservaLaboratorio().buscarReservaLaboratorioPorCodigo(codigo);
        String resp = reservaLaboratorio.toStringUI();
        return resp;
    }
    //ReservaLaboratorio
}
