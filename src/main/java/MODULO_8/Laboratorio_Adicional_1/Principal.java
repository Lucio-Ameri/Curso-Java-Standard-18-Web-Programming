package MODULO_8.Laboratorio_Adicional_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Principal", urlPatterns = {"/Administrador"})
public class Principal extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Datos del Administrador</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Datos del Administrador</h1>");

        out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
        out.println("<p><strong>Apellido:</strong> " + apellido + "</p>");
        out.println("<p><strong>DNI:</strong> " + dni + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Usuario:</strong> " + usuario + "</p>");
        out.println("<p><strong>Contraseña:</strong> " + password + "</p>");

        out.println("<br>");
        out.println("<a href='Formulario.html'>Volver al formulario</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
