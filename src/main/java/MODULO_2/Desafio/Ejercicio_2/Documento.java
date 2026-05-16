package MODULO_2.Desafio.Ejercicio_2;

public class Documento{
    private String tipoDocumento;
    private String numeroDocumento;

    public Documento(String tipoDocumento, String numeroDocumento){
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public String informacionDocumento(){
        return "Documento [tipo: " + tipoDocumento + ", numero: " + numeroDocumento + "]";
    }

    public String getTipoDocumento(){
        return tipoDocumento;
    }

    public String getNumeroDocumento(){
        return numeroDocumento;
    }
}
