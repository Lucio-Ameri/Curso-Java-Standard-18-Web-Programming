package MODULO_6.Desafio.Ejercicio1;

public class Ciudad{
    private static Long creadorId = 0L;

    private final Long id;
    private Pais pais;
    private String descripcion;

    public Ciudad(Pais pais, String descripcion){
        this.id = generarId();
        this.pais = pais;
        this.descripcion = descripcion;
    }

    public Ciudad(Long id, Pais pais, String descripcion){
        this.id = generarId();
        this.pais = pais;
        this.descripcion = descripcion;
    }

    private static Long generarId(){
        creadorId ++;
        return creadorId;
    }

    public Long getId(){
        return id;
    }

    public Pais getPais(){
        return pais;
    }

    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString(){
        return "Ciudad{" + "id=" + id + ", pais=" + pais + ", descripcion='" + descripcion + '\'' + '}';
    }
}
