package MODULO_5.Desafio.Ejercicio_3;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ColaPersonas{

    private PriorityQueue<Persona> cola;
    private Set<String> documentosRegistrados;
    private int contadorOrdenLlegada;

    public ColaPersonas(){
        documentosRegistrados = new HashSet<>();
        contadorOrdenLlegada = 0;

        cola = new PriorityQueue<>((p1, p2) ->{

            if(p1.esPrioritaria() && !p2.esPrioritaria()){
                return -1;
            }

            if(!p1.esPrioritaria() && p2.esPrioritaria()){
                return 1;
            }

            return Integer.compare(p1.getOrdenLlegada(), p2.getOrdenLlegada());
        });
    }

    public boolean agregarPersona(Persona persona){

        if(documentosRegistrados.contains(persona.getDocumento())){
            System.out.println("No se pudo agregar. Ya existe una persona con documento: " + persona.getDocumento());
            return false;
        }

        contadorOrdenLlegada++;
        persona.setOrdenLlegada(contadorOrdenLlegada);

        cola.add(persona);
        documentosRegistrados.add(persona.getDocumento());

        System.out.println("Persona agregada a la cola:");
        System.out.println(persona);
        System.out.println();

        return true;
    }

    public Persona atenderPersona(){

        if(cola.isEmpty()){
            return null;
        }

        Persona atendida = cola.poll();
        documentosRegistrados.remove(atendida.getDocumento());

        return atendida;
    }

    public Persona verProximaPersona(){

        if(cola.isEmpty()){
            return null;
        }

        return cola.peek();
    }

    public boolean estaVacia(){
        return cola.isEmpty();
    }
}
