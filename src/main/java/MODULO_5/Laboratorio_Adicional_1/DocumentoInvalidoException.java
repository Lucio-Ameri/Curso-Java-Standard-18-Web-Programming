package MODULO_5.Laboratorio_Adicional_1;

public class DocumentoInvalidoException extends Exception{

    public DocumentoInvalidoException(String tipoDocumento) {
        super("Tipo de documento inválido: " + tipoDocumento + ". Solo son válidos: DNI = Documento nacional de identidad, " + "PAS = Pasaporte, LE = Libreta de enrolamiento, CI = Cédula de identidad.");
    }
}
