package MODULO_7.Desafio.Ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Lector {
    public List<String> leerArchivo(String rutaArchivo) {

        try{
            Path archivo = Path.of(rutaArchivo);
            return Files.readAllLines(archivo);

        }
        catch(IOException e){
            throw new RuntimeException("Error: no se pudo leer el archivo.");
        }
    }
}
