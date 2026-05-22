package MODULO_3.Desafio.Ejercicio_1;

public class NoPerecedero extends Producto{

    public NoPerecedero(String descripcion, Double precio, Integer stock){
        super(descripcion, precio, stock);
    }

    @Override
    public Double getPrecioInventario(){
        if(!tienePrecioYStock()){
            return 0.0;
        }

        return getPrecio() * getStock();
    }

    @Override
    public String toString(){
        return String.format("Producto No Perecedero [%s]", super.toString());
    }
}
