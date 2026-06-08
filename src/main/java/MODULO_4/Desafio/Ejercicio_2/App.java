package MODULO_4.Desafio.Ejercicio_2;

public class App{
    public static void main(String[] args){
        probarCreacionProducto("CA", 123, 45);
        probarCreacionProducto("CC", 123, 46);
        probarCreacionProducto("FCI", 123, 47);
        probarCreacionProducto("PF", 123, 48);
        probarCreacionProducto("TC", 123, 49);
    }

    private static void probarCreacionProducto(String tipoProducto, int banco, int sucursal){
        try{
            Producto producto = Fabrica.crearProducto(tipoProducto, banco, sucursal);
            System.out.println(producto);

        }
        catch(ProductoException e){
            System.out.println("Error al asignar producto " + tipoProducto + ": " + e.getMessage());
        }
    }
}
