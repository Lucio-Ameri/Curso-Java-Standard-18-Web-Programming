package MODULO_6.Laboratorio_Adicional_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD{
    private static final String URL = "jdbc:mysql://localhost:3306/universidad"; // Aca va la dirección de la base de datos.
    private static final String USUARIO = "root"; // aca va el usuario con el que entras a la base de datos.
    private static final String PASSWORD = "NuevaContraseña123";  // aca va la contraseña que utilizas para entrar a la base de datos.

    private ConexionBD(){
    }

    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
