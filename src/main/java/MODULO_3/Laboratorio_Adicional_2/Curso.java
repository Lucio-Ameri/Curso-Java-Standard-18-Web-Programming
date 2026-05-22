package MODULO_3.Laboratorio_Adicional_2;

public class Curso{
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
