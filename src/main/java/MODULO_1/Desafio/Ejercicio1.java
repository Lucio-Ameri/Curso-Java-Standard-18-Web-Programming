package MODULO_1.Desafio;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de elementos que tendra el array: ");

        try {
            int cantidadElementos = teclado.nextInt();
            Random aleatorio = new Random();

            int[] arrayElementos = new int[cantidadElementos];
            String[] arrayDivisibles = new String[cantidadElementos];

            System.out.print("[ ");
            for (int i = 0; i < cantidadElementos; i++) {
                arrayElementos[i] = aleatorio.nextInt(cantidadElementos) + 1;
                System.out.printf("%d ", arrayElementos[i]);

                if (arrayElementos[i] % 3 == 0) {
                    if (arrayElementos[i] % 5 == 0) {
                        arrayDivisibles[i] = "FizzBuzz";
                    }

                    else {
                        arrayDivisibles[i] = "Fizz";
                    }
                }

                else if (arrayElementos[i] % 5 == 0) {
                    arrayDivisibles[i] = "Buzz";
                }

                else {
                    arrayDivisibles[i] = String.valueOf(arrayElementos[i]);
                }
            }
            System.out.println("]");

            System.out.print("[ ");
            for (int i = 0; i < cantidadElementos; i++) {
                System.out.printf("%s    ", arrayDivisibles[i]);
            }
            System.out.println("]");
        }

        catch (Exception e) {
            System.out.println("Ingreso invalido!");
        }
    }
}
