package MODULO_3.Laboratorio_Adicional_2;

import java.util.List;

public class Alumno extends Persona{
    private List<Curso> cursos;

    public Alumno(Integer id, String nombre, String apellido, Documento documento, Integer edad, List<Curso> cursos){
        super(id, nombre, apellido, documento, edad);
        this.cursos = cursos;
    }

    public List<Curso> getCursos(){
        return cursos;
    }

    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(". Cursos: %s", cursos);
    }
}
