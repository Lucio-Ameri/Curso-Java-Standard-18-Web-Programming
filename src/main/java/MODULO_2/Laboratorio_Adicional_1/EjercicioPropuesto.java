package MODULO_2.Laboratorio_Adicional_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioPropuesto{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        String opcion;

        do{
            System.out.print("Ingrese el nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Ingrese el apellido: ");
            String apellido = teclado.nextLine();

            System.out.print("Ingrese el tipo de documento: ");
            String tipoDocumento = teclado.nextLine();

            System.out.print("Ingrese el número de documento: ");
            String numeroDocumento = teclado.nextLine();

            int edad = leerEdad(teclado);

            personas.add(new Persona(nombre, apellido, tipoDocumento, numeroDocumento, edad));

            System.out.print("\n¿Desea cargar otra persona? (1 para continuar): ");
            opcion = teclado.nextLine();
        }
        while(opcion.equals("1"));

        System.out.println("\nPersonas cargadas:");

        for(Persona persona : personas){
            persona.imprimirDatos();
        }
    }

    private static int leerEdad(Scanner teclado){
        while(true){
            System.out.print("Ingrese la edad: ");

            try{
                int edad = Integer.parseInt(teclado.nextLine());

                if(edad >= 0){
                    return edad;
                }

                System.out.println("La edad no puede ser negativa.");
            }
            catch(NumberFormatException e){
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}
