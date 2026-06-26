package MODULO_7.Laboratorio_Adicional_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MaquinaDeEscribir {

    public MaquinaDeEscribir(){}

    public static boolean escribirArchivo(String nombre, String contenido) {
        File archivo = new File(nombre);

        try (FileWriter lapiz = new FileWriter(archivo, true)) {
            lapiz.write(contenido);
            lapiz.write(System.lineSeparator());
            return true;
        }
        catch (IOException e) {
            System.out.println("Error: no se pudo escribir en el archivo '" + nombre + "'.");
            System.out.println("Detalle: " + e.getMessage());
            return false;
        }
    }
}
