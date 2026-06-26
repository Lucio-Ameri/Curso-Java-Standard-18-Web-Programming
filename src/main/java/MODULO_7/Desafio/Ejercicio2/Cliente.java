package MODULO_7.Desafio.Ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente{
    private final String tipoDocumento;
    private final String numeroDocumento;
    private final String descripcion;
    private final LocalDate fechaNacimiento;
    private final List<Producto> productos;

    public Cliente(String tipoDocumento, String numeroDocumento, String descripcion, LocalDate fechaNacimiento){
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.descripcion = descripcion;
        this.fechaNacimiento = fechaNacimiento;
        this.productos = new ArrayList<>();
    }

    public String getTipoDocumento(){
        return tipoDocumento;
    }

    public String getNumeroDocumento(){
        return numeroDocumento;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
        Collections.sort(productos);
    }

    public List<Producto> getProductos(){
        List<Producto> copiaProductos = new ArrayList<>(productos);
        Collections.sort(copiaProductos);
        return copiaProductos;
    }

    public String getClave(){
        return generarClave(tipoDocumento, numeroDocumento);
    }

    public static String generarClave(String tipoDocumento, String numeroDocumento){
        return tipoDocumento.trim().toUpperCase() + "-" + numeroDocumento.trim();
    }

    @Override
    public String toString(){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();

        sb.append("Cliente encontrado\n");
        sb.append("-------------------\n");
        sb.append("Tipo de documento: ").append(tipoDocumento).append("\n");
        sb.append("Número de documento: ").append(numeroDocumento).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Fecha de nacimiento: ").append(fechaNacimiento.format(formatoFecha)).append("\n");
        sb.append("Productos:\n");

        if(productos.isEmpty()){
            sb.append("Sin productos asignados\n");
        }
        else{
            for(Producto producto : getProductos()){
                sb.append("- ").append(producto).append("\n");
            }
        }

        return sb.toString();
    }
}
