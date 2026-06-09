package MODULO_5.Desafio.Ejercicio_3;

public class Main{

    public static void main(String[] args){

        ColaPersonas cola = new ColaPersonas();

        cola.agregarPersona(new Persona("111", "Lucio", "Ameri", 22));
        cola.agregarPersona(new Persona("222", "Carlos", "Gomez", 60));
        cola.agregarPersona(new Persona("333", "Ana", "Perez", 58));
        cola.agregarPersona(new Persona("444", "Sofia", "Lopez", 30));
        cola.agregarPersona(new Persona("555", "Mario", "Diaz", 70));
        cola.agregarPersona(new Persona("222", "Pedro", "Ramirez", 40));

        System.out.println("Comienza la atención de la cola...");
        System.out.println();

        while(!cola.estaVacia()){

            Persona atendida = cola.atenderPersona();

            System.out.println("Se atendió a:");
            System.out.println(atendida);
            System.out.println();

            Persona proxima = cola.verProximaPersona();

            if(proxima != null){
                System.out.println("Próxima persona a atender:");
                System.out.println(proxima);
            }
            else{
                System.out.println("No quedan personas en la cola.");
            }

            System.out.println("------------------------------------");

            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                System.out.println("La espera fue interrumpida.");
            }
        }
    }
}
