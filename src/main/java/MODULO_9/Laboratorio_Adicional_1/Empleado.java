package MODULO_9.Laboratorio_Adicional_1;

public class Empleado{

    private int id;
    private String nombre;
    private String cargo;
    private String area;

    public Empleado(int id, String nombre, String cargo, String area){
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.area = area;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCargo(){
        return cargo;
    }

    public String getArea(){
        return area;
    }
}
