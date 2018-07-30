package lab1e.cl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lab1e.accesobd.Accesobd;

public class MultiEmpleado {

    public ArrayList<Empleado> listarEmpleados() throws SQLException, Exception {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        sql = "SELECT cedula, nombre, apellido, direccion, telefono, puesto "
                + "FROM Empleado ;";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            empleado = new Empleado(rs.getString("puesto"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
            empleados.add(empleado);
        }
        rs.close();
        return empleados;
    }

    public void registrarEmpleado(Empleado empleado) throws Exception {
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(empleado.getCedula());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call insertEmpleado(?,?,?,?,?,?)}");
            cs.setInt(1, cedulaint);
            cs.setString(2, empleado.getNombre());
            cs.setString(3, empleado.getApellido());
            cs.setString(4, empleado.getDireccion());
            cs.setString(5, empleado.getTelefono());
            cs.setString(6, empleado.getPuesto());
            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public Empleado buscarEmpleadoPorCedula(String cedula) throws java.sql.SQLException, Exception {
        Empleado empleado = null;
        java.sql.ResultSet rs;
        String sql;
        Accesobd accesobd = new Accesobd();
        Connection conn = accesobd.getConexion();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(cedula);
        sql = "SELECT cedula, nombre, apellido, direccion, telefono, puesto "
                + "FROM Empleado " + "WHERE cedula LIKE concat(" + cedulaint + ",'%')" + ";";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        if (rs.next()) {
            empleado = new Empleado(rs.getString("puesto"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
        }
        rs.close();
        return empleado;
    }

    public void actualizarEmpleado(Empleado empleado) throws java.sql.SQLException, Exception {
        String sql;
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(empleado.getCedula());

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call updateEmpleado(?,?,?,?,?,?)}");
            cs.setInt(1, cedulaint);
            cs.setString(2, empleado.getNombre());
            cs.setString(3, empleado.getApellido());
            cs.setString(4, empleado.getDireccion());
            cs.setString(5, empleado.getTelefono());
            cs.setString(6, empleado.getPuesto());

            cs.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarEmpleado(String cedula) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        Accesobd accesobd = new Accesobd();
        Statement stmt = null;
        int cedulaint = Integer.parseInt(cedula);

        try {
            Connection conn = accesobd.getConexion();
            CallableStatement cs = conn.prepareCall("{call deleteEmpleado(?)}");
            cs.setInt(1, cedulaint);
            cs.executeUpdate();

        } catch (Exception e) {
            throw new Exception("El cliente tiene cuentas.");
        }
    }
}
