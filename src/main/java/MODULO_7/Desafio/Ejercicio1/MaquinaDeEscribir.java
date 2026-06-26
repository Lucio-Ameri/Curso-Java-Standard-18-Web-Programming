package MODULO_7.Desafio.Ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MaquinaDeEscribir{
    public void guardarArchivo(String rutaSalida, String contenido) {

        try{
            Path archivoSalida = Path.of(rutaSalida);
            Files.writeString(archivoSalida, contenido);
        }
        catch(IOException e){
            throw new RuntimeException("Error: no se pudo guardar el archivo modificado.");
        }
    }
}
