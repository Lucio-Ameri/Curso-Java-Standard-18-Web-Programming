package MODULO_3.Laboratorio_Adicional_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioPropuesto{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        List<Alumno> listaAlumnos = new ArrayList<>();
        String seguirCargando = "1";

        do {
            System.out.println("Carga de alumno");

            Integer id = Persona.generarNuevoID();

            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = teclado.nextLine();

            System.out.print("Ingrese el apellido del alumno: ");
            String apellido = teclado.nextLine();

            System.out.print("Ingrese el tipo de documento: ");
            String tipoDocumento = teclado.nextLine();

            System.out.print("Ingrese el número de documento: ");
            String numeroDocumento = teclado.nextLine();

            Documento documento = new Documento(tipoDocumento, numeroDocumento);

            System.out.print("Ingrese la edad del alumno: ");
            Integer edad = teclado.nextInt();
            teclado.nextLine();

            List<Curso> cursos = new ArrayList<>();

            System.out.print("¿Cuántos cursos desea asignar al alumno?: ");
            int cantidadCursos = teclado.nextInt();
            teclado.nextLine();

            for(int i = 0; i < cantidadCursos; i++) {
                System.out.print("Ingrese el nombre del curso " + (i + 1) + ": ");
                String nombreCurso = teclado.nextLine();

                Curso curso = new Curso(nombreCurso);
                cursos.add(curso);
            }

            Alumno alumno = new Alumno(id, nombre, apellido, documento, edad, cursos);
            listaAlumnos.add(alumno);

            System.out.print("\n¿Desea cargar otro alumno? Ingrese 1 para continuar: ");
            seguirCargando = teclado.nextLine();

            System.out.println();
        }
        while(seguirCargando.equals("1"));

        System.out.println("Alumnos cargados:");

        for(Alumno alumno : listaAlumnos){
            System.out.println(alumno);
        }

        System.out.println("\nCantidad de personas asignadas: " + Persona.getContadorPersonas());
    }
}
