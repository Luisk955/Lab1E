package lab1e.cl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import lab1e.accesobd.Accesobd;

public class MultiReservaLaboratorio {
//int codigo, Laboratorio laboratorio, Curso curso, Profesor profesor, int cantEstudiantes, LocalDate fechaReserva

    public ArrayList<ReservaLaboratorio> listarReservasLaboratorio() throws SQLException, Exception {
        ArrayList<ReservaLaboratorio> reservasLaboratorio = new ArrayList<>();
        ReservaLaboratorio reservaLaboratorio = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT  codigo, laboratorio, curso, profesor, cantEstudiantes, fechaReserva "
                + "FROM ReservaLaboratorio ;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            LocalDate fecha;
            reservaLaboratorio = new ReservaLaboratorio(rs.getInt("codigo"),
                    (new MultiLaboratorio().buscarLaboratorioPorCodigo(rs.getInt("laboratorio"))),
                    (new MultiCurso().buscarCursoPorCodigo(rs.getString("curso"))),
                    (new MultiProfesor().buscarProfesorPorCedula(rs.getString("profesor"))), rs.getInt("cantidadestudiantes"),
                    (rs.getDate("fechareserva").toLocalDate()));
            reservasLaboratorio.add(reservaLaboratorio);
        }
        rs.close();
        return reservasLaboratorio;
    }

    public void registrarReservaLaboratorio(ReservaLaboratorio reservaLaboratorio) throws Exception {
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
//int codigo, Laboratorio laboratorio, Curso curso, Profesor profesor, int cantEstudiantes, LocalDate fechaReserva

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call insertReservaLaboratorio(?,?,?,?,?,?)}");
            cs.setInt(1, reservaLaboratorio.getCodigo());
            cs.setInt(2, reservaLaboratorio.getCodigoLaboratorio());
            cs.setInt(3, Integer.parseInt(reservaLaboratorio.getCodigoCurso()));
            cs.setInt(4, Integer.parseInt(reservaLaboratorio.getCedulaProfesor()));
            cs.setInt(5, reservaLaboratorio.getCantEstudiantes());
            cs.setDate(6, java.sql.Date.valueOf(reservaLaboratorio.getFechaReserva()));

            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public ReservaLaboratorio buscarReservaLaboratorioPorCodigo(int codigo) throws java.sql.SQLException, Exception {
        ReservaLaboratorio reservaLaboratorio = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT codigo, laboratorio, curso, profesor, cantEstudiantes, fechaReserva "
                + "FROM ReservaLaboratorio " + "WHERE codigo LIKE concat(" + codigo + ",'%')" + ";";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            reservaLaboratorio = new ReservaLaboratorio(rs.getInt("codigo"),
                    (new MultiLaboratorio().buscarLaboratorioPorCodigo(rs.getInt("laboratorio"))),
                    (new MultiCurso().buscarCursoPorCodigo(rs.getString("curso"))),
                    (new MultiProfesor().buscarProfesorPorCedula(rs.getString("profesor"))), rs.getInt("cantidadestudiantes"),
                    (rs.getDate("fechareserva").toLocalDate()));
        }
        rs.close();
        return reservaLaboratorio;
    }

    public void actualizarReservaLaboratorio(ReservaLaboratorio reservaLaboratorio) throws java.sql.SQLException, Exception {
        String sql;
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call updateReservaLaboratorio(?,?,?,?,?,?)}");
            cs.setInt(1, reservaLaboratorio.getCodigo());
            cs.setInt(2, reservaLaboratorio.getCodigoLaboratorio());
            cs.setInt(3, Integer.parseInt(reservaLaboratorio.getCodigoCurso()));
            cs.setInt(4, Integer.parseInt(reservaLaboratorio.getCedulaProfesor()));
            cs.setInt(5, reservaLaboratorio.getCantEstudiantes());
            cs.setDate(6, java.sql.Date.valueOf(reservaLaboratorio.getFechaReserva()));

            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarReservaLaboratorio(int codigo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call deleteReservaLaboratorio(?)}");
            cs.setInt(1, codigo);
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }
}
