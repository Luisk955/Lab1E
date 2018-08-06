package lab1e.cl;

import accesobd.Conector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class MultiReservaLaboratorio {

    public ArrayList<ReservaLaboratorio> listarReservasLaboratorio() throws SQLException, Exception {
        ArrayList<ReservaLaboratorio> reservasLaboratorio = new ArrayList<>();
        ReservaLaboratorio reservaLaboratorio = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarReservasLaboratorio()}", true);
        while (rs.next()) {
            LocalDate fecha;
            reservaLaboratorio = new ReservaLaboratorio(rs.getInt("codigo"),
                    (new MultiLaboratorio().buscarLaboratorioPorCodigo(rs.getInt("codigolaboratorio"))),
                    (new MultiCurso().buscarCursoPorCodigo(rs.getString("codigocurso"))),
                    (new MultiProfesor().buscarProfesorPorCedula(rs.getString("codigoprofesor"))), rs.getInt("cantidadestudiantes"),
                    (rs.getDate("fechareserva").toLocalDate()));
            reservasLaboratorio.add(reservaLaboratorio);
        }
        rs.close();
        return reservasLaboratorio;
    }

    public void registrarReservaLaboratorio(ReservaLaboratorio reservaLaboratorio) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(reservaLaboratorio.getCodigo());
        data.add(reservaLaboratorio.getCodigoLaboratorio());
        data.add(Integer.parseInt(reservaLaboratorio.getCodigoCurso()));
        data.add(Integer.parseInt(reservaLaboratorio.getCedulaProfesor()));
        data.add(reservaLaboratorio.getCantEstudiantes());
        data.add(java.sql.Date.valueOf(reservaLaboratorio.getFechaReserva()));

        (new Conector()).getConector().ejecutarSQL(data, "{call insertReservaLaboratorio(?,?,?,?,?,?)}");
    }

    public ReservaLaboratorio buscarReservaLaboratorioPorCodigo(int codigo) throws java.sql.SQLException, Exception {
        ReservaLaboratorio reservaLaboratorio = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(codigo, "{call searchReservaLaboratorio(?)}", true);
        if (rs.next()) {
            reservaLaboratorio = new ReservaLaboratorio(rs.getInt("codigo"),
                    (new MultiLaboratorio().buscarLaboratorioPorCodigo(rs.getInt("codigolaboratorio"))),
                    (new MultiCurso().buscarCursoPorCodigo(rs.getString("codigocurso"))),
                    (new MultiProfesor().buscarProfesorPorCedula(rs.getString("codigoprofesor"))), rs.getInt("cantidadestudiantes"),
                    (rs.getDate("fechareserva").toLocalDate()));
        }
        rs.close();
        return reservaLaboratorio;
    }

    public void actualizarReservaLaboratorio(ReservaLaboratorio reservaLaboratorio) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(reservaLaboratorio.getCodigo());
            data.add(reservaLaboratorio.getCodigoLaboratorio());
            data.add(Integer.parseInt(reservaLaboratorio.getCodigoCurso()));
            data.add(Integer.parseInt(reservaLaboratorio.getCedulaProfesor()));
            data.add(reservaLaboratorio.getCantEstudiantes());
            data.add(java.sql.Date.valueOf(reservaLaboratorio.getFechaReserva()));
            (new Conector()).getConector().ejecutarSQL(data, "{call updateReservaLaboratorio(?,?,?,?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarReservaLaboratorio(int codigo) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(codigo, "{call deleteReservaLaboratorio(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
