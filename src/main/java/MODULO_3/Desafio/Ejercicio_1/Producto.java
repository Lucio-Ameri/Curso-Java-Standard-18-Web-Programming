package MODULO_3.Desafio.Ejercicio_1;

public abstract class Producto implements Entidad{

    private static long contadorProductos = 0;

    private final long ID;
    private String descripción;
    private Double precio;
    private Integer stock;

    public Producto(String descripción, Double precio, Integer stock){
        this.ID = generarId();
        this.descripción = descripción;
        this.precio = precio;
        this.stock = stock;
    }

    private static long generarId(){
        contadorProductos++;
        return contadorProductos;
    }

    @Override
    public long getID(){
        return ID;
    }

    public String getDescripción(){
        return descripción;
    }

    public Double getPrecio(){
        return precio;
    }

    public Integer getStock(){
        return stock;
    }

    protected boolean tienePrecioYStock(){
        return precio != null && stock != null;
    }

    public abstract Double getPrecioInventario();

    @Override
    public String toString(){
        return String.format("ID: %d. Descripción: %s. Precio: %s. Stock: %s.", ID, descripción, precio, stock);
    }
}
