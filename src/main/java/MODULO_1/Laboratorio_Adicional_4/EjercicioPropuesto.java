package MODULO_1.Laboratorio_Adicional_4;

import java.util.Scanner;

public class EjercicioPropuesto {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.printf("Ingrese la cantidad de notas que desea ingresar: ");

        try {
            int cantidadNotas = teclado.nextInt();
            teclado.nextLine();

            float[] arrayNotas = new float[cantidadNotas];
            String[] arrayNombres = new String[cantidadNotas];

            int i;
            for(i = 0; i < cantidadNotas; i++){
                System.out.printf("\nIngrese la nota numero %d: ", i + 1);
                arrayNotas[i] = teclado.nextFloat();
                teclado.nextLine();

                System.out.printf("\nIngrese el Nombre del alumno: ");
                arrayNombres[i] = teclado.nextLine();
            }

            int posicionMayorNota;
            for(i = 0; i < cantidadNotas - 1; i++){
                posicionMayorNota = i;

                for(int j = i + 1; j < cantidadNotas; j++){
                    if(arrayNotas[j] > arrayNotas[posicionMayorNota]){
                        posicionMayorNota = j;
                    }
                }

                float aux = arrayNotas[i];
                String auxNombre = arrayNombres[i];

                arrayNotas[i] = arrayNotas[posicionMayorNota];
                arrayNombres[i] = arrayNombres[posicionMayorNota];

                arrayNotas[posicionMayorNota] = aux;
                arrayNombres[posicionMayorNota] = auxNombre;
            }

            float promedioNotas = 0.0f;
            for(i = 0; i < cantidadNotas; i++){
                promedioNotas += arrayNotas[i];
            }

            promedioNotas = promedioNotas / cantidadNotas;

            System.out.printf("\n\n\nEl promedio de notas es: %.2f", promedioNotas);
            System.out.printf("\nLa mejor nota fue %.2f del alumno %s", arrayNotas[0], arrayNombres[0]);
            System.out.printf("\nLa menor nota fue %.2f del alumno %s", arrayNotas[cantidadNotas - 1], arrayNombres[cantidadNotas - 1]);

        }
        catch (Exception e) {
            System.out.println("Ingreso incorrecto!");
        }
    }
}
