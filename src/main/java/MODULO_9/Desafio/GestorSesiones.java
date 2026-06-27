package MODULO_9.Desafio;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GestorSesiones{
    private static final Map<String, String> SESIONES_ACTIVAS = new ConcurrentHashMap<>();

    /**
     * Indica si el usuario ya tiene una sesión activa en OTRO navegador,
     * distinta a la sesión actual.
     *
     * @param usuario        correo del usuario
     * @param idSesionActual id de la sesión del navegador desde el que se intenta entrar
     *                       (puede ser null si todavía no hay sesión creada)
     */
    public static synchronized boolean tieneSesionEnOtroNavegador(String usuario, String idSesionActual){
        String idRegistrado = SESIONES_ACTIVAS.get(usuario);
        return idRegistrado != null && !idRegistrado.equals(idSesionActual);
    }

    public static synchronized void registrarSesion(String usuario, String idSesion){
        SESIONES_ACTIVAS.put(usuario, idSesion);
    }

    public static synchronized void eliminarSesion(String usuario){
        SESIONES_ACTIVAS.remove(usuario);
    }
}
