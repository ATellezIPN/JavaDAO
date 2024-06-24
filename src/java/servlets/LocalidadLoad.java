/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import beans.EntidadDAOImp;
import beans.Localidad;
import beans.LocalidadDAOImp;
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
@WebServlet(name = "LocalidadLoad", urlPatterns = {"/LocalidadLoad"})
public class LocalidadLoad extends HttpServlet {
    
    private LocalidadDAOImp ldi;
    private EntidadDAOImp edi;
    
    @Override
    public void init() throws ServletException {
        ldi = new LocalidadDAOImp();
        edi = new EntidadDAOImp();
        super.init(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("ListaLocalidades", ldi.readAll());
            request.setAttribute("ListaEntidades", edi.readAll());
        } catch (SQLException ex){
            getServletContext().setAttribute("ListaLocalidadesIndex", ex);
            response.sendRedirect("ListaLocalidadesIndex.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(esValido(request)){
            String name = request.getParameter("nombreLocalidad").toUpperCase().trim();
            int idEntidad = Integer.valueOf(request.getParameter("idEntidad"));
            try{
                ldi.insert(new Localidad());
            } catch(SQLException ex){
                getServletContext().setAttribute("ListaLocalidadesIndex", ex);
                response.sendRedirect("ListaLocalidadesIndex.jsp");
            }
            response.sendRedirect("Localidades/index.jsp");
        }else{
            getServletContext().setAttribute("msj", "No se pudo guardar "
                    +"registro, debido a que"
                    +"uno de los cambios no es valido");
            response.sendRedirect("Localidades/new.jsp");
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

}
