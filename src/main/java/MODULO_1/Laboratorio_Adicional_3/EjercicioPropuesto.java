package MODULO_1.Laboratorio_Adicional_3;

import java.util.Random;
import java.util.Scanner;

public class EjercicioPropuesto {
    public static void main(String[] args) {

        // EJERCICIO 1
        Scanner ingreso = new Scanner(System.in);
        Random generador = new Random();
        int respuesta = generador.nextInt(10) + 1;
        int entrega;
        do{
            System.out.printf("\nAdivine el numero ingresando un numero entero entre [1 - 10] (\"0\" para terminar): ");
            try {
                entrega = ingreso.nextInt();
                if(entrega == respuesta){
                    System.out.println("\nNumero correcto!");
                    break;
                }

                else{
                    System.out.println("\nNumero incorrecto");
                }
            }
            catch (Exception e) {
                System.out.println("\nIngreso invalido!");
                entrega = 0;
            }
        }
        while(entrega != 0);

        // EJERCICIO 2
        ingreso.nextLine();
        String usuario = "Pepito";
        String constraseña = "Pepon1234";

        String intentoUsuario;
        String intentoContraseña;

        for(int i = 0; i < 3; i++){
            System.out.printf("\nIngrese el nombre de usuario: ");
            intentoUsuario = ingreso.nextLine();

            System.out.println("\nIngrese la contraseña: ");
            intentoContraseña = ingreso.nextLine();

            if(intentoUsuario.equals(usuario) && intentoContraseña.equals(constraseña)){
                System.out.println("\nBienvenido " + usuario);
                break;
            }

            else{
                if(i == 2){
                    System.out.println("\nUsuario bloqueado.");
                }

                else{
                    System.out.println("\nUsuario/Contraseña incorrecta!");
                }
            }
        }
    }
}
