package MODULO_7.Desafio.Ejercicio1;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la palabra a buscar: ");
        String palabraBuscada = scanner.nextLine().trim();

        System.out.print("Ingrese la ruta del archivo: ");
        String rutaArchivo = scanner.nextLine().trim();

        if(palabraBuscada.isBlank()){
            System.out.println("Error: la palabra no puede estar vacía.");
            scanner.close();
            return;
        }

        Lector lector = new Lector();
        BuscadorPorPalabra buscador = new BuscadorPorPalabra();
        MaquinaDeEscribir maquinaDeEscribir = new MaquinaDeEscribir();

        try{
            List<String> lineas = lector.leerArchivo(rutaArchivo);

            Resultado resultado = buscador.buscarYMarcar(lineas, palabraBuscada);

            if(resultado.existe()){

                System.out.println("La palabra fue encontrada en:");

                for(Ubicacion ubicacion : resultado.getUbicaciones()){
                    System.out.println("Fila: " + ubicacion.getFila() + " | Columna: " + ubicacion.getColumna());
                }

                maquinaDeEscribir.guardarArchivo("archivo_modificado.txt", resultado.getContenidoModificado());
                System.out.println("Archivo modificado guardado correctamente.");

            }
            else{
                System.out.println("La palabra no existe en el archivo.");
            }

        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
