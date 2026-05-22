package MODULO_3.Laboratorio_Adicional_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EjercicioPropuesto{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();

        List<Alumno> alumnos = new ArrayList<>();
        List<Profesor> profesores = new ArrayList<>();

        cargarDatosAutomaticos(personas, alumnos, profesores);

        System.out.println("\n===== DATOS CARGADOS AUTOMÁTICAMENTE =====");
        mostrarPersonas(personas);

        cargarAlumnos(teclado, alumnos);
        cargarProfesores(teclado, profesores);

        System.out.println("\n==============================");
        System.out.println("ALUMNOS CARGADOS");
        System.out.println("==============================");

        for(Alumno alumno : alumnos){
            System.out.println(alumno);
            System.out.println(alumno.mostrarTipoPersona());
            System.out.println();
        }

        System.out.println("\n==============================");
        System.out.println("PROFESORES CARGADOS");
        System.out.println("==============================");

        for(Profesor profesor : profesores){
            System.out.println(profesor);
            System.out.println(profesor.mostrarTipoPersona());
            System.out.println();
        }

        System.out.println("\nCantidad total de personas creadas: " + Persona.getContadorPersonas());
    }

    private static void cargarDatosAutomaticos(List<Persona> personas, List<Alumno> alumnos, List<Profesor> profesores){
        List<Curso> cursosProgramacion = new ArrayList<>();
        cursosProgramacion.add(new Curso("Programación I"));
        cursosProgramacion.add(new Curso("Programación Orientada a Objetos"));

        List<Curso> cursosWeb = new ArrayList<>();
        cursosWeb.add(new Curso("HTML"));
        cursosWeb.add(new Curso("CSS"));
        cursosWeb.add(new Curso("JavaScript"));

        List<Curso> cursosBaseDatos = new ArrayList<>();
        cursosBaseDatos.add(new Curso("Base de Datos I"));
        cursosBaseDatos.add(new Curso("SQL"));

        Director director1 = new Director("María", "Gómez", new Documento("DNI", "10000001"), LocalDate.of(1975, 3, 12), LocalDate.of(2015, 2, 1), 950000.0, "Tecnicatura en Programación");
        Director director2 = new Director("Carlos", "Pérez", new Documento("DNI", "10000002"), LocalDate.of(1970, 8, 25), LocalDate.of(2012, 4, 10), 980000.0, "Ingeniería en Sistemas");
        Director director3 = new Director("Laura", "Fernández", new Documento("DNI", "10000003"), LocalDate.of(1980, 11, 5), LocalDate.of(2018, 7, 15), 920000.0, "Analista de Sistemas");

        Administrativo administrativo1 = new Administrativo("Sofía", "Ramírez", new Documento("DNI", "20000001"), LocalDate.of(1990, 1, 20), LocalDate.of(2020, 3, 1), 450000.0);
        Administrativo administrativo2 = new Administrativo("Jorge", "López", new Documento("DNI", "20000002"), LocalDate.of(1988, 6, 14), LocalDate.of(2019, 5, 6), 470000.0);
        Administrativo administrativo3 = new Administrativo("Valentina", "Torres", new Documento("DNI", "20000003"), LocalDate.of(1995, 9, 30), LocalDate.of(2021, 8, 12), 430000.0);

        Profesor profesor1 = new Profesor("Andrés", "Molina", new Documento("DNI", "30000001"), LocalDate.of(1982, 4, 18), LocalDate.of(2016, 3, 1), 650000.0, cursosProgramacion);
        Profesor profesor2 = new Profesor("Patricia", "Suárez", new Documento("DNI", "30000002"), LocalDate.of(1979, 12, 9), LocalDate.of(2017, 4, 1), 670000.0, cursosWeb);
        Profesor profesor3 = new Profesor("Ricardo", "Benítez", new Documento("DNI", "30000003"), LocalDate.of(1985, 7, 22), LocalDate.of(2019, 3, 15), 640000.0, cursosBaseDatos);

        Alumno alumno1 = new Alumno("Lucía", "Martínez", new Documento("DNI", "40000001"), LocalDate.of(2003, 2, 17), LocalDate.of(2023, 3, 1), cursosProgramacion);
        Alumno alumno2 = new Alumno("Mateo", "Herrera", new Documento("DNI", "40000002"), LocalDate.of(2002, 10, 11), LocalDate.of(2022, 3, 1), cursosWeb);
        Alumno alumno3 = new Alumno("Camila", "Arias", new Documento("DNI", "40000003"), LocalDate.of(2004, 5, 6), LocalDate.of(2024, 3, 1), cursosBaseDatos);

        personas.add(director1);
        personas.add(director2);
        personas.add(director3);

        personas.add(administrativo1);
        personas.add(administrativo2);
        personas.add(administrativo3);

        personas.add(profesor1);
        personas.add(profesor2);
        personas.add(profesor3);

        personas.add(alumno1);
        personas.add(alumno2);
        personas.add(alumno3);

        profesores.add(profesor1);
        profesores.add(profesor2);
        profesores.add(profesor3);

        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
    }

    private static void mostrarPersonas(List<Persona> personas){
        for(Persona persona : personas){
            System.out.println(persona);
            System.out.println(persona.mostrarTipoPersona());
            System.out.println();
        }
    }

    private static void cargarAlumnos(Scanner teclado, List<Alumno> alumnos){
        String continuar;

        do{
            System.out.println("\n--- CARGA DE ALUMNO ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del alumno: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del alumno: ");

            Documento documento = pedirDocumento(teclado);

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento yyyy-MM-dd: ");
            LocalDate fechaIngreso = pedirFecha(teclado, "Ingrese fecha de ingreso yyyy-MM-dd: ");

            List<Curso> cursos = pedirCursos(teclado, "¿Cuántos cursos cursa el alumno?: ");

            Alumno alumno = new Alumno(nombre, apellido, documento, fechaNacimiento, fechaIngreso, cursos);
            alumnos.add(alumno);

            continuar = pedirTexto(teclado, "¿Desea cargar otro alumno? Ingrese 1 para continuar: ");
        }
        while(continuar.equals("1"));
    }

    private static void cargarProfesores(Scanner teclado, List<Profesor> profesores){
        String continuar;

        do{
            System.out.println("\n--- CARGA DE PROFESOR ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del profesor: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del profesor: ");

            Documento documento = pedirDocumento(teclado);

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento yyyy-MM-dd: ");
            LocalDate fechaCargo = pedirFecha(teclado, "Ingrese fecha de inicio del cargo yyyy-MM-dd: ");

            Double sueldo = pedirDouble(teclado, "Ingrese el sueldo del profesor: ");

            List<Curso> cursos = pedirCursos(teclado, "¿Cuántos cursos dicta el profesor?: ");

            Profesor profesor = new Profesor(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo, cursos);
            profesores.add(profesor);

            continuar = pedirTexto(teclado, "¿Desea cargar otro profesor? Ingrese 1 para continuar: ");
        }
        while(continuar.equals("1"));
    }

    private static Documento pedirDocumento(Scanner teclado){
        String tipoDocumento = pedirTexto(teclado, "Ingrese tipo de documento: ");
        String numeroDocumento = pedirTexto(teclado, "Ingrese número de documento: ");

        return new Documento(tipoDocumento, numeroDocumento);
    }

    private static List<Curso> pedirCursos(Scanner teclado, String mensajeCantidad){
        List<Curso> cursos = new ArrayList<>();

        int cantidadCursos = pedirEntero(teclado, mensajeCantidad);
        for(int i = 0; i < cantidadCursos; i++){
            String nombreCurso = pedirTexto(teclado, "Ingrese nombre del curso " + (i + 1) + ": ");
            Curso curso = new Curso(nombreCurso);
            cursos.add(curso);
        }

        return cursos;
    }

    private static String pedirTexto(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    private static int pedirEntero(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        int numero = teclado.nextInt();
        teclado.nextLine();
        return numero;
    }

    private static Double pedirDouble(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        Double numero = teclado.nextDouble();
        teclado.nextLine();
        return numero;
    }

    private static LocalDate pedirFecha(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        String fecha = teclado.nextLine();
        return LocalDate.parse(fecha);
    }
}
