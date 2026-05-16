package MODULO_2.Desafio.Ejercicio_1;

public class Usuario {
    private String correoElectrónico;
    private String clave;

    public Usuario(String correo, String clave){
        this.correoElectrónico = correo;
        this.clave = clave;
    }

    public void imprimirUsuario(){
        System.out.printf("Usuario [correo: %s, clave: %s]",correoElectrónico, clave);
    }
}
