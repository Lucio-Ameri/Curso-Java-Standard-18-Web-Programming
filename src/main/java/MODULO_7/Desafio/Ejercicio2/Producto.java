package MODULO_7.Desafio.Ejercicio2;

public abstract class Producto implements Comparable<Producto>{
    private static long contadorProducto = 0;

    private final long ID;
    private final int banco;
    private final int sucursal;

    public Producto(int banco, int sucursal){
        this.ID = generarNuevoProducto();
        this.banco = banco;
        this.sucursal = sucursal;
    }

    private static long generarNuevoProducto(){
        contadorProducto++;
        return contadorProducto;
    }

    public long getID(){
        return ID;
    }

    public int getBanco(){
        return banco;
    }

    public int getSucursal(){
        return sucursal;
    }

    protected String formatearNumeroProducto(String formato){
        String numero = String.valueOf(ID);
        StringBuilder resultado = new StringBuilder();

        int indiceNumero = 0;

        for(int i = 0; i < formato.length(); i++){
            char caracter = formato.charAt(i);

            if(caracter == '#'){
                if(indiceNumero < numero.length()){
                    resultado.append(numero.charAt(indiceNumero));
                    indiceNumero++;
                }
                else{
                    resultado.append("0");
                }
            }
            else{
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    public abstract String getNumeroProductoFormateado();

    @Override
    public int compareTo(Producto otroProducto){
        int comparacionBanco = Integer.compare(this.banco, otroProducto.banco);

        if(comparacionBanco != 0){
            return comparacionBanco;
        }

        int comparacionSucursal = Integer.compare(this.sucursal, otroProducto.sucursal);

        if(comparacionSucursal != 0){
            return comparacionSucursal;
        }

        return Long.compare(this.ID, otroProducto.ID);
    }

    @Override
    public String toString(){
        return String.format("Banco: %d. Sucursal: %d. Número de Producto: %s", banco, sucursal, getNumeroProductoFormateado());
    }
}
