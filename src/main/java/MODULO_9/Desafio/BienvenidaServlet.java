package MODULO_9.Desafio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BienvenidaServlet", urlPatterns = {"/Bienvenida"})
public class BienvenidaServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession sesion = request.getSession(false);
        if(sesion == null || sesion.getAttribute("usuario") == null){
            response.sendRedirect("LoginBD");
            return;
        }

        String usuario = (String) sesion.getAttribute("usuario");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Panel de Bienvenida</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Bienvenido/a, " + usuario + "</h1>");
        out.println("<p>Has iniciado sesión correctamente.</p>");
        out.println("<br>");

        out.println("<form action='Logout' method='post'>");
        out.println("<input type='submit' value='Cerrar sesión'>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
}
