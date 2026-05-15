package MODULO_1.Desafio;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el numero a multiplicar: ");

        try {
            int numero = teclado.nextInt();
            teclado.nextLine();

            System.out.print("\n Ingrese el multiplicador: ");
            try {
                int multiplicador = teclado.nextInt();
                teclado.nextLine();

                int resultado = 0;
                for(int i = 0; i < multiplicador; i++){
                    resultado += numero;
                }

                System.out.printf("\nEl resultado de multiplicar a %d x %d es: %d", numero, multiplicador, resultado);
            }
            catch (Exception e) {
                System.out.println("Multiplicador invalido!");
            }
        }
        catch (Exception e) {
            System.out.println("Numero a multiplicar invalido!");
        }
    }
}
