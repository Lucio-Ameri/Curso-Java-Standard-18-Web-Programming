package MODULO_4.Desafio.Ejercicio_2;

public class ProductoException extends Exception{
    private final int codigoError;

    public ProductoException(int codigoError){
        super(obtenerMensajeError(codigoError));
        this.codigoError = codigoError;
    }

    public int getCodigoError(){
        return codigoError;
    }

    private static String obtenerMensajeError(int codigoError){
        switch(codigoError){
            case 1:
                return "Producto No disponible";
            case 2:
                return "Producto Inexistente";
            default:
                return "Código de error desconocido";
        }
    }
}
