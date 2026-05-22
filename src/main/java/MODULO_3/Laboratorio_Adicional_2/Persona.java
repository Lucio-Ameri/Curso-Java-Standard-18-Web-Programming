package MODULO_3.Laboratorio_Adicional_2;

import java.util.Random;

public class Persona{
    private static Integer contadorID = 0;
    private static Integer contadorPersonas = 0;

    private Integer id;
    private String nombre;
    private String apellido;
    private Documento documento;
    private Integer edad;

    public Persona(Integer id, String nombre, String apellido, Documento documento, Integer edad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;

        contadorPersonas++;
    }

    public static Integer generarNuevoID(){
        contadorID++;
        return contadorID;
    }

    public static Integer getContadorPersonas(){
        return contadorPersonas;
    }

    public Boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public Integer getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public Documento getDocumento(){
        return documento;
    }

    public Integer getEdad(){
        return edad;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setDocumento(Documento documento){
        this.documento = documento;
    }

    public void setEdad(Integer edad){
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("ID: %d. Nombre: %s. Apellido: %s. %s. Edad: %d. Es mayor de edad?: %s", id, nombre, apellido, documento, edad, esMayorDeEdad() ? "Sí" : "No");
    }
}
