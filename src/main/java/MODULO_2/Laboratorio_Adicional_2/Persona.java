package MODULO_2.Laboratorio_Adicional_2;

public class Persona {
    private String nombre;
    private String apellido;
    private Documento documento;
    private int edad;

    public Persona(String nombre, String apellido, Documento documento, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
    }

    private boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public void imprimirDatos() {
        System.out.printf("Nombre: %s. Apellido: %s. %s. Edad: %d. Es Mayor?: %s.%n", this.nombre, this.apellido, this.documento, this.edad, this.esMayorDeEdad() ? "Sí" : "No");
    }
}
