package MODULO_7.Laboratorio_Adicional_1;

import java.io.IOException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        String archivo = "ejemplo.txt";

        System.out.print("Ingrese el contenido a colocar en el archivo: ");
        String contenido = teclado.nextLine();

        boolean sePudoEscribir = MaquinaDeEscribir.escribirArchivo(archivo, contenido);

        if(sePudoEscribir){
            Lector.leerArchivo(archivo);
        }
    }
}
