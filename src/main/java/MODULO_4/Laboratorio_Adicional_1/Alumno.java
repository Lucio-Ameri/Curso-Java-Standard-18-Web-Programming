package MODULO_4.Laboratorio_Adicional_1;

import java.time.LocalDate;
import java.util.List;

public class Alumno extends Persona {
    private LocalDate fechaIngreso;
    private List<Curso> cursosQueCursa;
    private static final String tipoPersona = "ALUMNO";

    public Alumno(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaIngreso, List<Curso> cursos){
        super(nombre, apellido, documento, fechaNacimiento);

        this.fechaIngreso = fechaIngreso;
        this.cursosQueCursa = cursos;
    }

    public LocalDate getFechaIngreso(){
        return fechaIngreso;
    }

    public List<Curso> getCursos(){
        return cursosQueCursa;
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
        return String.format("Persona: %s  [%s Fecha De Ingreso: %s.  Cursos Inscriptos: %s] ", tipoPersona, super.toString(), fechaIngreso.toString(), cursosQueCursa.toString());
    }
}
