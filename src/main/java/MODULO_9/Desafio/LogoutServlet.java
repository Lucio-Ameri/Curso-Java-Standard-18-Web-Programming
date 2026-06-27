package MODULO_9.Desafio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/Logout"})
public class LogoutServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        cerrarSesion(request);
        response.sendRedirect("LoginBD");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        cerrarSesion(request);
        response.sendRedirect("LoginBD");
    }

    private void cerrarSesion(HttpServletRequest request){
        HttpSession sesion = request.getSession(false);
        if(sesion != null){
            Object usuario = sesion.getAttribute("usuario");
            if(usuario != null){
                GestorSesiones.eliminarSesion(usuario.toString());
            }
            sesion.invalidate();
        }
    }
}
