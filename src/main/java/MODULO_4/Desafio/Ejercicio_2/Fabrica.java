package MODULO_4.Desafio.Ejercicio_2;

public class Fabrica{

    public static Producto crearProducto(String tipoProducto, int banco, int sucursal) throws ProductoException{

        if(tipoProducto == null || tipoProducto.isBlank()){
            throw new ProductoException(2);
        }

        switch(tipoProducto.toUpperCase()){
            case "CA":
                return new CA(banco, sucursal);

            case "CC":
                return new CC(banco, sucursal);

            case "PF", "FCI":
                throw new ProductoException(1);

            default:
                throw new ProductoException(2);
        }
    }
}
