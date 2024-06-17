/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import beans.Entidad;
import beans.EntidadDAO;
import beans.EntidadDAOImp;
import beans.Localidad;
import beans.LocalidadDAO;
import beans.LocalidadDAOImp;
import beans.ConexionMySQL;
import beans.Escuela;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 52556
 */
public class ServletEscuelas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    Connection connect;
    Statement statement;
    ResultSet resultSet;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String URL = "jdbc:mysql://localhost:3306/universidad?user=root&password=123456";
            
            connect = DriverManager.getConnection(URL);
            statement = connect.createStatement();
            
            request.setAttribute("ListaEscuelas", getListaEscuelas());
            
            connect.close();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
    }
    
    public List<Escuela> getListaEscuelas() throws SQLException{
        String query = "SELECT * from Escuelas";
        resultSet =statement.executeQuery(query);
        
        List<Escuela> Escuelas = new ArrayList();
        Escuela escuela;
        while (resultSet.next()){
            escuela = new Escuela();
            escuela.setClaveEscuela(resultSet.getString(1));
            escuela.setNombreEscuela(resultSet.getString(2));
            escuela.setDomicilio(resultSet.getString(3));
            escuela.setCodigoPostal(resultSet.getInt(4));
            escuela.setTurno(resultSet.getString(5));
            escuela.setIdLocalidad(resultSet.getInt(6));
            Escuelas.add(escuela);
        }
        return Escuelas;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}