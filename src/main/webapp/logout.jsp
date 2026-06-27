<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String idSesion = (String) request.getAttribute("idSesion");
    Boolean cerrada = (Boolean) request.getAttribute("cerradaCorrectamente");
    if (idSesion == null) idSesion = "(desconocido)";
    boolean ok = (cerrada != null && cerrada);
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Sesión cerrada</title>
    <style>
        body { font-family: Arial, Helvetica, sans-serif; background:#2f3640; display:flex;
               justify-content:center; align-items:center; height:100vh; margin:0; }
        .caja { background:#fff; padding:30px 35px; border-radius:10px; width:380px;
                box-shadow:0 8px 20px rgba(0,0,0,0.3); text-align:center; }
        h1 { color:#273c75; font-size:22px; }
        .ok { color:#27ae60; font-weight:bold; }
        .id { background:#f0f3ff; padding:10px; border-radius:5px; font-family:monospace;
              font-size:13px; color:#273c75; word-break:break-all; margin:14px 0; }
        a { display:inline-block; margin-top:10px; background:#273c75; color:#fff;
            text-decoration:none; padding:10px 18px; border-radius:5px; }
        a:hover { background:#1e3163; }
    </style>
</head>
<body>
    <div class="caja">
        <h1>Cierre de sesión</h1>

        <% if (ok) { %>
            <!-- Punto 4: indica si se cerró la sesión correctamente -->
            <p class="ok">La sesión se cerró de forma correcta. ✔</p>
        <% } else { %>
            <p>No había una sesión activa para cerrar.</p>
        <% } %>

        <!-- Punto 3: muestra el ID de la sesión -->
        <p>ID de la sesión:</p>
        <div class="id"><%= idSesion %></div>

        <a href="index.html">Volver al inicio</a>
    </div>
</body>
</html>
