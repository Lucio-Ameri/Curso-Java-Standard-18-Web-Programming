package MODULO_9.Laboratorio_Adicional_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String idSesion = "(no había una sesión activa)";
        boolean cerradaCorrectamente = false;

        if(session != null){
            idSesion = session.getId();
            session.invalidate();
            cerradaCorrectamente = true;
        }

        request.setAttribute("idSesion", idSesion);
        request.setAttribute("cerradaCorrectamente", cerradaCorrectamente);

        request.getRequestDispatcher("logout.jsp").forward(request, response);
    }
}
