/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import beans.Localidad;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 52556
 */
@WebServlet(name = "LocalidadEdit", urlPatterns = {"/LocalidadEdit"})
public class LocalidadEdit extends HttpServlet {

    private Object ldi;
    private Object edi;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LocalidadEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LocalidadEdit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("id")!=null){
            int id= Integer.parseInt(request.getParameter("id"));
            request.setAttribute("Localidad", ldi);
            request.setAttribute("ListaEntidades", edi);
            request.getRequestDispatcher("/Localidades/edit.jsp")
                    .forward(request, response);
        }
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    if (esValido(request)) {
        int id = Integer.parseInt(request.getParameter("idLocalidad"));
        String name = request.getParameter("nombreLocalidad").toUpperCase().trim();
        int idEntidad = Integer.parseInt(request.getParameter("idEntidad"));
        ldi(new Localidad());
        response.sendRedirect("Localidades/index.jsp");
    } else {
        getServletContext().setAttribute("msj", "No se pudo guardar registro, "
                + "debido a que"
                + " uno de los campos no es válido.");
        response.sendRedirect("Localidades/edit.jsp");
    }
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean esValido(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void ldi(Localidad localidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
