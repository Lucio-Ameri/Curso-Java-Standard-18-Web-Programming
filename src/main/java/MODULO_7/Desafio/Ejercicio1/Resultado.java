package MODULO_7.Desafio.Ejercicio1;

import java.util.List;

public class Resultado{
    private boolean existe;
    private List<Ubicacion> ubicaciones;
    private String contenidoModificado;

    public Resultado(boolean existe, List<Ubicacion> ubicaciones, String contenidoModificado){
        this.existe = existe;
        this.ubicaciones = ubicaciones;
        this.contenidoModificado = contenidoModificado;
    }

    public boolean existe(){
        return existe;
    }

    public List<Ubicacion> getUbicaciones(){
        return ubicaciones;
    }

    public String getContenidoModificado(){
        return contenidoModificado;
    }
}
