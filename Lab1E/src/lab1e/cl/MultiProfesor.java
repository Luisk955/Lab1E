package lab1e.cl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lab1e.accesobd.Accesobd;

public class MultiProfesor {

    public ArrayList<Profesor> listarProfesores() throws SQLException, Exception {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Profesor profesor = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT cedula, nombre, apellido, direccion, telefono, lugarTrabajo, annosExp "
                + "FROM Profesor ;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            profesor = new Profesor(rs.getString("lugarTrabajo"), Integer.parseInt(rs.getString("annosExp")), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
            profesores.add(profesor);
        }
        rs.close();
        return profesores;
    }

    public void registrarProfesor(Profesor profesor) throws Exception {
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(profesor.getCedula());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call insertProfesor(?,?,?,?,?,?,?)}");
            cs.setInt(1, cedulaint);
            cs.setString(2, profesor.getNombre());
            cs.setString(3, profesor.getApellido());
            cs.setString(4, profesor.getDireccion());
            cs.setString(5, profesor.getTelefono());
            cs.setString(6, profesor.getLugarTrabajo());
            cs.setInt(7, profesor.getAnnosExp());

            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Profesor buscarProfesorPorCedula(String cedula) throws java.sql.SQLException, Exception {
        Profesor profesor = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(cedula);
        sql = "SELECT cedula, nombre, apellido, direccion, telefono, lugarTrabajo, annosExp "
                + "FROM Profesor " + "WHERE cedula LIKE concat(" + cedulaint + ",'%')" + ";";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            profesor = new Profesor(rs.getString("lugarTrabajo"), Integer.parseInt(rs.getString("annosExp")), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
        }
        rs.close();
        return profesor;
    }

    public void actualizarProfesor(Profesor profesor) throws java.sql.SQLException, Exception {
        String sql;
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(profesor.getCedula());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call updateProfesor(?,?,?,?,?,?,?)}");
            cs.setInt(1, cedulaint);
            cs.setString(2, profesor.getNombre());
            cs.setString(3, profesor.getApellido());
            cs.setString(4, profesor.getDireccion());
            cs.setString(5, profesor.getTelefono());
            cs.setString(6, profesor.getLugarTrabajo());
            cs.setInt(7, profesor.getAnnosExp());

            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarProfesor(String cedula) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(cedula);

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call deleteProfesor(?)}");
            cs.setInt(1, cedulaint);
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }
}
