package MODULO_6.Desafio.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InicializadorBD.crearBaseYTablas();

        Scanner scanner = new Scanner(System.in);

        PaisDAO paisDAO = new PaisDAO();
        CiudadDAO ciudadDAO = new CiudadDAO();
        CargadorDatosPrueba cargadorDatosPrueba = new CargadorDatosPrueba(paisDAO, ciudadDAO);

        int opcion;

        do{
            mostrarMenu();
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1 -> cargadorDatosPrueba.cargarPaisesYCiudades();
                case 2 -> buscarCiudades(scanner, ciudadDAO);
                case 3 -> buscarCiudadesArgentinas(scanner, ciudadDAO);
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu(){
        System.out.println();
        System.out.println("===== MENÚ =====");
        System.out.println("1. Cargar 50 países y 50 ciudades de prueba");
        System.out.println("2. Buscar ciudades por coincidencia");
        System.out.println("3. Buscar ciudades argentinas por coincidencia");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static int leerOpcion(Scanner scanner){
        try{
            return Integer.parseInt(scanner.nextLine().trim());
        }
        catch(NumberFormatException e){
            return -1;
        }
    }

    private static void buscarCiudades(Scanner scanner, CiudadDAO ciudadDAO){
        System.out.print("Ingrese una palabra para buscar ciudades: ");
        String palabra = scanner.nextLine();
        ciudadDAO.mostrarCiudadesPorCoincidencia(palabra);
    }

    private static void buscarCiudadesArgentinas(Scanner scanner, CiudadDAO ciudadDAO){
        System.out.print("Ingrese una palabra para buscar ciudades argentinas: ");
        String palabra = scanner.nextLine();
        ciudadDAO.mostrarCiudadesArgentinasPorCoincidencia(palabra);
    }
}

