package MODULO_9.Laboratorio_Adicional_1;

public class Usuario{

    private String correo;
    private String clave;

    public Usuario(String correo, String clave){
        this.correo = correo;
        this.clave = clave;
    }

    public String getCorreo(){
        return correo;
    }

    public String getClave(){
        return clave;
    }
}
