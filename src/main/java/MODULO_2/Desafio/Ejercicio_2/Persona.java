package MODULO_2.Desafio.Ejercicio_2;

public class Persona {
    String nombre;
    String apellido;
    Documento documento;

    public Persona(String nombre, String apellido, String tipoDocumento, String numeroDocumento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = new Documento(tipoDocumento, numeroDocumento);
    }

    public void imprimirPersona(){
        System.out.printf("\nPersona  [nombre: %s, apellido: %s, %s]", nombre, apellido, documento.informacionDocumento());
    }

    public boolean mismoDocumento(String tipoDocumento, String numeroDocumento){
        return ((documento.getTipoDocumento().equals(tipoDocumento)) && (documento.getNumeroDocumento().equals(numeroDocumento)));
    }
}
