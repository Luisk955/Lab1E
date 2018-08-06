package lab1e.cl;

import accesobd.Conector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MultiProfesor {

    public ArrayList<Profesor> listarProfesores() throws SQLException, Exception {
        ArrayList<Profesor> profesores = new ArrayList<>();
        Profesor profesor = null;

        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listarProfesores()}", true);
        while (rs.next()) {
            profesor = new Profesor(rs.getString("lugarTrabajo"), Integer.parseInt(rs.getString("annosExp")), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
            profesores.add(profesor);
        }
        rs.close();
        return profesores;
    }

    public void registrarProfesor(Profesor profesor) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(Integer.parseInt(profesor.getCedula()));
        data.add(profesor.getNombre());
        data.add(profesor.getApellido());
        data.add(profesor.getDireccion());
        data.add(profesor.getTelefono());
        data.add(profesor.getLugarTrabajo());
        data.add(profesor.getAnnosExp());

        (new Conector()).getConector().ejecutarSQL(data, "{call insertProfesor(?,?,?,?,?,?,?)}");
    }

    public Profesor buscarProfesorPorCedula(String cedula) throws java.sql.SQLException, Exception {
        Profesor profesor = null;

        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(Integer.parseInt(cedula), "{call searchProfesor(?)}", true);
        if (rs.next()) {
            profesor = new Profesor(rs.getString("lugarTrabajo"), Integer.parseInt(rs.getString("annosExp")), rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"));
        }
        rs.close();
        return profesor;
    }

    public void actualizarProfesor(Profesor profesor) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(Integer.parseInt(profesor.getCedula()));
            data.add(profesor.getNombre());
            data.add(profesor.getApellido());
            data.add(profesor.getDireccion());
            data.add(profesor.getTelefono());
            data.add(profesor.getLugarTrabajo());
            data.add(profesor.getAnnosExp());
            (new Conector()).getConector().ejecutarSQL(data, "{call updateProfesor(?,?,?,?,?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarProfesor(String cedula) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(Integer.parseInt(cedula), "{call deleteProfesor(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
