package MODULO_5.Desafio.Ejercicio_1;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Tabla<String, String> documentos = new Tabla<>(new LinkedHashMap<>());
        Tabla<Integer, String> telefonos = new Tabla<>(new TreeMap<>());

        cargarDocumentos(scanner, documentos);

        System.out.println("\nDocumentos cargados:");
        documentos.mostrarTodos();

        cargarTelefonos(scanner, telefonos);

        System.out.println("\nTeléfonos cargados ordenados por código:");
        telefonos.mostrarTodos();

        scanner.close();
    }

    private static void cargarDocumentos(Scanner scanner, Tabla<String, String> documentos){
        String continuar;

        do{
            System.out.print("Ingrese el numero de documento: ");
            String tipo = scanner.nextLine();

            System.out.print("Ingrese la descripción del documento: ");
            String descripcion = scanner.nextLine();

            if(documentos.existe(tipo)){
                System.out.println("El documento está repetido.");
            }
            else{
                documentos.agregar(tipo, descripcion);
                System.out.println("El documento no estaba repetido. Se agregó correctamente.");
            }

            System.out.print("¿Desea seguir agregando documentos? S/N: ");
            continuar = scanner.nextLine();

        }
        while (continuar.equalsIgnoreCase("S"));
    }

    private static void cargarTelefonos(Scanner scanner, Tabla<Integer, String> telefonos){
        String continuar;

        do{
            int codigo = leerEntero(scanner, "Ingrese el código telefónico: ");

            System.out.print("Ingrese el país: ");
            String pais = scanner.nextLine();

            boolean agregado = telefonos.agregar(codigo, pais);

            if(agregado){
                System.out.println("Teléfono agregado correctamente.");
            }
            else{
                System.out.println("El código telefónico ya existe. No se agregó.");
            }

            System.out.print("¿Desea seguir agregando teléfonos? S/N: ");
            continuar = scanner.nextLine();

        }
        while (continuar.equalsIgnoreCase("S"));
    }

    private static int leerEntero(Scanner scanner, String mensaje){
        while(true){
            try{
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}
