package MODULO_5.Desafio.Ejercicio_2;

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
