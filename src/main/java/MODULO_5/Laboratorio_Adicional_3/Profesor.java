package MODULO_5.Laboratorio_Adicional_3;

import java.time.LocalDate;
import java.util.List;

public class Profesor extends Empleado {
    private List<Integer> idsCursosQueDicta;
    private static final String tipoPersona = "PROFESOR";

    public Profesor(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo, Double sueldo, List<Integer> idsCursos){
        super(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);

        this.idsCursosQueDicta = idsCursos;
    }

    public List<Integer> getIdsCursosQueDicta(){
        return idsCursosQueDicta;
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
        return String.format("Persona: %s.  [%s  IDs Cursos que Dicta: %s]", tipoPersona, super.toString(), idsCursosQueDicta.toString());
    }
}
