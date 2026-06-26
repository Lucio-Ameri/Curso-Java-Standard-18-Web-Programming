package MODULO_7.Desafio.Ejercicio2;

public class ProductoException extends Exception{
    private final CodigoErrorProducto error;
    private final String claseAfectada;
    private final String productoAfectado;

    public ProductoException(CodigoErrorProducto error){
        this(error, "No informada", "No informado");
    }

    public ProductoException(CodigoErrorProducto error, String claseAfectada, String productoAfectado){
        super(error.getDescripcion());
        this.error = error;
        this.claseAfectada = claseAfectada;
        this.productoAfectado = productoAfectado;
    }

    public int getCodigoError(){
        return error.getCodigo();
    }

    public CodigoErrorProducto getError(){
        return error;
    }

    public String getClaseAfectada(){
        return claseAfectada;
    }

    public String getProductoAfectado(){
        return productoAfectado;
    }
}
