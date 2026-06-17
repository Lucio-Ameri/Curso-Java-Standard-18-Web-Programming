package MODULO_6.Desafio.Ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO{
    public Long guardarSiNoExiste(Pais pais){
        if(pais == null){
            throw new IllegalArgumentException("El país no puede ser null.");
        }

        return guardarSiNoExiste(pais.getDescripcion());
    }

    public Long guardarSiNoExiste(String descripcion){
        validarDescripcion(descripcion);

        String sql = " INSERT INTO pais (descripcion) VALUES (?) ON DUPLICATE KEY UPDATE id = LAST_INSERT_ID(id) ";

        try(Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            sentencia.setString(1, descripcion.trim());
            sentencia.executeUpdate();

            try(ResultSet clavesGeneradas = sentencia.getGeneratedKeys()){
                if(clavesGeneradas.next()){
                    return clavesGeneradas.getLong(1);
                }
            }

            return buscarIdPorDescripcion(descripcion);
        }
        catch(SQLException e){
            System.out.println("Error al guardar país: " + e.getMessage());
            return null;
        }
    }

    public Long buscarIdPorDescripcion(String descripcion){
        validarDescripcion(descripcion);

        String sql = " SELECT id FROM pais WHERE descripcion = ? ";

        try(Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)){

            sentencia.setString(1, descripcion.trim());

            try(ResultSet resultado = sentencia.executeQuery()){
                if(resultado.next()){
                    return resultado.getLong("id");
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error al buscar país: " + e.getMessage());
        }

        return null;
    }

    private void validarDescripcion(String descripcion){
        if(descripcion == null || descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripción del país no puede estar vacía.");
        }
    }
}
