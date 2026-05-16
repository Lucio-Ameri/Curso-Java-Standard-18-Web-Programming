package MODULO_2.Desafio.Ejercicio_1;

import java.util.Scanner;

public class EjercicioPropuesto {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String regexCorreo = "^[a-zA-Z0-9._-]+@educacionit\\.com$";
        String regexClave = "^[A-ZÁÉÍÓÚÑ].*[*.\\-_].*$";
        boolean condicion;

        do{
            condicion = true;
            System.out.print("\nIngrese el correo electrónico(debe ser de educacionit.com): ");
            String correo = teclado.nextLine();

            System.out.print("\nIngrese la clave(Debe empezar con mayuscula. Debe contener un numero. Debe contener un caracter especial [“*”, “.”, “-”, “_”]): ");
            String clave = teclado.nextLine();

            if(!correo.matches(regexCorreo)){
                System.out.println("\n\nCorreo inválido. Debe pertenecer al dominio educacionit.com");
                condicion = false;
            }

            if (!clave.matches(regexClave)) {
                System.out.println("\n\nClave inválida. Debe iniciar con mayúscula y contener *, ., - o _");
                condicion = false;
            }

            if(condicion){
                Usuario usuario = new Usuario(correo, clave);
                usuario.imprimirUsuario();
            }
        }
        while(!condicion);
    }
}
