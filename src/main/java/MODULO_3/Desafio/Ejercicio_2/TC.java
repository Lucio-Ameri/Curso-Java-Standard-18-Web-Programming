package MODULO_3.Desafio.Ejercicio_2;

public class TC extends Producto{
    private final int códigodeSeguridad;

    public TC(int banco, int sucursal){
        super(banco, sucursal);
        this.códigodeSeguridad = (int) (Math.random() * 999) + 1;
    }

    @Override
    public String getNumeroProductoFormateado(){
        return formatearNumeroProducto("#### #### #### ####");
    }

    @Override
    public String toString(){
        return String.format("TC (Tarjeta de Crédito) [%s]", super.toString());
    }
}
