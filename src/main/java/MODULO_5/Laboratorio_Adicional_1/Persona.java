package MODULO_5.Laboratorio_Adicional_1;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Persona implements ABM, Comparable<Persona>{
    private static int contadorID = 0;
    private static int contadorPersona = 0;

    private int ID;
    private String nombre;
    private String apellido;
    private Documento documento;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento) {
        this.ID = generarNuevoID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;

        contadorPersona++;
    }

    private static int generarNuevoID(){
        contadorID++;
        return contadorID;
    }

    public static int getContadorPersonas(){
        return contadorPersona;
    }

    protected int getId(){
        return ID;
    }

    protected String getNombre(){
        return nombre;
    }

    protected String getApellido(){
        return apellido;
    }

    protected Documento getDocumento(){
        return documento;
    }

    protected LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    protected String mostrarNombreCompleto(){
        return String.format("[Nombre: %s.  Apellido: %s.]", nombre, apellido);
    }

    @Override
    public int compareTo(Persona otraPersona){
        Objects.requireNonNull(otraPersona, "La persona a comparar no puede ser null.");

        return documento.compareTo(otraPersona.documento);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Persona)){
            return false;
        }

        Persona otraPersona = (Persona) obj;

        return documento.equals(otraPersona.documento);
    }

    @Override
    public int hashCode(){
        return Objects.hash(documento);
    }

    @Override
    public String toString(){
        return String.format("[ID: %s.  Nombre: %s.  Apellido: %s.  %s Fecha de Nacimiento: %s.] ", ID, nombre, apellido, documento, fechaNacimiento.toString());
    }

    public abstract String mostrarTipoPersona();
}
