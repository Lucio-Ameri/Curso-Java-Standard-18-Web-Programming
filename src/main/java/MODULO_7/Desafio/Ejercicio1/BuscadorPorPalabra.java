package MODULO_7.Desafio.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class BuscadorPorPalabra {
    public Resultado buscarYMarcar(List<String> lineas, String palabraBuscada) {

        boolean existe = false;
        List<Ubicacion> ubicaciones = new ArrayList<>();
        StringBuilder contenidoModificado = new StringBuilder();

        for(int i = 0; i < lineas.size(); i++){

            String linea = lineas.get(i);
            StringBuilder lineaModificada = new StringBuilder();

            int posicionActual = 0;
            int posicionEncontrada;

            while((posicionEncontrada = linea.indexOf(palabraBuscada, posicionActual)) != -1){

                existe = true;

                int fila = i + 1;
                int columna = posicionEncontrada + 1;

                ubicaciones.add(new Ubicacion(fila, columna));
                lineaModificada.append(linea, posicionActual, posicionEncontrada);
                lineaModificada.append("<<").append(palabraBuscada).append(">>");
                posicionActual = posicionEncontrada + palabraBuscada.length();
            }

            lineaModificada.append(linea.substring(posicionActual));
            contenidoModificado.append(lineaModificada);

            if(i < lineas.size() - 1){
                contenidoModificado.append(System.lineSeparator());
            }
        }

        return new Resultado(existe, ubicaciones, contenidoModificado.toString());
    }
}
