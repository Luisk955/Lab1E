package lab1e.cl;

import accesobd.Conector;
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

        rs = (new Conector()).getConector().ejecutarSQL("{call listarCarreras()}", true);

        while (rs.next()) {
            carrera = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("grado"), Boolean.parseBoolean(rs.getString("acreditada")));
            carreras.add(carrera);
        }
        rs.close();
        return carreras;
    }

    public void registrarCarrera(Carrera carrera) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        int codigoInt = Integer.parseInt(carrera.getCodigo());
        data.add(codigoInt);
        data.add(carrera.getNombre());
        data.add(carrera.getGrado());
        data.add(carrera.getAcreditada());
        (new Conector()).getConector().ejecutarSQL(data, "{call insertCarrera(?,?,?,?)}");
    }

    public Carrera buscarCarreraPorCodigo(String codigo) throws java.sql.SQLException, Exception {
        Carrera carrera = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(Integer.parseInt(codigo), "{call searchCarrera(?)}", true);
        if (rs.next()) {
            carrera = new Carrera(rs.getString("codigo"), rs.getString("nombre"), rs.getString("grado"), rs.getBoolean("acreditada"));
        }
        rs.close();
        return carrera;
    }

    public void actualizarCarrera(Carrera carrera) throws java.sql.SQLException, Exception {
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(Integer.parseInt(carrera.getCodigo()));
            data.add(carrera.getNombre());
            data.add(carrera.getGrado());
            data.add(carrera.getAcreditada());
            (new Conector()).getConector().ejecutarSQL(data, "{call updateCarrera(?,?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarCarrera(String codigo) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(Integer.parseInt(codigo), "{call deleteCarrera(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
