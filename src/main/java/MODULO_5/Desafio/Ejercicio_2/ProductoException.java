package MODULO_5.Desafio.Ejercicio_2;

public class ProductoException extends Exception{
    private final CodigoErrorProducto error;

    public ProductoException(CodigoErrorProducto error){
        super(error.getDescripcion());
        this.error = error;
    }

    public int getCodigoError(){
        return error.getCodigo();
    }

    public CodigoErrorProducto getError(){
        return error;
    }
}
