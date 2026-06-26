package MODULO_7.Desafio.Ejercicio2;

import java.io.IOException;
import java.sql.SQLException;

public class Fabrica{
    private static final LogProductoDAO logProductoDAO = new LogProductoDAO();
    private static final LogProductoArchivo logProductoArchivo = new LogProductoArchivo();

    public static Producto crearProducto(String codigoProducto, int banco, int sucursal) throws ProductoException {
        TipoProducto tipoProducto = TipoProducto.buscarPorCodigo(codigoProducto);

        if(tipoProducto == null){
            lanzarErrorYRegistrarLog(CodigoErrorProducto.PRODUCTO_INEXISTENTE, codigoProducto);
        }

        if(!tipoProducto.isHabilitado()){
            lanzarErrorYRegistrarLog(CodigoErrorProducto.PRODUCTO_NO_DISPONIBLE, tipoProducto.getCodigo());
        }

        switch(tipoProducto){
            case CA:
                return new CA(banco, sucursal);

            case CC:
                return new CC(banco, sucursal);

            default:
                lanzarErrorYRegistrarLog(CodigoErrorProducto.PRODUCTO_INEXISTENTE, tipoProducto.getCodigo());
                return null;
        }
    }

    private static void lanzarErrorYRegistrarLog(CodigoErrorProducto error, String productoAfectado) throws ProductoException {
        String claseAfectada = Fabrica.class.getSimpleName();
        String producto = normalizarProductoAfectado(productoAfectado);

        LogProducto log = new LogProducto(claseAfectada, producto, error.getDescripcion());

        int idInsertado = registrarLogEnBaseDeDatos(log);
        registrarLogEnArchivo(log, idInsertado);

        throw new ProductoException(error, claseAfectada, producto);
    }

    private static int registrarLogEnBaseDeDatos(LogProducto log){
        try{
            int idInsertado = logProductoDAO.insertar(log);
            System.out.println("Log insertado en BD con id: " + idInsertado);
            return idInsertado;
        }
        catch(SQLException e){
            System.out.println("No se pudo insertar el log en la BD: " + e.getMessage());
            return -1;
        }
    }

    private static void registrarLogEnArchivo(LogProducto log, int idInsertado){
        try{
            logProductoArchivo.guardar(log, idInsertado);
            System.out.println("Log guardado en el archivo logs.txt");
        }
        catch(IOException e){
            System.out.println("No se pudo guardar el log en el archivo: " + e.getMessage());
        }
    }

    private static String normalizarProductoAfectado(String productoAfectado){
        if(productoAfectado == null || productoAfectado.trim().isEmpty()){
            return "Sin código";
        }

        return productoAfectado.trim().toUpperCase();
    }
}
