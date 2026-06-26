package MODULO_7.Desafio.Ejercicio2;

import java.time.LocalDateTime;

public class LogProducto{
    private int id;
    private final LocalDateTime fechaHora;
    private final String claseAfectada;
    private final String productoAfectado;
    private final String descripcionError;

    public LogProducto(String claseAfectada, String productoAfectado, String descripcionError){
        this.fechaHora = LocalDateTime.now();
        this.claseAfectada = claseAfectada;
        this.productoAfectado = productoAfectado;
        this.descripcionError = descripcionError;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public LocalDateTime getFechaHora(){
        return fechaHora;
    }

    public String getClaseAfectada(){
        return claseAfectada;
    }

    public String getProductoAfectado(){
        return productoAfectado;
    }

    public String getDescripcionError(){
        return descripcionError;
    }
}
