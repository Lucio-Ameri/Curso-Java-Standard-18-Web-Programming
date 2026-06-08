package MODULO_4.Laboratorio_Adicional_1;

import java.time.LocalDate;
import java.util.List;

public class Profesor extends Empleado {
    private List<Curso> cursosQueDicta;
    private static final String tipoPersona = "PROFESOR";

    public Profesor(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo, Double sueldo, List<Curso> cursos){
        super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);

        this.cursosQueDicta = cursos;
    }

    public List<Curso> getCursosQueDicta(){
        return cursosQueDicta;
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
        return String.format("Persona: %s.  [%s  Cursos que Dicta: %s]", tipoPersona, super.toString(), cursosQueDicta.toString());
    }
}
