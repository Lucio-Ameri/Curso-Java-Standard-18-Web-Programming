package MODULO_4.Laboratorio_Adicional_2;

public final class Documento {
    private String tipoDocumento;
    private String numeroDocumento;

    public Documento(String tipo, String numero) throws DocumentoInvalidoException {
        if(!esTipoDocumentoValido(tipo)) {
            throw new DocumentoInvalidoException(tipo);
        }

        this.tipoDocumento = tipo.toUpperCase();
        this.numeroDocumento = numero;
    }

    private boolean esTipoDocumentoValido(String tipo){
        if(tipo == null){
            return false;
        }

        String tipoNormalizado = tipo.toUpperCase();

        return tipoNormalizado.equals("DNI") || tipoNormalizado.equals("PAS") || tipoNormalizado.equals("LE") || tipoNormalizado.equals("CI");
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
