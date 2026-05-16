package MODULO_2.Laboratorio_Adicional_3;

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
            Persona persona = new Persona(nombre, apellido, documento);

            listaPersonas.add(persona);

            System.out.print("\nDesea cargar otra persona? (1 para seguir cargando): ");
            seguirCargando = teclado.nextLine();

            System.out.println();
        }
        while(seguirCargando.equals("1"));

        System.out.println("\nPersonas cargadas:");
        for(Persona persona : listaPersonas){
            persona.imprimirDatos();
        }
    }
}
