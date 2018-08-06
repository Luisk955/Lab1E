package lab1e.cl;

import accesobd.AccesoBD;
import accesobd.Conector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MultiLaboratorio {

    public ArrayList<Laboratorio> listarLaboratorios() throws SQLException, Exception {
        ArrayList<Laboratorio> laboratorios = new ArrayList<>();
        Laboratorio laboratorio = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL("{call listarLaboratorios()}", true);
        while (rs.next()) {
            laboratorio = new Laboratorio(Integer.parseInt(rs.getString("codigo")), rs.getString("nombre"),
                    Integer.parseInt(rs.getString("capacidad")));
            laboratorios.add(laboratorio);
        }
        rs.close();
        return laboratorios;
    }

    public void registrarLaboratorio(Laboratorio laboratorio) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(laboratorio.getCodigo());
        data.add(laboratorio.getNombre());
        data.add(laboratorio.getCapacidad());
        (new Conector()).getConector().ejecutarSQL(data, "{call insertLaboratorio(?,?,?)}");
    }

    public Laboratorio buscarLaboratorioPorCodigo(int codigo) throws java.sql.SQLException, Exception {
        Laboratorio laboratorio = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(codigo, "{call searchLaboratorio(?)}", true);

        if (rs.next()) {
            laboratorio = new Laboratorio(Integer.parseInt(rs.getString("codigo")), rs.getString("nombre"), Integer.parseInt(rs.getString("capacidad")));
        }
        rs.close();
        return laboratorio;
    }

    public void actualizarLaboratorio(Laboratorio laboratorio) throws java.sql.SQLException, Exception {
        try {
            ArrayList<Object> data = new ArrayList<>();
            data.add(laboratorio.getCodigo());
            data.add(laboratorio.getNombre());
            data.add(laboratorio.getCapacidad());
            (new Conector()).getConector().ejecutarSQL(data, "{call updateLaboratorio(?,?,?)}");
        } catch (SQLException e) {
            throw e;
        }
    }

    public void borrarLaboratorio(int codigo) throws java.sql.SQLException, Exception {
        try {
            (new Conector()).getConector().ejecutarSQL(codigo, "{call deleteLaboratorio(?)}");
        } catch (SQLException e) {
            throw e;
        }
    }
}
