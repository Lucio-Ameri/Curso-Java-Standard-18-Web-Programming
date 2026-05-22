package MODULO_3.Desafio.Ejercicio_1;

public class Perecedero extends Producto{

    private Integer diasParaVencer;

    public Perecedero(String descripcion, Double precio, Integer stock, Integer diasParaVencer){
        super(descripcion, precio, stock);
        this.diasParaVencer = diasParaVencer;
    }

    public Integer getDiasParaVencer(){
        return diasParaVencer;
    }

    public boolean estaEnOferta(){
        return diasParaVencer != null && diasParaVencer >= 0 && diasParaVencer < 10;
    }

    public Double getPrecioOferta(){
        if(getPrecio() == null){
            return 0.0;
        }

        if(estaEnOferta()){
            return getPrecio() * 0.70;
        }

        return getPrecio();
    }

    @Override
    public Double getPrecioInventario(){
        if(!tienePrecioYStock()){
            return 0.0;
        }

        if(estaEnOferta()){
            return getPrecioOferta() * getStock();
        }

        return getPrecio() * getStock();
    }

    @Override
    public String toString(){
        return String.format("Producto Perecedero [%s Dias para Vencer: %s]", super.toString(), diasParaVencer);
    }
}
