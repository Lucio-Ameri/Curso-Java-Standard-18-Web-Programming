package MODULO_6.Laboratorio_Adicional_1;

import java.util.Objects;

public final class Documento implements Comparable<Documento>{
    private String tipoDocumento;
    private String numeroDocumento;

    public Documento(String tipo, String numero) throws DocumentoInvalidoException{
        if(!esTipoDocumentoValido(tipo)){
            throw new DocumentoInvalidoException(tipo);
        }

        this.tipoDocumento = tipo.toUpperCase();
        this.numeroDocumento = numero == null ? "" : numero.trim();
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

    public String getDescripcionTipo(){
        switch(tipoDocumento){
            case "DNI":
                return "Documento nacional de identidad";
            case "PAS":
                return "Pasaporte";
            case "LE":
                return "Libreta de enrolamiento";
            case "CI":
                return "Cédula de identidad";
            default:
                return "Tipo de documento desconocido";
        }
    }

    @Override
    public int compareTo(Documento otroDocumento){
        Objects.requireNonNull(otroDocumento, "El documento a comparar no puede ser null.");

        int comparacionTipo = tipoDocumento.compareTo(otroDocumento.tipoDocumento);

        if(comparacionTipo != 0){
            return comparacionTipo;
        }

        return numeroDocumento.compareTo(otroDocumento.numeroDocumento);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Documento)){
            return false;
        }

        Documento otroDocumento = (Documento) obj;

        return tipoDocumento.equals(otroDocumento.tipoDocumento) && numeroDocumento.equals(otroDocumento.numeroDocumento);
    }

    @Override
    public int hashCode(){
        return Objects.hash(tipoDocumento, numeroDocumento);
    }

    @Override
    public String toString(){
        return String.format("DOCUMENTO [Tipo: %s = %s.  Numero: %s]. ", tipoDocumento, getDescripcionTipo(), numeroDocumento);
    }
}
