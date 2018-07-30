package lab1e.cl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lab1e.accesobd.Accesobd;

public class MultiCurso {

    public ArrayList<Curso> listarCursos() throws SQLException, Exception {
        ArrayList<Curso> cursos = new ArrayList<>();
        Curso curso = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT codigo, nombre, creditos "
                + "FROM Curso ;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            curso = new Curso(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("creditos"));
            cursos.add(curso);
        }
        rs.close();
        return cursos;
    }

    public void registrarCurso(Curso curso) throws Exception {
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int codigoint = Integer.parseInt(curso.getCodigo());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call insertCurso(?,?,?)}");
            cs.setInt(1, codigoint);
            cs.setString(2, curso.getNombre());
            cs.setInt(3, curso.getCreditos());
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Curso buscarCursoPorCodigo(String codigo) throws java.sql.SQLException, Exception {
        Curso curso = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        int codigoint = Integer.parseInt(codigo);
        sql = "SELECT codigo, nombre, creditos "
                + "FROM Curso " + "WHERE codigo LIKE concat(" + codigoint + ",'%')" + ";";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            curso = new Curso(rs.getString("codigo"), rs.getString("nombre"), rs.getInt("creditos"));
        }
        rs.close();
        return curso;
    }

    public void actualizarCurso(Curso curso) throws java.sql.SQLException, Exception {
        String sql;
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int codigoint = Integer.parseInt(curso.getCodigo());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call updateCurso(?,?,?)}");
            cs.setInt(1, codigoint);
            cs.setString(2, curso.getNombre());
            cs.setInt(3, curso.getCreditos());
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarCurso(String codigo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int codigoint = Integer.parseInt(codigo);

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call deleteCurso(?)}");
            cs.setInt(1, codigoint);
            cs.executeUpdate();

        } catch (Exception e) {
            throw new Exception("El curso no se encuentra registrado.");
        }
    }
}
