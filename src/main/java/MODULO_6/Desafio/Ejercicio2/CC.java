package MODULO_6.Desafio.Ejercicio2;

public class CC extends Producto {

    public CC(int banco, int sucursal) {
        super(banco, sucursal);
    }

    @Override
    public String getNumeroProductoFormateado() {
        return formatearNumeroProducto("###-#-#####/#");
    }

    @Override
    public String toString() {
        return String.format("CC (Cuenta Corriente) [%s]", super.toString());
    }
}
