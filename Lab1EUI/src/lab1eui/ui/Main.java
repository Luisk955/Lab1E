package lab1eui.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import lab1eui.gestor.Gestor;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor ctrl = new Gestor();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        int opcion = 0;
        boolean salir = true;

        do {
            mostrarMenu();
            opcion = leerOpcionDelMenu();
            salir = ejecutarAccionDelMenu(opcion);
        } while (salir == false);
    }

    static void mostrarMenu() {
        System.out.println("");
        System.out.println("1. Registrar empleado");
        System.out.println("2. Listar empleados");
        System.out.println("3. Buscar empleado por cedula");
        System.out.println("4. Actualizar empleado");
        System.out.println("5. Borrar empleado");
        System.out.println("6. Registrar profesor");
        System.out.println("7. Listar profesores");
        System.out.println("8. Buscar profesor por cedula");
        System.out.println("9. Actualizar profesor");
        System.out.println("10. Borrar profesor");
        System.out.println("11. Registrar carrera");
        System.out.println("12. Listar carreras");
        System.out.println("13. Buscar carrera por codigo");
        System.out.println("14. Actualizar carrera");
        System.out.println("15. Borrar carrera");
        System.out.println("16. Registrar curso");
        System.out.println("17. Listar Cursos");
        System.out.println("18. Buscar curso por codigo");
        System.out.println("19. Actualizar curso");
        System.out.println("20. Borrar curso");
        System.out.println("21. Registrar laboratorio");
        System.out.println("22. Listar laboratorios");
        System.out.println("23. Actualizar laboratorio");
        System.out.println("24. Buscar laboratorio por codigo");
        System.out.println("25. Borrar laboratorio");
        System.out.println("26. Registrar reserva de laboratorio");
        System.out.println("27. Listar reservas de laboratorio");
        System.out.println("28. Buscar reserva de laboratorio por codigo");
        System.out.println("29. Actualizar reserva de laboratorio");
        System.out.println("30. Borrar reserva de laboratorio");

    }

    static int leerOpcionDelMenu() throws IOException {
        int opcion = 0;
        System.out.println("Ingrese una opcion");
        opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    private static boolean ejecutarAccionDelMenu(int opcion) throws IOException, Exception {
        boolean salir = false;
        switch (opcion) {
            case 1:
                registrarEmpleado();
                break;
            case 2:
                listarEmpleados();
                break;
            case 3:
                buscarEmpleadoPorCedula();
                break;
            case 4:
                actualizarEmpleado();
                break;
            case 5:
                borrarEmpleado();
                break;
            case 6:
                registrarProfesor();
                break;
            case 7:
                listarProfesores();
                break;
            case 8:
                buscarProfesorPorCedula();
                break;
            case 9:
                actualizarProfesor();
                break;
            case 10:
                borrarProfesor();
                break;
            case 11:
                registrarCarrera();
                break;
            case 12:
                listarCarreras();
                break;
            case 13:
                buscarCarreraPorCodigo();
                break;
            case 14:
                actualizarCarrera();
                break;
            case 15:
                borrarCarrera();
                break;
            case 16:
                registrarCurso();
                break;
            case 17:
                listarCursos();
                break;
            case 18:
                buscarCursoPorCodigo();
                break;
            case 19:
                actualizarCurso();
                break;
            case 20:
                borrarCurso();
                break;
            case 21:
                registrarLaboratorio();
                break;
            case 22:
                listarLaboratorios();
                break;
            case 23:
                buscarLaboratorioPorCodigo();
                break;
            case 24:
                actualizarLaboratorio();
                break;
            case 25:
                borrarLaboratorio();
                break;
            case 26:
                registrarReservaLaboratorio();
                break;
            case 27:
                listarReservasLaboratorio();
                break;
            case 28:
                buscarReservaLaboratorioPorCodigo();
                break;
            case 29:
                actualizarReservaLaboratorio();
                break;
            case 30:
                borrarReservaLaboratorio();
                break;
        }
        return salir;
    }

    //Empleado
    public static void registrarEmpleado() throws IOException, Exception {

        System.out.println("Registro de empleado");
        System.out.println("------------------------");

        String puestoEmpleado;
        String cedulaEmpleado;
        String nombreEmpleado;
        String apellidoEmpleado;
        String direccionEmpleado;
        String telefonoEmpleado;

        System.out.println("Ingrese el puesto del empleado");
        puestoEmpleado = in.readLine();

        System.out.println("Ingrese la cédula del empleado");
        cedulaEmpleado = in.readLine();

        System.out.println("Ingrese el nombre del empleado");
        nombreEmpleado = in.readLine();

        System.out.println("Ingrese el primer apellido del empleado");
        apellidoEmpleado = in.readLine();

        System.out.println("Ingrese la dirección el empleado");
        direccionEmpleado = in.readLine();

        System.out.println("Ingrese el número telefónico del empleado");
        telefonoEmpleado = in.readLine();

        ctrl.registrarEmpleado(puestoEmpleado, cedulaEmpleado, nombreEmpleado, apellidoEmpleado, direccionEmpleado, telefonoEmpleado);
    }

    public static void actualizarEmpleado() throws IOException, Exception {

        System.out.println("Actualizar empleado");
        System.out.println("------------------------");

        String puestoEmpleado;
        String cedulaEmpleado;
        String nombreEmpleado;
        String apellidoEmpleado;
        String direccionEmpleado;
        String telefonoEmpleado;

        System.out.println("Ingrese el puesto del empleado");
        puestoEmpleado = in.readLine();

        System.out.println("Ingrese la cédula del empleado");
        cedulaEmpleado = in.readLine();

        System.out.println("Ingrese el nombre del empleado");
        nombreEmpleado = in.readLine();

        System.out.println("Ingrese el primer apellido del empleado");
        apellidoEmpleado = in.readLine();

        System.out.println("Ingrese la dirección el empleado");
        direccionEmpleado = in.readLine();

        System.out.println("Ingrese el número telefónico del empleado");
        telefonoEmpleado = in.readLine();

        ctrl.actualizarEmpleado(puestoEmpleado, cedulaEmpleado, nombreEmpleado, apellidoEmpleado, direccionEmpleado, telefonoEmpleado);
    }

    public static void borrarEmpleado() throws IOException, Exception {
        System.out.println("Borrar empleado");
        String cedulaEmpleado;

        System.out.println("Ingrese la cedula del empleado");
        cedulaEmpleado = in.readLine();

        ctrl.borrarEmpleado(cedulaEmpleado);
    }

    public static void buscarEmpleadoPorCedula() throws IOException, Exception {
        System.out.println("Busqueda de empleado");
        String cedulaEmpleado;

        System.out.println("Ingrese la cedula del empleado");
        cedulaEmpleado = in.readLine();

        System.out.println(ctrl.buscarEmpleadoPorCedula(cedulaEmpleado));
    }

    public static void listarEmpleados() throws IOException, Exception {
        System.out.println("Lista de Empleados");
        for (String data : ctrl.listarEmpleados()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(data);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    //Empleado

    //Profesor
    public static void registrarProfesor() throws IOException, Exception {

        System.out.println("Registro de profesor");
        System.out.println("------------------------");

        String lugarTrabajoProfesor;
        int annosExpProfesor;
        String cedulaProfesor;
        String nombreProfesor;
        String apellidoProfesor;
        String direccionProfesor;
        String telefonoProfesor;

        System.out.println("Ingrese el lugar de trabajo del profesor");
        lugarTrabajoProfesor = in.readLine();

        System.out.println("Ingrese los años de experiencia del profesor");
        annosExpProfesor = Integer.parseInt(in.readLine());

        System.out.println("Ingrese la cédula del profesor");
        cedulaProfesor = in.readLine();

        System.out.println("Ingrese el nombre del profesor");
        nombreProfesor = in.readLine();

        System.out.println("Ingrese el primer apellido del profesor");
        apellidoProfesor = in.readLine();

        System.out.println("Ingrese la dirección del profesor");
        direccionProfesor = in.readLine();

        System.out.println("Ingrese el número telefónico del profesor");
        telefonoProfesor = in.readLine();

        ctrl.registrarProfesor(lugarTrabajoProfesor, annosExpProfesor, cedulaProfesor, nombreProfesor, apellidoProfesor, direccionProfesor, telefonoProfesor);

    }

    public static void actualizarProfesor() throws IOException, Exception {

        System.out.println("Registro de profesor");
        System.out.println("------------------------");

        String lugarTrabajoProfesor;
        int annosExpProfesor;
        String cedulaProfesor;
        String nombreProfesor;
        String apellidoProfesor;
        String direccionProfesor;
        String telefonoProfesor;

        System.out.println("Ingrese el lugar de trabajo del profesor");
        lugarTrabajoProfesor = in.readLine();

        System.out.println("Ingrese los años de experiencia del profesor");
        annosExpProfesor = Integer.parseInt(in.readLine());

        System.out.println("Ingrese la cédula del profesor");
        cedulaProfesor = in.readLine();

        System.out.println("Ingrese el nombre del profesor");
        nombreProfesor = in.readLine();

        System.out.println("Ingrese el primer apellido del profesor");
        apellidoProfesor = in.readLine();

        System.out.println("Ingrese la dirección del profesor");
        direccionProfesor = in.readLine();

        System.out.println("Ingrese el número telefónico del profesor");
        telefonoProfesor = in.readLine();

        ctrl.actualizarProfesor(lugarTrabajoProfesor, annosExpProfesor, cedulaProfesor, nombreProfesor, apellidoProfesor, direccionProfesor, telefonoProfesor);

    }

    public static void borrarProfesor() throws IOException, Exception {
        System.out.println("Borrar profesor");
        String cedulaProfesor;

        System.out.println("Ingrese la cedula del profesor");
        cedulaProfesor = in.readLine();

        ctrl.borrarProfesor(cedulaProfesor);
    }

    public static void buscarProfesorPorCedula() throws IOException, Exception {
        System.out.println("Busqueda de carrera");
        String cedulaProfesor;

        System.out.println("Ingrese la cedula del profesor");
        cedulaProfesor = in.readLine();

        System.out.println(ctrl.buscarProfesorPorCedula(cedulaProfesor));
    }

    public static void listarProfesores() throws IOException, Exception {
        System.out.println("Lista de Profesores");
        for (String data : ctrl.listarProfesores()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(data);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    //Profesor

    //Carrera
    public static void registrarCarrera() throws IOException, Exception {

        System.out.println("Registro de carrera");
        System.out.println("------------------------");

        String codigoCarrera;
        String nombreCarrera;
        String gradoCarrera;
        Boolean acreditadaCarrera;

        System.out.println("Ingrese el código de la carrera");
        codigoCarrera = in.readLine();

        System.out.println("Ingrese el nombre de la carrera");
        nombreCarrera = in.readLine();

        System.out.println("Ingrese el grado de la carrera: Técnico, Diplomado, Bachillerato, Licenciatura y Maestría");
        gradoCarrera = in.readLine();

        System.out.println("Ingrese 'y' si carrera está acreditada o 'n' si no lo está.");
        if ("y" == in.readLine()) {
            acreditadaCarrera = true;
        } else {
            acreditadaCarrera = false;
        }

        ctrl.registrarCarrera(codigoCarrera, nombreCarrera, gradoCarrera, acreditadaCarrera);
    }

    public static void actualizarCarrera() throws IOException, Exception {

        System.out.println("Actualizar carrera");
        System.out.println("------------------------");

        String codigoCarrera;
        String nombreCarrera;
        String gradoCarrera;
        Boolean acreditadaCarrera;

        System.out.println("Ingrese el código de la carrera");
        codigoCarrera = in.readLine();

        System.out.println("Ingrese el nombre de la carrera");
        nombreCarrera = in.readLine();

        System.out.println("Ingrese el grado de la carrera: Técnico, Diplomado, Bachillerato, Licenciatura y Maestría");
        gradoCarrera = in.readLine();

        System.out.println("Ingrese 'y' si carrera está acreditada o 'n' si no lo está.");
        if ("y" == in.readLine()) {
            acreditadaCarrera = true;
        } else {
            acreditadaCarrera = false;
        }

        ctrl.actualizarCarrera(codigoCarrera, nombreCarrera, gradoCarrera, acreditadaCarrera);
    }

    public static void borrarCarrera() throws IOException, Exception {
        System.out.println("Borrar carrera");
        String codigoCarrera;

        System.out.println("Ingrese el código de la carrera");
        codigoCarrera = in.readLine();

        ctrl.borrarCarrera(codigoCarrera);
    }

    public static void buscarCarreraPorCodigo() throws IOException, Exception {
        System.out.println("Busqueda de carrera");
        String codigoCarrera;

        System.out.println("Ingrese el código de la carrera");
        codigoCarrera = in.readLine();

        System.out.println(ctrl.buscarCarreraPorCodigo(codigoCarrera));
    }

    public static void listarCarreras() throws IOException, Exception {
        System.out.println("Lista de Carreras");
        for (String data : ctrl.listarCarreras()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(data);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    //Carrera

    //Curso
    public static void registrarCurso() throws IOException, Exception {

        System.out.println("Registro de curso");
        System.out.println("------------------------");

        String codigoCurso;
        String nombreCurso;
        int creditosCurso;

        System.out.println("Ingrese el código del curso");
        codigoCurso = in.readLine();

        System.out.println("Ingrese el nombre del curso");
        nombreCurso = in.readLine();

        System.out.println("Ingrese la cantidad de créditos del curso");
        creditosCurso = Integer.parseInt(in.readLine());

        ctrl.registrarCurso(codigoCurso, nombreCurso, creditosCurso);
    }

    public static void actualizarCurso() throws IOException, Exception {

        System.out.println("Actualizar curso");
        System.out.println("------------------------");

        String codigoCurso;
        String nombreCurso;
        int creditosCurso;

        System.out.println("Ingrese el código del curso");
        codigoCurso = in.readLine();

        System.out.println("Ingrese el nombre del curso");
        nombreCurso = in.readLine();

        System.out.println("Ingrese la cantidad de créditos del curso");
        creditosCurso = Integer.parseInt(in.readLine());

        ctrl.actualizarCurso(codigoCurso, nombreCurso, creditosCurso);
    }

    public static void borrarCurso() throws IOException, Exception {
        System.out.println("Borrar curso");
        String codigoCurso;

        System.out.println("Ingrese el código del curso");
        codigoCurso = in.readLine();

        ctrl.borrarCurso(codigoCurso);
    }

    public static void buscarCursoPorCodigo() throws IOException, Exception {
        System.out.println("Busqueda de curso");
        String codigoCurso;

        System.out.println("Ingrese el código del curso");
        codigoCurso = in.readLine();

        System.out.println(ctrl.buscarCursoPorCodigo(codigoCurso));
    }

    public static void listarCursos() throws Exception {
        System.out.println("Lista de Cursos");
        for (String data : ctrl.listarCursos()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(data);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    //Curso

    //Laboratorio
    public static void registrarLaboratorio() throws IOException, Exception {

        System.out.println("Registro de laboratorio");
        System.out.println("------------------------");

        int codigoLaboratorio;
        String nombreLaboratorio;
        int capacidadLaboratorio;

        System.out.println("Ingrese el código del laboratorio");
        codigoLaboratorio = Integer.parseInt(in.readLine());

        System.out.println("Ingrese el nombre del laboratorio");
        nombreLaboratorio = in.readLine();

        System.out.println("Ingrese la capacidad del laboratorio");
        capacidadLaboratorio = Integer.parseInt(in.readLine());

        ctrl.registrarLaboratorio(codigoLaboratorio, nombreLaboratorio, capacidadLaboratorio);
    }

    public static void actualizarLaboratorio() throws IOException, Exception {

        System.out.println("Actualizar laboratorio");
        System.out.println("------------------------");

        int codigoLaboratorio;
        String nombreLaboratorio;
        int capacidadLaboratorio;

        System.out.println("Ingrese el código del laboratorio");
        codigoLaboratorio = Integer.parseInt(in.readLine());

        System.out.println("Ingrese el nombre del laboratorio");
        nombreLaboratorio = in.readLine();

        System.out.println("Ingrese la capacidad del laboratorio");
        capacidadLaboratorio = Integer.parseInt(in.readLine());

        ctrl.actualizarLaboratorio(codigoLaboratorio, nombreLaboratorio, capacidadLaboratorio);
    }

    public static void borrarLaboratorio() throws IOException, Exception {
        System.out.println("Borrar laboratorio");
        int codigoLaboratorio;

        System.out.println("Ingrese el código del laboratorio");
        codigoLaboratorio = Integer.parseInt(in.readLine());

        ctrl.borrarLaboratorio(codigoLaboratorio);
    }

    public static void buscarLaboratorioPorCodigo() throws IOException, Exception {
        System.out.println("Busqueda de laboratorio");
        int codigoLaboratorio;

        System.out.println("Ingrese el código del laboratorio");
        codigoLaboratorio = Integer.parseInt(in.readLine());

        System.out.println(ctrl.buscarLaboratorioPorCodigo(codigoLaboratorio));
    }

    public static void listarLaboratorios() throws Exception {
        System.out.println("Lista de Laboratorios");
        for (String data : ctrl.listarLaboratorios()) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(data);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    //Laboratorio

    //ReservaLaboratorio
    public static void registrarReservaLaboratorio() throws IOException, Exception {

        int codigoUniqLaboratorioReserva;
        int codigoLaboratorioReserva;
        String codigoCursoReserva;
        String cedulaProfesorReserva;
        int cantEstudiantesReserva;
        LocalDate fechaReserva;

        System.out.println("Ingrese el código de la reserva");
        codigoUniqLaboratorioReserva = Integer.parseInt(in.readLine());

        listarLaboratorios();
        System.out.println("Ingrese el código del laboratorio que desea reservar");
        codigoLaboratorioReserva = Integer.parseInt(in.readLine());

        listarCursos();
        System.out.println("Ingrese el código del curso para la reserva");
        codigoCursoReserva = in.readLine();

        listarProfesores();
        System.out.println("Ingrese la cédula del profesor responsable de la reserva");
        cedulaProfesorReserva = in.readLine();

        System.out.println("Ingrese la cantidad de estudiantes");
        cantEstudiantesReserva = Integer.parseInt(in.readLine());

        System.out.println("Ingrese la fecha de la reserva");
        fechaReserva = crearFecha();

        ctrl.registrarReservaLaboratorio(codigoUniqLaboratorioReserva, codigoLaboratorioReserva, codigoCursoReserva, cedulaProfesorReserva, cantEstudiantesReserva, fechaReserva);
    }

    public static void actualizarReservaLaboratorio() throws IOException, Exception {

        int codigoUniqLaboratorioReserva;
        int codigoLaboratorioReserva;
        String codigoCursoReserva;
        String cedulaProfesorReserva;
        int cantEstudiantesReserva;
        LocalDate fechaReserva;

        System.out.println("Ingrese el código de la reserva");
        codigoUniqLaboratorioReserva = Integer.parseInt(in.readLine());

        listarLaboratorios();
        System.out.println("Ingrese el código del laboratorio que desea reservar");
        codigoLaboratorioReserva = Integer.parseInt(in.readLine());

        listarCursos();
        System.out.println("Ingrese el código del curso para la reserva");
        codigoCursoReserva = in.readLine();

        listarProfesores();
        System.out.println("Ingrese la cédula del profesor responsable de la reserva");
        cedulaProfesorReserva = in.readLine();

        System.out.println("Ingrese la cantidad de estudiantes");
        cantEstudiantesReserva = Integer.parseInt(in.readLine());

        System.out.println("Ingrese la fecha de la reserva");
        fechaReserva = crearFecha();

        ctrl.actualizarReservaLaboratorio(codigoUniqLaboratorioReserva, codigoLaboratorioReserva, codigoCursoReserva, cedulaProfesorReserva, cantEstudiantesReserva, fechaReserva);
    }

    public static void listarReservasLaboratorio() throws IOException, Exception {
        System.out.println("Lista de Reservas de laboratorio");
        for (String data : ctrl.listarReservasLaboratorio()) {
            System.out.println("---------------------------------------------------");
            System.out.println(data);
        }
    }

    public static void borrarReservaLaboratorio() throws IOException, Exception {
        System.out.println("Borrar reserva de laboratorio");
        int codigoReservaLaboratorio;

        System.out.println("Ingrese el código de la reserva de laboratorio");
        codigoReservaLaboratorio = Integer.parseInt(in.readLine());

        ctrl.borrarReservaLaboratorio(codigoReservaLaboratorio);
    }

    public static void buscarReservaLaboratorioPorCodigo() throws IOException, Exception {
        System.out.println("Busqueda de reserva de laboratorio");
        int codigoReservaLaboratorio;

        System.out.println("Ingrese el código de la reserva de laboratorio");
        codigoReservaLaboratorio = Integer.parseInt(in.readLine());

        System.out.println(ctrl.buscarReservaLaboratorioPorCodigo(codigoReservaLaboratorio));
    }
    //ReservaLaboratorio

    public static LocalDate crearFecha() throws IOException {
        LocalDate fecha;
        int mes;
        int year;
        int dia;
        out.println("Digite el dia");
        dia = Integer.parseInt(in.readLine());

        out.println("Digite el mes");
        mes = Integer.parseInt(in.readLine());

        out.println("Digite el año");
        year = Integer.parseInt(in.readLine());

        fecha = LocalDate.of(year, mes, dia);

        return fecha;
    }
}
