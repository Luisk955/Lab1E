package lab1e.cl;

import accesobd.Conector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MultiEmpleado {

    public ArrayList<Empleado> listarEmpleados() throws SQLException, Exception {
        ArrayList<Empleado> empleados = new ArrayList<>();
        Empleado empleado = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarEmpleados()}", true);
        while (rs.next()) {
            empleado = new Empleado(rs.getString("puesto"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
            empleados.add(empleado);
        }
        rs.close();
        return empleados;
    }

    public void registrarEmpleado(Empleado empleado) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(Integer.parseInt(empleado.getCedula()));
        data.add(empleado.getNombre());
        data.add(empleado.getApellido());
        data.add(empleado.getDireccion());
        data.add(empleado.getTelefono());
        data.add(empleado.getPuesto());
        (new Conector()).getConector().ejecutarSQL(data, "{call insertEmpleado(?,?,?,?,?,?)}");
    }

    public Empleado buscarEmpleadoPorCedula(String cedula) throws java.sql.SQLException, Exception {
        Empleado empleado = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(Integer.parseInt(cedula), "{call searchEmpleado(?)}", true);
        if (rs.next()) {
            empleado = new Empleado(rs.getString("puesto"), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
        }
        rs.close();
        return empleado;
    }

    public void actualizarEmpleado(Empleado empleado) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(Integer.parseInt(empleado.getCedula()));
            data.add(empleado.getNombre());
            data.add(empleado.getApellido());
            data.add(empleado.getDireccion());
            data.add(empleado.getTelefono());
            data.add(empleado.getPuesto());
            (new Conector()).getConector().ejecutarSQL(data, "{call updateEmpleado(?,?,?,?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarEmpleado(String cedula) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(Integer.parseInt(cedula), "{call deleteEmpleado(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
