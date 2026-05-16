package MODULO_2.Laboratorio_Adicional_3;

import java.util.Random;

public class Persona{
    public String nombre;
    public String apellido;
    public Documento documento;
    private int edad;

    public Persona(String nombre, String apellido, Documento documento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = generarEdadAleatoria();
    }

    private int generarEdadAleatoria(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public void imprimirDatos(){
        System.out.printf("Nombre: %s. Apellido: %s. %s. Edad: %d. Es Mayor?: %s.%n", this.nombre, this.apellido, this.documento, this.edad, this.esMayorDeEdad() ? "Sí" : "No");
    }
}
