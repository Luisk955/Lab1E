package lab1e.cl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lab1e.accesobd.Accesobd;

public class MultiCarrera {

    public ArrayList<Carrera> listarCarreras() throws SQLException, Exception {
        ArrayList<Carrera> carreras = new ArrayList<>();
        Carrera carrera = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT codigo, nombre, grado, acreditada "
                + "FROM Carrera ;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            carrera = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("grado"), Boolean.parseBoolean(rs.getString("acreditada")));
            carreras.add(carrera);
        }
        rs.close();
        return carreras;
    }

    public Carrera registrarCarrera(String codigo, String nombre, String grado, Boolean acreditada) throws Exception {
        Carrera carrera = null;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int codigoint = Integer.parseInt(codigo);

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call insertCarrera(?,?,?,?)}");
            cs.setInt(1, codigoint);
            cs.setString(2, nombre);
            cs.setString(3, grado);
            cs.setBoolean(4, acreditada);

            int numFAfectadas = cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
        return carrera;
    }

    public Carrera buscarCarreraPorCodigo(String codigo) throws java.sql.SQLException, Exception {
        Carrera carrera = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        int codigoint = Integer.parseInt(codigo);
        sql = "SELECT codigo, nombre, grado, acreditada "
                + "FROM Carrera " + "WHERE codigo LIKE concat(" + codigoint +",'%')"+  ";";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            carrera = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("grado"), Boolean.parseBoolean(rs.getString("acreditada")));
        }
        rs.close();
        return carrera;
    }

    public void actualizarCarrera(Carrera carrera) throws java.sql.SQLException, Exception {
        String sql;
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int codigoint = Integer.parseInt(carrera.getCodigo());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call updateCarrera(?,?,?,?)}");
            cs.setInt(1, codigoint);
            cs.setString(2, carrera.getNombre());
            cs.setString(3, carrera.getGrado());
            cs.setBoolean(4, carrera.getAcreditada());
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarCarrera(String codigo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int codigoint = Integer.parseInt(codigo);

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call deleteCarrera(?)}");
            cs.setInt(1, codigoint);
            cs.executeUpdate();

        } catch (Exception e) {
            throw new Exception("El cliente tiene cuentas.");
        }
    }
}
