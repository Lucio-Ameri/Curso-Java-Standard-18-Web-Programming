package MODULO_4.Laboratorio_Adicional_2;

public class DocumentoInvalidoException extends Exception{

    public DocumentoInvalidoException(String tipoDocumento) {
        super("Tipo de documento inválido: " + tipoDocumento + ". Solo son válidos los documentos: DNI, PAS, LE, CI.");
    }
}
