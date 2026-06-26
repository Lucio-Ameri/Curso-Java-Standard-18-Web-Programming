package MODULO_7.Laboratorio_Adicional_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
    public Lector(){}

    public static void leerArchivo(String nombre) {
        File archivo = new File(nombre);

        try (FileReader lector = new FileReader(archivo)) {
            int unCaracter;

            System.out.println("\nContenido actual del archivo:");

            while ((unCaracter = lector.read()) != -1) {
                System.out.print((char) unCaracter);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: no se encontró el archivo '" + nombre + "'.");
            System.out.println("Detalle: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error: ocurrió un problema al leer el archivo '" + nombre + "'.");
            System.out.println("Detalle: " + e.getMessage());
        }
    }
}
