package MODULO_7.Desafio.Ejercicio2;

public enum TipoProducto{
    CC("CC", "Cuenta Corriente", true),
    CA("CA", "Caja de Ahorro", true),
    PF("PF", "Plazo Fijo", false),
    FCI("FCI", "Fondo Común de Inversión", false);

    private final String codigo;
    private final String descripcion;
    private final boolean habilitado;

    TipoProducto(String codigo, String descripcion, boolean habilitado){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.habilitado = habilitado;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public boolean isHabilitado(){
        return habilitado;
    }

    public static TipoProducto buscarPorCodigo(String codigo){
        if(codigo == null){
            return null;
        }

        for(TipoProducto producto : TipoProducto.values()){
            if (producto.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return producto;
            }
        }

        return null;
    }

    @Override
    public String toString(){
        return codigo + " - " + descripcion;
    }
}
