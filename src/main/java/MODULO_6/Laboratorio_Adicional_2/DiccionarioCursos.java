package MODULO_6.Laboratorio_Adicional_2;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class DiccionarioCursos{
    private int ultimoId;
    private Map<Integer, Curso> cursosPorId;
    private Map<String, Integer> idsPorNombre;

    public DiccionarioCursos(){
        this.ultimoId = 0;
        this.cursosPorId = new LinkedHashMap<>();
        this.idsPorNombre = new LinkedHashMap<>();
    }

    public Curso agregarCurso(String nombre){
        String nombreNormalizado = normalizarNombre(nombre);

        if(idsPorNombre.containsKey(nombreNormalizado)){
            int idExistente = idsPorNombre.get(nombreNormalizado);
            return cursosPorId.get(idExistente);
        }

        int nuevoId = generarNuevoId();
        Curso curso = new Curso(nuevoId, nombre);

        cursosPorId.put(nuevoId, curso);
        idsPorNombre.put(nombreNormalizado, nuevoId);

        return curso;
    }

    public Curso buscarPorNombre(String nombre){
        String nombreNormalizado = normalizarNombre(nombre);
        Integer idCurso = idsPorNombre.get(nombreNormalizado);

        if(idCurso == null){
            return null;
        }

        return cursosPorId.get(idCurso);
    }

    public Curso buscarPorId(int id){
        return cursosPorId.get(id);
    }

    public boolean existeCurso(String nombre){
        return buscarPorNombre(nombre) != null;
    }

    public Collection<Curso> getCursos(){
        return cursosPorId.values();
    }

    public int cantidadCursos(){
        return cursosPorId.size();
    }

    private int generarNuevoId(){
        ultimoId++;
        return ultimoId;
    }

    private String normalizarNombre(String nombre){
        if(nombre == null){
            return "";
        }

        return nombre.trim().toUpperCase(Locale.ROOT);
    }

    @Override
    public String toString(){
        return cursosPorId.values().toString();
    }
}
