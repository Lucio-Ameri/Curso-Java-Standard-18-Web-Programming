package MODULO_8.Desafio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO{
    public boolean validarCredenciales(String usuario, String clave){

        String sql = "SELECT COUNT(*) AS cantidad FROM usuarios WHERE usuario = ? AND clave = ? ";

        try(Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)){

            ps.setString(1, usuario);
            ps.setString(2, clave);

            try(ResultSet rs = ps.executeQuery()){

                if(rs.next()){
                    int cantidad = rs.getInt("cantidad");
                    return cantidad > 0;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
