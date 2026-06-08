package MODULO_4.Desafio.Ejercicio_1;

public class EjercicioPropuesto {
    public static void main(String[] args) {

        String[] documento = {"Primera línea del documento", "Segunda línea del documento", "Tercera línea del documento"};

        Impresora impresora = new Impresora("HP", documento);
        impresora.imprimir();
    }
}
