<%-- 
    Document   : index
    Created on : 15 jun 2024, 19:55:54
    Author     : 52556
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.Escuela"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <% getServletContext().getRequestDispatcher("/ServletEscuelas").include(request, response);%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Universidad</h1>
        <table>
            <tr>
                <th>CLAVE</th>
                <th>ESCUELA</th>
                <th>DOMICILIO</th>
                <th>TURNO</th>
                <th></th>
            </tr>
            <c:forEach items="${requestScope.ListaEscuelas}" var="e">
                <tr>
                    <td><c:out value="${e.claveEscuela}"/></td>
                    <td><c:out value="${e.nombreEscuela}"/></td>
                    <td><c:out value="${e.domicilio}"/></td>
                    <td><c:out value="${e.turno}"/></td>
                    <td><a href="#">Editar</a> | <a href="#">Eliminar</a></td>
                </tr>    
            </c:forEach>
        </table>
    </body>
</html>

