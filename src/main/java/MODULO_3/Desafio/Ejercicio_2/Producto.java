package MODULO_3.Desafio.Ejercicio_2;

public abstract class Producto {
    private static long contadorProducto = 0;

    private final long ID;
    private int banco;
    private int sucursal;

    public Producto(int banco, int sucursal){
        this.ID = generarNuevoProducto();
        this.banco = banco;
        this.sucursal = sucursal;
    }

    private static long generarNuevoProducto(){
        contadorProducto++;
        return contadorProducto;
    }

    public long getID() {
        return ID;
    }

    public int getBanco() {
        return banco;
    }

    public int getSucursal() {
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
    public String toString(){
        return String.format("Banco: %d. Sucursal: %d Número de Producto: %s",banco, sucursal, getNumeroProductoFormateado());
    }
}
