package MODULO_9.Desafio;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener{

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
        Object usuario = se.getSession().getAttribute("usuario");
        if(usuario != null){
            GestorSesiones.eliminarSesion(usuario.toString());
        }
    }
}
