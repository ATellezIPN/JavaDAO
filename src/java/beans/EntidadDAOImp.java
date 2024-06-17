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

/**
 *
 * @author 52556
 */
public class EntidadDAOImp implements EntidadDAO {
    
    private String TABLE_NAME;
    private ConexionMySQL conMySQL;
    private Connection conn;
    
    public EntidadDAOImp(){
        TABLE_NAME = "Entidades";
        conMySQL = new ConexionMySQL();
    }

    @Override
    public void insert(Entidad entidad) throws SQLException {
        conn = conMySQL.getConnection();
        String insertQuery = "INSERT INTO "+TABLE_NAME+" (nombreEntidad)"
                + "VALUES(?)";
        try(PreparedStatement ps = conn.prepareStatement(insertQuery)){
            ps.setString(1, entidad.getNombreEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }

    @Override
    public void update(Entidad entidad) throws SQLException {
        conn = conMySQL.getConnection();
        String updateQuery = "UPDATE "+TABLE_NAME
                +" SET nombreEntidad = ?"
                +" WHERE idEntidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)){
            ps.setString(1, entidad.getNombreEntidad());
            ps.setInt(2, entidad.getIdEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        conn = conMySQL.getConnection();
        String deleteQuery = "DELET FROM "+TABLE_NAME
                +" WHERE idEntidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(deleteQuery)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        conn.close();
    }

    @Override
    public Entidad read(Integer id) throws SQLException {
        Entidad entidad = null;
        conn = conMySQL.getConnection();
        String Query = "SELECT idEntidad, "
                + "nombreEntidad FROM "+TABLE_NAME
                + "WHERE idEntidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    entidad = new Entidad(id,
                        rs.getString("nombreEntidad"));
                }
            }
        }
        return entidad;
    }

    @Override
    public List<Entidad> readAll() throws SQLException {
        List<Entidad> entidades = new ArrayList();
        conn = conMySQL.getConnection();
        String Query = "SELECT idEntidad, "
                + "nombreEntidad FROM "+TABLE_NAME;
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    Entidad entidad = new Entidad(
                        rs.getInt("idEntidad"),
                        rs.getString("nombreEntidad"));
                    entidades.add(entidad);
                }
            }
        }
        return entidades;
    }
    
    
}
