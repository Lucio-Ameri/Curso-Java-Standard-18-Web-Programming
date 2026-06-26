package MODULO_8.Desafio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializadorBD {
    private static final String URL_BASE = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "TU_PASSWORD";

    public static void main(String[] args){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conexion = DriverManager.getConnection(URL_BASE, USUARIO, PASSWORD);
                 Statement statement = conexion.createStatement()) {

                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS desafio_web");
                statement.executeUpdate("USE desafio_web");
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (id INT AUTO_INCREMENT PRIMARY KEY, usuario VARCHAR(100) NOT NULL UNIQUE, clave VARCHAR(100) NOT NULL)");
                statement.executeUpdate("INSERT INTO usuarios (usuario, clave) VALUES ('user1@educacionit.com', 'user1.1234'), ('user2@educacionit.com', 'user2.1235'), ('user3@educacionit.com', 'user3.1236')ON DUPLICATE KEY UPDATEclave = VALUES(clave) ");

                System.out.println("Base de datos creada correctamente.");
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("No se encontró el driver de MySQL.");
            e.printStackTrace();

        }
        catch(SQLException e){
            System.out.println("Error al inicializar la base de datos.");
            e.printStackTrace();
        }
    }
}
