<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, MODULO_9.Laboratorio_Adicional_1.Empleado, MODULO_9.Laboratorio_Adicional_1.DatosDemo" %>
<%
    // Punto 2: solo se muestra si hay una sesión iniciada correctamente.
    String correo = (String) session.getAttribute("correo");
    if (correo == null) {
        // Si no hay sesión, vuelve al formulario (Punto 4)
        response.sendRedirect("index.html?error=2");
        return;
    }

    List<Empleado> empleados = DatosDemo.getEmpleadosAdministrativos();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Empleados administrativos</title>
    <style>
        body { font-family: Arial, Helvetica, sans-serif; background:#f4f6f8; margin:0; padding:30px; }
        .barra { display:flex; justify-content:space-between; align-items:center; margin-bottom:20px; }
        h1 { color:#273c75; margin:0; font-size:24px; }
        .usuario { color:#555; font-size:14px; }
        a.salir { background:#c0392b; color:#fff; text-decoration:none; padding:9px 16px; border-radius:5px; font-size:14px; }
        a.salir:hover { background:#a93226; }
        table { width:100%; border-collapse:collapse; background:#fff; box-shadow:0 2px 8px rgba(0,0,0,0.08); }
        th, td { padding:12px 14px; text-align:left; border-bottom:1px solid #eee; }
        th { background:#273c75; color:#fff; }
        tr:hover td { background:#f0f3ff; }
    </style>
</head>
<body>
    <div class="barra">
        <div>
            <h1>Lista de empleados administrativos</h1>
            <span class="usuario">Sesión iniciada como: <strong><%= correo %></strong></span>
        </div>
        <!-- Punto 3: cerrar la sesión -->
        <a class="salir" href="logout">Cerrar sesión</a>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Cargo</th>
                <th>Área</th>
            </tr>
        </thead>
        <tbody>
        <% for (Empleado e : empleados) { %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getNombre() %></td>
                <td><%= e.getCargo() %></td>
                <td><%= e.getArea() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
