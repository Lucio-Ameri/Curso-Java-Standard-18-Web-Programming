package MODULO_1.Laboratorio_Adicional_2;


import java.util.Scanner;

public class EjercicioPropuesto {
    public static void main(String[] args) {

        // EJERCICIO 1
        int num1 = 5;
        int num2 = 10;
        int num3 = 25;

        if(num1 > num2 && num1 > num3){
            System.out.println("El num1 es el mayor de los 3.");
        }

        else if(num2 > num1 && num2 > num3){
            System.out.println("El num2 es el mayor de los 3.");
        }

        else if (num3 > num1 && num3 > num2){
            System.out.println("El num3 es el mayor de los 3.");
        }

        else{
            System.out.println("Los 3 num son iguales o 2 de los 3 num son iguales y mayores al restante. Por lo que no se cumple la condicion propuesta.");
        }


        // EJERCICIO 2
        int num4 = 10;
        int num5 = 15;

        Scanner entrada = new Scanner(System.in);
        System.out.println("");
        System.out.println("Que calculo desea realizar? \n 1. Suma \n 2.Resta \n 3. Multiplicacion \n 4.Division");
        System.out.printf("Ingrese la opcion: ");

        try {
            int respuesta = entrada.nextInt();

            if(respuesta == 1){
                System.out.println("\nEl resultado de hacer " + num4 + " + " + num5 + " = " + (num4 + num5));
            }

            else if(respuesta == 2){
                System.out.println("\nEl resultado de hacer " + num4 + " - " + num5 + " = " + (num4 - num5));
            }

            else if(respuesta == 3){
                System.out.println("\nEl resultado de hacer " + num4 + " * " + num5 + " = " + (num4 * num5));
            }

            else if(respuesta == 4){
                System.out.println("\nEl resultado de hacer " + num4 + " / " + num5 + " = " + ((double)num4 / num5));
            }

            else{
                System.out.println("\nRespuesta incorrecta!");
            }
        }

        catch (Exception e) {
            System.out.println("\n Respuesta incorrecta!");
        }


        // EJERCICIO 3
        System.out.println("");
        System.out.println("Que calculo desea realizar? \n S. Suma \n R.Resta \n M. Multiplicacion \n D.Division");
        System.out.printf("Ingrese la opcion: ");

        try {
            String respuesta2 = entrada.next();
            respuesta2 = respuesta2.toUpperCase();

            if(respuesta2.equals("S")){
                System.out.println("\nEl resultado de hacer " + num4 + " + " + num5 + " = " + (num4 + num5));
            }

            else if(respuesta2.equals("R")){
                System.out.println("\nEl resultado de hacer " + num4 + " - " + num5 + " = " + (num4 - num5));
            }

            else if(respuesta2.equals("M")){
                System.out.println("\nEl resultado de hacer " + num4 + " * " + num5 + " = " + (num4 * num5));
            }

            else if(respuesta2.equals("D")){
                System.out.println("\nEl resultado de hacer " + num4 + " / " + num5 + " = " + ((double)num4 / num5));
            }

            else{
                System.out.println("\nRespuesta incorrecta!");
            }
        }

        catch (Exception e) {
            System.out.println("\n Respuesta incorrecta!");
        }
    }
}
