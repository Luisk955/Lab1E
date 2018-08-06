package lab1e.cl;

import accesobd.Conector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MultiCurso {

    public ArrayList<Curso> listarCursos() throws SQLException, Exception {
        ArrayList<Curso> cursos = new ArrayList<>();
        Curso curso = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarCursos()}", true);
        while (rs.next()) {
            curso = new Curso(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("creditos"));
            cursos.add(curso);
        }
        rs.close();
        return cursos;
    }

    public void registrarCurso(Curso curso) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(Integer.parseInt(curso.getCodigo()));
        data.add(curso.getNombre());
        data.add(curso.getCreditos());
        (new Conector()).getConector().ejecutarSQL(data, "{call insertCurso(?,?,?)}");
    }

    public Curso buscarCursoPorCodigo(String codigo) throws java.sql.SQLException, Exception {
        Curso curso = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(Integer.parseInt(codigo), "{call searchCurso(?)}", true);
        if (rs.next()) {
            curso = new Curso(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("creditos"));
        }
        rs.close();
        return curso;
    }

    public void actualizarCurso(Curso curso) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(Integer.parseInt(curso.getCodigo()));
            data.add(curso.getNombre());
            data.add(curso.getCreditos());
            (new Conector()).getConector().ejecutarSQL(data, "{call updateCurso(?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarCurso(String codigo) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(Integer.parseInt(codigo), "{call deleteCurso(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
