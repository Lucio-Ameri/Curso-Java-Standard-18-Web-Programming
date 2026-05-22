package MODULO_3.Desafio.Ejercicio_1;

public class Cliente implements Entidad{
    private static long contadorClientes = 0;

    private final long ID;
    private String nombre;
    private String apellido;
    private Documento documento;

    public Cliente(String nombre, String apellido, String tipoDocumento, String numeroDocumento){
        this.ID = generarID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = new Documento(tipoDocumento, numeroDocumento);
    }

    private static long generarID(){
        contadorClientes++;
        return contadorClientes;
    }

    @Override
    public long getID(){
        return ID;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public Documento getDocumento(){
        return documento;
    }
    @Override
    public String toString(){
        return String.format("Cliente [ID: %d, Nombre: %s, Apellido: %s, Documento: %s]", ID, nombre, apellido, documento);
    }
}
