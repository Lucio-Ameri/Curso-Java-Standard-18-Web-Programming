package MODULO_6.Laboratorio_Adicional_2;

import java.time.LocalDate;

public class Director extends Empleado {
    private String carrera;
    private static final String tipoPersona = "DIRECTOR";

    public Director(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo, Double sueldo, String carrera){
        super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);

        this.carrera = carrera;
    }

    public String getCarrera(){
        return carrera;
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
        return String.format("Persona: %s.  [%s Carrera: %s.]", tipoPersona, super.toString(), carrera);
    }
}
