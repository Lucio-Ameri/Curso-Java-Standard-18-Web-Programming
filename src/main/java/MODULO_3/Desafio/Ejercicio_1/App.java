package MODULO_3.Desafio.Ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args){

        Cliente cliente = new Cliente("Octavio", "Gomez", "DNI", "12345678");

        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Leche", 100.0, 5, 3));
        productos.add(new Perecedero("Queso", 200.0, 2, 8));
        productos.add(new Perecedero("Yogur", 80.0, 10, 15));
        productos.add(new NoPerecedero("Arroz", 150.0, 4));
        productos.add(new NoPerecedero("Fideos", 120.0, 6));

        System.out.println(cliente);

        productos.forEach(producto -> {
            System.out.println(producto);
            System.out.println("Precio inventario: " + producto.getPrecioInventario());
            System.out.println();
        });

        OfertaUtil.imprimirOfertas(cliente, productos);
    }
}
