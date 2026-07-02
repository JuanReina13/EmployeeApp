<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="<%=request.getContextPath()%>/css/empStyle.css" rel="stylesheet">
            <title>Lista de Empleados</title>
        </head>

        <body>
            <h1>EMPLOYEE APP</h1>
            <h2>Listado de empleados</h2>

            <c:choose>
                <c:when test="${empty employees}">
                    <p>No hay empleados registrados.</p>
                </c:when>
                <c:otherwise>
                    <table cellspacing="3" cellpadding="3" border="1">
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                        </tr>
                        <c:forEach var="emp" items="${employees}">
                            <tr>
                                <td>${emp.id}</td>
                                <td>${emp.name}</td>
                                <td>${emp.email}</td>
                                <td>${emp.phone}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>

            <br>
            <a href="<%=request.getContextPath()%>/">Volver a la página principal</a>
        </body>

        </html>