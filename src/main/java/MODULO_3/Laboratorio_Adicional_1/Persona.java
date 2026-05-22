package MODULO_3.Laboratorio_Adicional_1;

import java.util.Random;

public class Persona{
    private static int contadorID = 0;
    private static int contadorPersonas = 0;

    private int id;
    private String nombre;
    private String apellido;
    private Documento documento;
    private int edad;

    public Persona(){
    }

    public Persona(String nombre, String apellido, Documento documento){
        contadorID++;
        contadorPersonas++;

        this.id = contadorID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = generarEdadAleatoria();
    }

    public Persona(String nombre, String apellido, Documento documento, int edad){
        contadorID++;
        contadorPersonas++;

        this.id = contadorID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
    }

    private int generarEdadAleatoria(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public void mostrarAtributos(){
        System.out.printf("ID: %d. Nombre: %s. Apellido: %s. %s. Edad: %d. Es Mayor?: %s.%n", this.id, this.nombre, this.apellido, this.documento, this.edad, this.esMayorDeEdad() ? "Sí" : "No");
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public Documento getDocumento(){
        return documento;
    }

    public void setDocumento(Documento documento){
        this.documento = documento;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
}
