package MODULO_6.Laboratorio_Adicional_1;

import java.time.LocalDate;

public class Administrativo extends Empleado{
    private static final String tipoPersona = "ADMINISTRATIVO";

    public Administrativo(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo, Double sueldo){
        super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);
    }

    @Override
    public void guardar(){
        System.out.printf("Guardando... %s", mostrarTipoPersona());
    }

    @Override
    public void borrar(){
        System.out.printf("Borrando... %s", mostrarTipoPersona());
    }

    @Override
    public void modificar(){
        System.out.printf("Modificando... %s", mostrarTipoPersona());
    }

    @Override
    public String mostrarTipoPersona(){
        return String.format("Tipo Persona: %s.  %s", tipoPersona, super.mostrarNombreCompleto());
    }

    @Override
    public String toString(){
        return String.format("Persona: %s.  [%s]", tipoPersona, super.toString());
    }
}
