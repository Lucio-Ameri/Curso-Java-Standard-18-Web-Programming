package MODULO_5.Desafio.Ejercicio_1;

import java.util.Map;

public class Tabla<K, V>{

    private Map<K, V> datos;

    public Tabla(Map<K, V> datos){
        this.datos = datos;
    }

    public boolean agregar(K clave, V valor){
        if(datos.containsKey(clave)){
            return false;
        }

        datos.put(clave, valor);
        return true;
    }

    public boolean existe(K clave){
        return datos.containsKey(clave);
    }

    public void mostrarTodos(){
        if(datos.isEmpty()){
            System.out.println("La colección está vacía.");
            return;
        }

        for(Map.Entry<K, V> entrada : datos.entrySet()){
            System.out.println("Clave: " + entrada.getKey() + " | Valor: " + entrada.getValue());
        }
    }
}