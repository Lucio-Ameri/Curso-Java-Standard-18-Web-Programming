package MODULO_3.Desafio.Ejercicio_2;

public class App{
    public static void main(String[] args){
        Producto cajaAhorro = new CA(123, 45);
        Producto cuentaCorriente = new CC(123, 46);
        Producto tarjetaCredito = new TC(123, 47);

        System.out.println(cajaAhorro);
        System.out.println(cuentaCorriente);
        System.out.println(tarjetaCredito);
    }
}
