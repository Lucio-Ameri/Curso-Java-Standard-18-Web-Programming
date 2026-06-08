package MODULO_4.Desafio.Ejercicio_1;

import java.util.Arrays;
import java.util.List;

public class Impresora {
    private static final List<String> VALIDAS = Arrays.asList("Canon", "HP", "Epson", "Brother", "Samsung");

    private String marca;
    private String[] documento;

    public Impresora(String marca, String[] documento){
        if(!VALIDAS.contains(marca)){
            throw new IllegalArgumentException("Marca de impresora invalida!.");
        }

        if(documento == null || documento.length == 0){
            throw new IllegalArgumentException("Documento invalido.");
        }

        this.marca = marca;
        this.documento = documento;
    }

    public void imprimir() {
        try(RecursoImpresion recurso = new RecursoImpresion(marca)){

            System.out.println("Imprimiendo en impresora: " + marca);

            for(String linea : documento){
                if(linea != null && !linea.isBlank()){
                    recurso.imprimirLinea(linea);
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error al imprimir: " + e.getMessage());
        }
    }
}
