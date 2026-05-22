package MODULO_3.Laboratorio_Adicional_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioPropuesto{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        List<Persona> listaPersonas = new ArrayList<>();
        String seguirCargando = "1";

        do{
            System.out.print("Ingrese el Nombre de la Persona: ");
            String nombre = teclado.nextLine();

            System.out.print("Ingrese el Apellido de la Persona: ");
            String apellido = teclado.nextLine();

            System.out.print("Ingrese el Tipo de Documento de la Persona: ");
            String tipoDocumento = teclado.nextLine();

            System.out.print("Ingrese el Numero de Documento de la Persona: ");
            String numeroDocumento = teclado.nextLine();

            Documento documento = new Documento(tipoDocumento, numeroDocumento);

            System.out.println("\n¿Cómo desea cargar la edad?");
            System.out.println("1 - Asignar edad automáticamente");
            System.out.println("2 - Ingresar edad manualmente");
            System.out.print("Seleccione una opción: ");
            int opcionEdad = teclado.nextInt();
            teclado.nextLine();

            Persona persona;

            if(opcionEdad == 1){
                persona = new Persona(nombre, apellido, documento);
            }
            else{
                System.out.print("Ingrese la Edad de la Persona: ");
                int edad = teclado.nextInt();
                teclado.nextLine();

                persona = new Persona(nombre, apellido, documento, edad);
            }

            listaPersonas.add(persona);

            System.out.print("\nDesea cargar otra persona? (1 para seguir cargando): ");
            seguirCargando = teclado.nextLine();

            System.out.println();
        }
        while(seguirCargando.equals("1"));

        System.out.println("\nPersonas cargadas:");

        for(Persona persona : listaPersonas){
            persona.mostrarAtributos();
        }
    }
}
