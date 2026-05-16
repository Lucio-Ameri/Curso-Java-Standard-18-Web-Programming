package MODULO_2.Laboratorio_Adicional_4;

public class Documento{
    private String tipo;
    private String numero;

    public Documento(String tipo, String numero){
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo(){
        return tipo;
    }

    public String getNumero(){
        return numero;
    }

    @Override
    public String toString(){
        return String.format("Tipo Documento: %s. Numero Documento: %s", tipo, numero);
    }
}
