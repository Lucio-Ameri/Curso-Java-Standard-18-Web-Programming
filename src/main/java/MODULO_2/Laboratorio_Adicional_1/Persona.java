package MODULO_2.Laboratorio_Adicional_1;

public class Persona{
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private int edad;

    public Persona(String nombre, String apellido, String tipoDocumento, String numeroDocumento, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.edad = edad;
    }

    private boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public void imprimirDatos(){
        System.out.printf("Nombre: %s. Apellido: %s. Tipo Documento: %s. Número Documento: %s. Edad: %d. Es mayor?: %s.%n", nombre, apellido, tipoDocumento, numeroDocumento, edad, esMayorDeEdad() ? "Sí" : "No");
    }
}
