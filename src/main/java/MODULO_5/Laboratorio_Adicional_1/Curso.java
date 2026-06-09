package MODULO_5.Laboratorio_Adicional_1;

public final class Curso{
    private String nombre;

    public Curso(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
