/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import beans.Entidad;

/**
 *
 * @author 52556
 */
public class LocalidadDAOImp implements LocalidadDAO{
    private String TABLE_NAME;
    private ConexionMySQL conMySQL;
    private Connection conn;
    private int idEntidad;
    
    public LocalidadDAOImp(){
        TABLE_NAME = "Localidades";
        conMySQL = new ConexionMySQL();
    }

    @Override
    public Localidad read(Integer id) throws SQLException {
        Localidad localidad = null;
        EntidadDAOImp edi = new EntidadDAOImp();
        conn = conMySQL.getConnection();
        String Query = "SELECT idLocalidad, "
                + "nombreLocalidad, idEntidad FROM "+TABLE_NAME
                + "WHERE idLocalidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    localidad = new Localidad(id,
                        rs.getString("nombreLocalidad"),
                        rs.getInt(idEntidad));
                    localidad.setEntidad(edi.read(rs.getInt("idEntidad")));
                }
            }
        }
        return localidad;
    }

    @Override
    public List<Localidad> readAll() throws SQLException {
        List<Localidad> localidades = new ArrayList();
        conn = conMySQL.getConnection();
        String Query = "SELECT l.idLocalidad, "
                + "l.nombreLocalidad, l.idEntidad, e.nombreEntidad"
                + " FROM localidades l JOIN Entidades e"
                + " ON l.idEntidad = e.idEntidad";
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Localidad localidad = new Localidad(
                        rs.getInt("idLocalidad"),
                        rs.getString("nombreLocalidad"),
                        rs.getInt("idEntidad"));
                    localidades.add(localidad);
                }
            }
        }
        return localidades;
    }

    @Override
    public void insert(Localidad localidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Localidad localidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
