package MODULO_5.Desafio.Ejercicio_2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App{
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args){
        Map<String, Cliente> clientes = crearMapaClientes();

        mostrarProductos();
        mostrarCodigosDeError();

        buscarCliente(clientes);
    }

    private static Map<String, Cliente> crearMapaClientes(){
        Map<String, Cliente> clientes = new HashMap<>();

        try{
            Cliente cliente1 = new Cliente("DNI", "12345678", "Cliente con cuenta corriente y caja de ahorro", LocalDate.of(2000, 5, 15));
            cliente1.agregarProducto(Fabrica.crearProducto("CA", 123, 46));
            cliente1.agregarProducto(Fabrica.crearProducto("CC", 123, 45));
            cliente1.agregarProducto(Fabrica.crearProducto("CA", 100, 20));

            agregarClienteAlMapa(clientes, cliente1);

            Cliente cliente2 = new Cliente("DNI", "87654321", "Cliente con caja de ahorro", LocalDate.of(1998, 10, 3));
            cliente2.agregarProducto(Fabrica.crearProducto("CA", 200, 10));
            agregarClienteAlMapa(clientes, cliente2);

        } catch(ProductoException e){
            System.out.println("Error al crear datos iniciales: " + e.getMessage());
        }

        return clientes;
    }

    private static void agregarClienteAlMapa(Map<String, Cliente> clientes, Cliente cliente){
        clientes.put(cliente.getClave(), cliente);
    }

    private static void buscarCliente(Map<String, Cliente> clientes){
        System.out.println("\nBÚSQUEDA DE CLIENTE");
        System.out.println("-------------------");

        System.out.print("Ingrese tipo de documento: ");
        String tipoDocumento = teclado.nextLine();

        System.out.print("Ingrese número de documento: ");
        String numeroDocumento = teclado.nextLine();

        String clave = Cliente.generarClave(tipoDocumento, numeroDocumento);
        Cliente cliente = clientes.get(clave);

        if(cliente != null){
            System.out.println();
            System.out.println(cliente);
        }
        else{
            System.out.println("\nEl cliente no está en el sistema.");
        }
    }

    private static void mostrarProductos(){
        System.out.println("PRODUCTOS DISPONIBLES");
        System.out.println("---------------------");

        for (TipoProducto producto : TipoProducto.values()){
            if(producto.isHabilitado()){
                System.out.println(producto.getCodigo() + " - " + producto.getDescripcion());
            }
        }

        System.out.println("\nPRODUCTOS NO DISPONIBLES");
        System.out.println("------------------------");

        for(TipoProducto producto : TipoProducto.values()){
            if(!producto.isHabilitado()){
                System.out.println(producto.getCodigo() + " - " + producto.getDescripcion());
            }
        }
    }

    private static void mostrarCodigosDeError(){
        System.out.println("\nCÓDIGOS DE ERROR");
        System.out.println("----------------");

        for(CodigoErrorProducto error : CodigoErrorProducto.values()){
            System.out.println(error.getCodigo() + " - " + error.getDescripcion());
        }
    }
}