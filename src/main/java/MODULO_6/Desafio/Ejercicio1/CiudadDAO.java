package MODULO_6.Desafio.Ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO{
    public Long guardarSiNoExiste(Long paisId, String descripcion){
        if(paisId == null){
            throw new IllegalArgumentException("El id del país no puede ser null.");
        }

        validarDescripcion(descripcion);

        String sql = "INSERT INTO ciudad (pais_id, descripcion) VALUES (?, ?) ON DUPLICATE KEY UPDATE id = LAST_INSERT_ID(id) ";

        try(Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            sentencia.setLong(1, paisId);
            sentencia.setString(2, descripcion.trim());
            sentencia.executeUpdate();

            try(ResultSet clavesGeneradas = sentencia.getGeneratedKeys()){
                if(clavesGeneradas.next()){
                    return clavesGeneradas.getLong(1);
                }
            }

            return buscarIdPorPaisYDescripcion(paisId, descripcion);
        }
        catch(SQLException e){
            System.out.println("Error al guardar ciudad: " + e.getMessage());
            return null;
        }
    }

    public Long buscarIdPorPaisYDescripcion(Long paisId, String descripcion){
        if(paisId == null){
            throw new IllegalArgumentException("El id del país no puede ser null.");
        }

        validarDescripcion(descripcion);

        String sql = " SELECT id FROM ciudad WHERE pais_id = ? AND descripcion = ? ";

        try(Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)){

            sentencia.setLong(1, paisId);
            sentencia.setString(2, descripcion.trim());

            try(ResultSet resultado = sentencia.executeQuery()){
                if(resultado.next()){
                    return resultado.getLong("id");
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error al buscar ciudad: " + e.getMessage());
        }

        return null;
    }

    public List<Ciudad> buscarPorCoincidencia(String palabra){
        return buscarPorCoincidenciaEnPais(palabra, null);
    }

    public List<Ciudad> buscarPorCoincidenciaEnArgentina(String palabra){
        return buscarPorCoincidenciaEnPais(palabra, "Argentina");
    }

    public List<Ciudad> buscarPorCoincidenciaEnPais(String palabra, String paisBuscado){
        List<Ciudad> ciudades = new ArrayList<>();

        if(palabra == null){
            palabra = "";
        }

        String sql = " SELECT c.id AS ciudad_id, c.descripcion AS ciudad_descripcion, p.id AS pais_id, p.descripcion AS pais_descripcion FROM ciudad c INNER JOIN pais p ON c.pais_id = p.id WHERE LOWER(c.descripcion) LIKE LOWER(?)AND (? IS NULL OR p.descripcion = ?)ORDER BY p.descripcion, c.descripcion ";

        try(Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)){

            sentencia.setString(1, "%" + palabra.trim() + "%");
            sentencia.setString(2, paisBuscado);
            sentencia.setString(3, paisBuscado);

            try(ResultSet resultado = sentencia.executeQuery()){
                while(resultado.next()){
                    Pais pais = new Pais(resultado.getLong("pais_id"), resultado.getString("pais_descripcion"));
                    Ciudad ciudad = new Ciudad(resultado.getLong("ciudad_id"), pais, resultado.getString("ciudad_descripcion"));

                    ciudades.add(ciudad);
                }
            }
        }
        catch(SQLException e){
            System.out.println("Error al buscar ciudades: " + e.getMessage());
        }

        return ciudades;
    }

    public void mostrarCiudadesPorCoincidencia(String palabra){
        List<Ciudad> ciudades = buscarPorCoincidencia(palabra);

        if(ciudades.isEmpty()){
            System.out.println("No se encontraron ciudades con la palabra: " + palabra);
            return;
        }

        System.out.println("Ciudades encontradas:");
        for(Ciudad ciudad : ciudades){
            System.out.println(ciudad);
        }
    }

    public void mostrarCiudadesArgentinasPorCoincidencia(String palabra){
        List<Ciudad> ciudades = buscarPorCoincidenciaEnArgentina(palabra);

        if(ciudades.isEmpty()){
            System.out.println("No se encontraron ciudades argentinas con la palabra: " + palabra);
            return;
        }

        System.out.println("Ciudades argentinas encontradas:");
        for(Ciudad ciudad : ciudades){
            System.out.println(ciudad);
        }
    }

    private void validarDescripcion(String descripcion){
        if(descripcion == null || descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripción de la ciudad no puede estar vacía.");
        }
    }
}
