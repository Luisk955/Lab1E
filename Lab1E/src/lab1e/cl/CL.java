package lab1e.cl;

import java.io.*;
import java.util.ArrayList;

public class CL {

    ArrayList<Laboratorio> laboratorios = new ArrayList<>();
    ArrayList<Curso> cursos = new ArrayList<>();
    ArrayList<Carrera> carreras = new ArrayList<>();
    ArrayList<ReservaLaboratorio> reservasLaboratorio = new ArrayList<>();

    public CL() {
    }

    public void registrarLaboratorio(Laboratorio miLaboratorio) {
        if (!laboratorios.contains(miLaboratorio)) {
            laboratorios.add(miLaboratorio);
        }
    }

    public void registrarCurso(Curso miCurso) {
        if (!cursos.contains(miCurso)) {
            cursos.add(miCurso);
        }
    }

    public void registrarReservaLaboratorio(ReservaLaboratorio miReservaLaboratorio) {
        if (!reservasLaboratorio.contains(miReservaLaboratorio)) {
            reservasLaboratorio.add(miReservaLaboratorio);
        }
    }

    public ArrayList<Laboratorio> listarLaboratorios() {
        return laboratorios;
    }

    public ArrayList<Curso> listarCursos() {
        return cursos;
    }

    public ArrayList<ReservaLaboratorio> listarReservasLaboratorio() {
        return reservasLaboratorio;
    }

    public void registrarEmpleado(Empleado dato) {
        try {
            FileWriter writer = new FileWriter("empleados.txt", true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(dato.toString());
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarProfesor(Profesor dato) {
        try {
            FileWriter writer = new FileWriter("profesores.txt", true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(dato.toString());
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarCarrera(Carrera dato) {
        try {
            FileWriter writer = new FileWriter("carreras.txt", true);
            BufferedWriter buffer = new BufferedWriter(writer);

            buffer.write(dato.toString());
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> listarEmpleados() throws IOException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            FileReader reader = new FileReader("empleados.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while ((datos = buffer.readLine()) != null) {
                String data[];
                data = datos.split(",");
                Empleado tmpEmpleado;

                tmpEmpleado = new Empleado(data[5], data[0], data[1], data[2], data[3], data[4]);
                listaEmpleados.add(tmpEmpleado);
            }
            reader.close();
            return listaEmpleados;
        } catch (IOException e) {
            throw e;
        }
    }

    public ArrayList<Profesor> listarProfesores() throws IOException {
        ArrayList<Profesor> listaProfesores = new ArrayList<>();
        try {
            FileReader reader = new FileReader("profesores.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while ((datos = buffer.readLine()) != null) {
                String data[];
                data = datos.split(",");
                Profesor tmpProfesor;
                int annosTemp = Integer.parseInt(data[6]);

                tmpProfesor = new Profesor(data[5], annosTemp, data[0], data[1], data[2], data[3], data[4]);
                listaProfesores.add(tmpProfesor);
            }
            reader.close();
            return listaProfesores;
        } catch (IOException e) {
            throw e;
        }
    }

    public ArrayList<Carrera> listarCarreras() throws IOException {
        ArrayList<Carrera> listaCarreras = new ArrayList<>();
        try {
            FileReader reader = new FileReader("carreras.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while ((datos = buffer.readLine()) != null) {
                String data[];
                data = datos.split(",");
                Carrera carreraTemp;
                Boolean boolTemp = Boolean.parseBoolean(data[3]);

                carreraTemp = new Carrera(data[0], data[1], data[2], boolTemp);
                listaCarreras.add(carreraTemp);
            }
            reader.close();
            return listaCarreras;
        } catch (IOException e) {
            throw e;
        }
    }

    public void actualizarEmpleado(Empleado empleadoTemp) throws IOException {
        ArrayList<Empleado> lista = listarEmpleados();
        ArrayList<Empleado> tmpLista = new ArrayList<>();
        for (Empleado obj : lista) {
            if (obj.equals(empleadoTemp)) {
                actualizarArchivo("empleados.txt", obj.toString(), empleadoTemp.toString());
            }
        }
    }

    public void actualizarArchivo(String filePath, String datoViejo, String datoNuevo) throws IOException {
        File fileToBeModified = new File(filePath);
        String info = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                info = info + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newInfo = info.replaceAll(datoViejo, datoNuevo);
            writer = new FileWriter(fileToBeModified);
            writer.write(newInfo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Profesor buscarProfesor(String cedula) throws IOException {
        Profesor miProfesor = new Profesor();
        for (Profesor profesorTemp : listarProfesores()) {
            if (cedula.equals(profesorTemp.getCedula())) {
                miProfesor = profesorTemp;
            }
        }
        return miProfesor;
    }

    public Curso buscarCurso(String codigo) throws IOException {
        Curso miCurso = new Curso();
        for (Curso cursoTemp : listarCursos()) {
            if (codigo.equals(cursoTemp.getCodigo())) {
                miCurso = cursoTemp;
            }
        }
        return miCurso;
    }

    public Laboratorio buscarLaboratorio(int codigo) throws IOException {
        Laboratorio miLaboratorio = new Laboratorio();
        for (Laboratorio laboratorioTemp : listarLaboratorios()) {
            if (codigo == laboratorioTemp.getCodigo()) {
                miLaboratorio = laboratorioTemp;
            }
        }
        return miLaboratorio;
    }
}
