package MODULO_6.Desafio.Ejercicio1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializadorBD {
    private InicializadorBD() {
    }

    public static boolean crearBaseYTablas() {
        return crearBaseDatos() && crearTablas();
    }

    private static boolean crearBaseDatos() {
        String sql = "CREATE DATABASE IF NOT EXISTS " + ConexionBD.getNombreBaseDatos();

        try(Connection conexion = ConexionBD.obtenerConexion();
             Statement sentencia = conexion.createStatement()){

            sentencia.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println("Error al crear la base de datos: " + e.getMessage());
            return false;
        }
    }

    private static boolean crearTablas(){
        String crearTablaPais = " CREATE TABLE IF NOT EXISTS pais (id BIGINT AUTO_INCREMENT PRIMARY KEY, descripcion VARCHAR(100) NOT NULL UNIQUE)";
        String crearTablaCiudad = " CREATE TABLE IF NOT EXISTS ciudad (id BIGINT AUTO_INCREMENT PRIMARY KEY, pais_id BIGINT NOT NULL, descripcion VARCHAR(100) NOT NULL, CONSTRAINT fk_ciudad_pais FOREIGN KEY (pais_id) REFERENCES pais(id), CONSTRAINT uk_ciudad_pais_descripcion UNIQUE (pais_id, descripcion))";

        try(Connection conexion = ConexionBD.obtenerConexion();
             Statement sentencia = conexion.createStatement()){

            sentencia.executeUpdate(crearTablaPais);
            sentencia.executeUpdate(crearTablaCiudad);
            return true;
        }
        catch(SQLException e){
            System.out.println("Error al crear las tablas: " + e.getMessage());
            return false;
        }
    }
}
