package MODULO_6.Desafio.Ejercicio1;

public class Pais {
    private static Long creadorId = 0L;

    private final Long id;
    private String descripcion;

    public Pais(String descripcion){
        this.id = generarId();
        this.descripcion =descripcion;
    }

    public Pais(Long id, String descripcion){
        this.id = generarId();
        this.descripcion =descripcion;
    }

    private static Long generarId(){
        creadorId ++;
        return creadorId;
    }

    public Long getId(){
        return id;
    }

    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString(){
        return "Pais{" + "id=" + id + ", descripcion='" + descripcion + '\'' + '}';
    }
}
