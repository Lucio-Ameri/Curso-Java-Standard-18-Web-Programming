package MODULO_3.Laboratorio_Adicional_4;

public final class Documento{
    private String tipoDocumento;
    private String numeroDocumento;

    public Documento(String tipo, String numero){
        this.tipoDocumento = tipo;
        this.numeroDocumento = numero;
    }

    public String getTipo(){
        return tipoDocumento;
    }

    public String getNumero(){
        return numeroDocumento;
    }

    @Override
    public String toString(){
        return String.format("DOCUMENTO [Tipo: %s.  Numero: %s]. ", tipoDocumento, numeroDocumento);
    }
}
