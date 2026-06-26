package MODULO_8.Desafio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginBDServlet", urlPatterns = {"/LoginBD"})
public class LoginBDServlet extends HttpServlet {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        mostrarFormulario(response, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        boolean credencialesValidas = usuarioDAO.validarCredenciales(usuario, clave);

        if(credencialesValidas){
            mostrarCredencialesCorrectas(response);
        }
        else{
            mostrarFormulario(response, "Credenciales incorrectas");
        }
    }

    private void mostrarFormulario(HttpServletResponse response, String mensajeError) throws IOException{

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Login con Base de Datos</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Formulario de Login</h1>");

        if(mensajeError != null){
            out.println("<p style='color:red; font-weight:bold;'>" + mensajeError + "</p>");
        }

        out.println("<form action='LoginBD' method='post'>");

        out.println("<label for='usuario'>Usuario:</label>");
        out.println("<input type='email' id='usuario' name='usuario' required>");
        out.println("<br><br>");

        out.println("<label for='clave'>Contraseña:</label>");
        out.println("<input type='password' id='clave' name='clave' required>");
        out.println("<br><br>");

        out.println("<input type='submit' value='Validar'>");

        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }

    private void mostrarCredencialesCorrectas(HttpServletResponse response) throws IOException{

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Credenciales Correctas</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Credenciales correctas</h1>");
        out.println("<br>");
        out.println("<a href='LoginBD'>Volver al formulario</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
