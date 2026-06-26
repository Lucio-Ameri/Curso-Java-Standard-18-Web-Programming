package MODULO_7.Desafio.Ejercicio2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;

public class LogProductoArchivo {
    private static final Path RUTA_ARCHIVO_LOG = Paths.get("logs.txt");
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void guardar(LogProducto log, int idLogRegistradoEnBD) throws IOException {
        String linea = construirLineaDeLog(log, idLogRegistradoEnBD);

        Files.write(RUTA_ARCHIVO_LOG, (linea + System.lineSeparator()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private String construirLineaDeLog(LogProducto log, int idLogRegistradoEnBD) {
        return String.format("%s %s: %s - Producto afectado: %s - Registrado en la tabla logs id[%d]", log.getFechaHora().format(FORMATO_FECHA), log.getClaseAfectada(), log.getDescripcionError(), log.getProductoAfectado(), idLogRegistradoEnBD);
    }
}
