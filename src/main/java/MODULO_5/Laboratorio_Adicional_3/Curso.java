package MODULO_5.Laboratorio_Adicional_3;

public final class Curso{
    private final int id;
    private final String nombre;

    public Curso(int id, String nombre){
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
        }

        this.id = id;
        this.nombre = nombre.trim();
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return String.format("ID: %d - Curso: %s", id, nombre);
    }
}
