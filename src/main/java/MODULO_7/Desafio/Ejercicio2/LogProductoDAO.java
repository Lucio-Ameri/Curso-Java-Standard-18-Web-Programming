package MODULO_7.Desafio.Ejercicio2;

import java.sql.*;

public class LogProductoDAO {
    private static final String INSERTAR_LOG = "INSERT INTO log_errores_product (fecha_hora, clase_afectada, producto_afectado, descripcion_error) VALUES (?, ?, ?, ?)";

    public int insertar(LogProducto log) throws SQLException{
        try(Connection conexion = ConexionBD.obtenerConexion();
            PreparedStatement ps = conexion.prepareStatement(INSERTAR_LOG, Statement.RETURN_GENERATED_KEYS)){

            ps.setTimestamp(1, Timestamp.valueOf(log.getFechaHora()));
            ps.setString(2, log.getClaseAfectada());
            ps.setString(3, log.getProductoAfectado());
            ps.setString(4, log.getDescripcionError());

            ps.executeUpdate();

            try(ResultSet clavesGeneradas = ps.getGeneratedKeys()){
                if(clavesGeneradas.next()){
                    int idInsertado = clavesGeneradas.getInt(1);
                    log.setId(idInsertado);
                    return idInsertado;
                }
            }
        }

        return -1;
    }
}
