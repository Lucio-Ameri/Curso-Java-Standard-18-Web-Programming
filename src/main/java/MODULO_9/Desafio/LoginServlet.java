package MODULO_9.Desafio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    private static final Map<String, String> USUARIOS_PERMITIDOS = new HashMap<>();

    static{
        USUARIOS_PERMITIDOS.put("user1@educacionit.com", "user1.1234");
        USUARIOS_PERMITIDOS.put("user2@educacionit.com", "user2.1235");
        USUARIOS_PERMITIDOS.put("user3@educacionit.com", "user3.1236");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        boolean credencialesCorrectas = validarCredenciales(usuario, clave);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado Login</title>");
        out.println("</head>");
        out.println("<body>");

        if(credencialesCorrectas){
            out.println("<h1>Credenciales correctas</h1>");
        }
        else{
            out.println("<h1>Credenciales incorrectas</h1>");
        }

        out.println("<br>");
        out.println("<a href='Login.html'>Volver al formulario</a>");

        out.println("</body>");
        out.println("</html>");
    }

    private boolean validarCredenciales(String usuario, String clave){
        String clavePermitida = USUARIOS_PERMITIDOS.get(usuario);

        return clavePermitida != null && clavePermitida.equals(clave);
    }
}
