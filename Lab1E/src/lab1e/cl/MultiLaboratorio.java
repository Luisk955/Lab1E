package lab1e.cl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lab1e.accesobd.Accesobd;

public class MultiLaboratorio {

    public ArrayList<Laboratorio> listarLaboratorios() throws SQLException, Exception {
        ArrayList<Laboratorio> laboratorios = new ArrayList<>();
        Laboratorio laboratorio = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT codigo, nombre, capacidad "
                + "FROM Laboratorio ;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            laboratorio = new Laboratorio(Integer.parseInt(rs.getString("codigo")), rs.getString("nombre"), Integer.parseInt(rs.getString("capacidad")));
            laboratorios.add(laboratorio);
        }
        rs.close();
        return laboratorios;
    }

    public void registrarLaboratorio(Laboratorio laboratorio) throws Exception {
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call insertLaboratorio(?,?,?)}");
            cs.setInt(1, laboratorio.getCodigo());
            cs.setString(2, laboratorio.getNombre());
            cs.setInt(3, laboratorio.getCapacidad());
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Laboratorio buscarLaboratorioPorCodigo(int codigo) throws java.sql.SQLException, Exception {
        Laboratorio laboratorio = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT codigo, nombre, capacidad "
                + "FROM Laboratorio " + "WHERE codigo LIKE concat(" + codigo + ",'%')" + ";";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            laboratorio = new Laboratorio(Integer.parseInt(rs.getString("codigo")), rs.getString("nombre"), Integer.parseInt(rs.getString("capacidad")));
        }
        rs.close();
        return laboratorio;
    }

    public void actualizarLaboratorio(Laboratorio laboratorio) throws java.sql.SQLException, Exception {
        String sql;
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call updateLaboratorio(?,?,?)}");
            cs.setInt(1, laboratorio.getCodigo());
            cs.setString(2, laboratorio.getNombre());
            cs.setInt(3, laboratorio.getCapacidad());

            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarLaboratorio(int codigo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call deleteLaboratorio(?)}");
            cs.setInt(1, codigo);
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }
}
