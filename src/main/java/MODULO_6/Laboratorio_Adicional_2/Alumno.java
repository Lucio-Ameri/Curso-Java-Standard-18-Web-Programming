package MODULO_6.Laboratorio_Adicional_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Alumno extends Persona {
    private LocalDate fechaIngreso;
    private List<Integer> idsCursosQueCursa;
    private static final String tipoPersona = "ALUMNO";

    public Alumno(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaIngreso, List<Integer> idsCursos){
        super(nombre, apellido, documento, fechaNacimiento);

        this.fechaIngreso = fechaIngreso;
        this.idsCursosQueCursa = idsCursos;
    }

    public LocalDate getFechaIngreso(){
        return fechaIngreso;
    }

    public List<Integer> getIdsCursos(){
        return idsCursosQueCursa;
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
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Persona: %s  [%s Fecha De Ingreso: %s.  IDs Cursos Inscriptos: %s] ", tipoPersona, super.toString(), fechaIngreso.format(formatoFecha), idsCursosQueCursa.toString());
    }
}
