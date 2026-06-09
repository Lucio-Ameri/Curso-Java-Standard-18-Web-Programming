package MODULO_5.Desafio.Ejercicio_2;

public class Fabrica{

    public static Producto crearProducto(String codigoProducto, int banco, int sucursal) throws ProductoException{

        TipoProducto tipoProducto = TipoProducto.buscarPorCodigo(codigoProducto);

        if(tipoProducto == null){
            throw new ProductoException(CodigoErrorProducto.PRODUCTO_INEXISTENTE);
        }

        if(!tipoProducto.isHabilitado()){
            throw new ProductoException(CodigoErrorProducto.PRODUCTO_NO_DISPONIBLE);
        }

        switch(tipoProducto){
            case CA:
                return new CA(banco, sucursal);

            case CC:
                return new CC(banco, sucursal);

            default:
                throw new ProductoException(CodigoErrorProducto.PRODUCTO_INEXISTENTE);
        }
    }
}
