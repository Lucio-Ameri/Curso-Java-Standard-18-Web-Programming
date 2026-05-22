package MODULO_3.Desafio.Ejercicio_1;

import java.util.List;

public final class OfertaUtil{

    private OfertaUtil(){
        throw new UnsupportedOperationException("Esta clase no se puede instanciar.");
    }

    public static void imprimirOfertas(Cliente cliente, List<Producto> productos){
        if(cliente == null || productos == null){
            return;
        }

        System.out.println("Hola " + cliente.getNombre() + ":");
        System.out.println("Esta semana tenemos las siguientes ofertas para ti:");

        productos.forEach(producto -> {
            if (producto instanceof Perecedero perecedero && perecedero.estaEnOferta()){
                System.out.printf("- %s Antes: %.2f Después: %.2f%n", perecedero.getDescripción(), perecedero.getPrecio(), perecedero.getPrecioOferta());
            }
        });
    }
}
