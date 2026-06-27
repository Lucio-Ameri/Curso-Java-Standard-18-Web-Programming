package MODULO_9.Laboratorio_Adicional_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        boolean credencialesValidas = false;
        for(Usuario u : DatosDemo.getUsuarios()){
            if(u.getCorreo().equals(correo) && u.getClave().equals(clave)){
                credencialesValidas = true;
                break;
            }
        }

        if(credencialesValidas){
            HttpSession session = request.getSession(true);
            session.setAttribute("correo", correo);

            request.getRequestDispatcher("empleados.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("index.html?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("index.html");
    }
}
