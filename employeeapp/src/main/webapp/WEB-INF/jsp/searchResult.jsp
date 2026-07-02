<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="<%=request.getContextPath()%>/css/empStyle.css" rel="stylesheet">
            <title>Resultado de la búsqueda</title>
        </head>

        <body>
            <h1>EMPLOYEE APP</h1>

            <c:choose>
                <c:when test="${found}">
                    <h2>Empleado encontrado</h2>
                    <table cellspacing="3" cellpadding="3" border="1">
                        <tr>
                            <td align="right"><b>ID:</b></td>
                            <td>${employee.id}</td>
                        </tr>
                        <tr>
                            <td align="right"><b>Nombre:</b></td>
                            <td>${employee.name}</td>
                        </tr>
                        <tr>
                            <td align="right"><b>Email:</b></td>
                            <td>${employee.email}</td>
                        </tr>
                        <tr>
                            <td align="right"><b>Teléfono:</b></td>
                            <td>${employee.phone}</td>
                        </tr>
                    </table>
                </c:when>
                <c:otherwise>
                    <h2>No se encontró ningún empleado con ese ID</h2>
                </c:otherwise>
            </c:choose>

            <br>
            <a href="<%=request.getContextPath()%>/search">Buscar otro empleado</a><br>
            <a href="<%=request.getContextPath()%>/">Volver a la página principal</a>
        </body>

        </html>