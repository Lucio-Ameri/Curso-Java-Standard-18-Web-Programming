package MODULO_2.Desafio.Ejercicio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioPropuesto{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.print("Indique la cantidad de personas: ");
        int cantidadPersonas = teclado.nextInt();
        teclado.nextLine();

        List<Persona> listaDePersonas = new ArrayList<>();

        for(int i = 0; i < cantidadPersonas; i++){
            System.out.println("Persona [" + (i + 1) + "]");

            System.out.print("Indique el nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Indique el apellido: ");
            String apellido = teclado.nextLine();

            String tipoDocumento = null;
            String numeroDocumento = null;

            do {
                mostrarMenuDocumentos(nombre + " " + apellido);

                System.out.print("Tipo: ");
                int opcionDocumento = teclado.nextInt();
                teclado.nextLine();

                tipoDocumento = obtenerTipoDocumento(opcionDocumento);

                if(tipoDocumento == null){
                    System.out.println("Tipo de documento invalido. Intente nuevamente.");
                    continue;
                }

                System.out.print("Numero: ");
                numeroDocumento = teclado.nextLine();

                if(documentoRepetido(listaDePersonas, tipoDocumento, numeroDocumento)){
                    System.out.println("Ya existe una persona con ese tipo y numero de documento.");
                    tipoDocumento = null;
                }

            } while(tipoDocumento == null);

            listaDePersonas.add(new Persona(nombre, apellido, tipoDocumento, numeroDocumento));
        }

        System.out.println();
        System.out.println("Listado de personas cargadas:");

        for(Persona persona : listaDePersonas){
            persona.imprimirPersona();
        }
    }

    public static void mostrarMenuDocumentos(String nombreCompleto){
        System.out.println("\nDocumentos de " + nombreCompleto + ":");
        System.out.println("1-Documento Nacional de Identidad -DNI");
        System.out.println("2-Libreta Civica -LC");
        System.out.println("3-Libreta de Enrolamiento -LE");
        System.out.println("4-Pasaporte -PA");
        System.out.println("5-Cedula de Identidad -CI");
    }

    public static String obtenerTipoDocumento(int opcionDocumento){
        switch(opcionDocumento){
            case 1:
                return "DNI";
            case 2:
                return "LC";
            case 3:
                return "LE";
            case 4:
                return "PA";
            case 5:
                return "CI";
            default:
                return null;
        }
    }

    public static boolean documentoRepetido(List<Persona> listaDePersonas, String tipoDocumento, String numeroDocumento){
        for(Persona persona : listaDePersonas){
            if (persona.mismoDocumento(tipoDocumento, numeroDocumento)){
                return true;
            }
        }
        return false;
    }
}