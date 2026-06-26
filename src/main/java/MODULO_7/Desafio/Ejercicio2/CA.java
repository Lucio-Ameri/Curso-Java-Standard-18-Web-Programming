package MODULO_7.Desafio.Ejercicio2;

public class CA extends Producto {

    public CA(int banco, int sucursal) {
        super(banco, sucursal);
    }

    @Override
    public String getNumeroProductoFormateado() {
        return formatearNumeroProducto("###-#-#####/#");
    }

    @Override
    public String toString() {
        return String.format("CA (Caja de Ahorro) [%s]", super.toString());
    }
}
