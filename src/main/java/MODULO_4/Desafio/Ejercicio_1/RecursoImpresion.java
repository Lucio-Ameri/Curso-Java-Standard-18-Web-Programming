package MODULO_4.Desafio.Ejercicio_1;

public class RecursoImpresion implements AutoCloseable{
    private String impresora;

    public RecursoImpresion(String impresora){
        this.impresora = impresora;
        System.out.println("Recurso abierto para la impresora: " + impresora);
    }

    public void imprimirLinea(String linea){
        System.out.println(linea);
    }

    @Override
    public void close(){
        System.out.println("Recurso cerrado para la impresora: " + impresora);
    }
}
