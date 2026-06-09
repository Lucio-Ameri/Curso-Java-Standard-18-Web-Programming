package MODULO_5.Desafio.Ejercicio_3;

public class Persona{

    private String documento;
    private String nombre;
    private String apellido;
    private int edad;
    private int ordenLlegada;

    public Persona(String documento, String nombre, String apellido, int edad){
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getDocumento(){
        return documento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public int getEdad(){
        return edad;
    }

    public int getOrdenLlegada(){
        return ordenLlegada;
    }

    public void setOrdenLlegada(int ordenLlegada){
        this.ordenLlegada = ordenLlegada;
    }

    public boolean esPrioritaria(){
        return edad > 55;
    }

    @Override
    public String toString(){
        return "Documento: " + documento + " | Nombre: " + nombre + " " + apellido + " | Edad: " + edad + " | Orden de llegada: " + ordenLlegada;
    }
}
