package servlets;

import beans.Escuela;
import java.io.IOException;
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

public class ServletEscuelas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection connect;
    Statement statement;
    ResultSet resultSet;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/universidad?user=root&password=123456";
            connect = DriverManager.getConnection(URL);
            statement = connect.createStatement();
            request.setAttribute("ListaEscuelas", getListaEscuelas());
            connect.close();
            request.getRequestDispatcher("index.jsp").forward(request, response); // Forward to JSP
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Escuela> getListaEscuelas() throws SQLException {
        String query = "SELECT * FROM Escuelas";
        resultSet = statement.executeQuery(query);
        List<Escuela> Escuelas = new ArrayList<>();
        while (resultSet.next()) {
            Escuela escuela = new Escuela();
            escuela.setClaveEscuela(resultSet.getString("claveEscuela"));
            escuela.setNombreEscuela(resultSet.getString("nombreEscuela"));
            escuela.setDomicilio(resultSet.getString("domicilio"));
            escuela.setCodigoPostal(resultSet.getInt("codigoPostal"));
            escuela.setTurno(resultSet.getString("turno"));
            escuela.setIdLocalidad(resultSet.getInt("idLocalidad"));
            Escuelas.add(escuela);
        }
        return Escuelas;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
