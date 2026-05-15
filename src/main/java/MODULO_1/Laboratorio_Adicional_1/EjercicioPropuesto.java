package MODULO_1.Laboratorio_Adicional_1;

public class EjercicioPropuesto {
    public static void main(String[] args) {

        // EJERCICIO 1
        int num1 = 5;
        int num2 = 10;

        int resta = num1 - num2;
        int suma = num1 + num2;
        int multiplicacion = num1 * num2;
        float division = num2 / num1;

        System.out.println("Ejercicio 1:");
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);


        // EJERCICIO 2
        float nota1 = 5.3f;
        float nota2 = 9.5f;
        float nota3 = 6.3f;
        float nota4 = 10.0f;

        float promedio = (nota1 + nota2 + nota3 + nota4) / 4;

        System.out.println("Resultado del promedio de notas: " + promedio);
    }
}
