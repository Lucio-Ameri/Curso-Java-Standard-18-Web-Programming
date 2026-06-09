package MODULO_5.Desafio.Ejercicio_2;

public enum CodigoErrorProducto{
    PRODUCTO_NO_DISPONIBLE(1, "Producto no disponible"),
    PRODUCTO_INEXISTENTE(2, "Producto no existente");

    private final int codigo;
    private final String descripcion;

    CodigoErrorProducto(int codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString(){
        return codigo + " - " + descripcion;
    }
}
