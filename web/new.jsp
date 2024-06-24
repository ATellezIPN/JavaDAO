<%@page import="java.util.List"%>
<%@page import="beans.Entidad"%>
<%@page import="beans.Localidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
    request.getRequestDispatcher("/LocalidadLoad").include(request, response);
    if(request.getAttribute("ListaEntidades")==null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Localidad</title>
    </head>
    <body>
        <h2>Agregar localidad</h2>
        <form action="../LocalidadLoad" method="POST">
            Nombre: <input type="text" name="nombreLocalidad" value=""/><br/>
            Entidad:
            <select name="idEntidad">
                <c:forEach var="entidad" items="${requestScope.ListaEntidades}">
                    <option value="${entidad.idEntidad}">
                        ${entidad.nombreEntidad}
                    </option>
                </c:forEach>>
            </select>
            
            <p>
                <input type="submit" value="Guardar"/>
                <input type="button" value="Cancelar" onclick="window.history.back();"/>
            </p>
        </form>
    </body>
</html>
