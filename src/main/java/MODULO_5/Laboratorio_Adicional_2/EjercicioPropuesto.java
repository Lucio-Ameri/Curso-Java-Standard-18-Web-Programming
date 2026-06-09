package MODULO_5.Laboratorio_Adicional_2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;


public class EjercicioPropuesto{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        Set<Persona> personas = new TreeSet<>();

        try{
            cargarDatosAutomaticos(personas);
        }
        catch(DocumentoInvalidoException e){
            System.out.println("Error al cargar los datos automáticos.");
            System.out.println(e.getMessage());
            teclado.close();
            return;
        }

        System.out.println("\n===== DATOS CARGADOS AUTOMÁTICAMENTE =====");
        mostrarPersonas(personas);

        cargarAlumnos(teclado, personas);
        cargarProfesores(teclado, personas);

        System.out.println("\n==============================");
        System.out.println("TODAS LAS PERSONAS CARGADAS");
        System.out.println("Ordenadas por tipo y número de documento");
        System.out.println("==============================");

        mostrarPersonas(personas);

        System.out.println("\n==============================");
        System.out.println("EJECUTANDO MÉTODOS ABM");
        System.out.println("==============================");

        ejecutarABM(personas);

        System.out.println("\nCantidad total de personas creadas: " + Persona.getContadorPersonas());

        teclado.close();
    }

    private static void cargarDatosAutomaticos(Set<Persona> personas) throws DocumentoInvalidoException {
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

        agregarPersona(personas, director1);
        agregarPersona(personas, director2);
        agregarPersona(personas, director3);

        agregarPersona(personas, administrativo1);
        agregarPersona(personas, administrativo2);
        agregarPersona(personas, administrativo3);

        agregarPersona(personas, profesor1);
        agregarPersona(personas, profesor2);
        agregarPersona(personas, profesor3);

        agregarPersona(personas, alumno1);
        agregarPersona(personas, alumno2);
        agregarPersona(personas, alumno3);
    }

    private static void mostrarPersonas(Set<Persona> personas){
        for(Persona persona : personas){
            System.out.println(persona);
            System.out.println(persona.mostrarTipoPersona());
            System.out.println();
        }
    }

    private static void ejecutarABM(Set<Persona> personas){
        for(Persona persona : personas){
            persona.guardar();
            System.out.println();

            persona.modificar();
            System.out.println();

            persona.borrar();
            System.out.println();

            System.out.println("------------------------------");
        }
    }

    private static void cargarAlumnos(Scanner teclado, Set<Persona> personas){
        String continuar;

        do{
            System.out.println("\n--- CARGA DE ALUMNO ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del alumno: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del alumno: ");

            Documento documento = pedirDocumento(teclado);

            if(existeDocumento(personas, documento)){
                System.out.println("No se agregó el alumno porque ya existe una persona con ese documento.");
                continuar = pedirTexto(teclado, "¿Desea cargar otro alumno? Ingrese 1 para continuar: ");
                continue;
            }

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento yyyy-MM-dd: ");
            LocalDate fechaIngreso = pedirFecha(teclado, "Ingrese fecha de ingreso yyyy-MM-dd: ");

            List<Curso> cursos = pedirCursos(teclado, "¿Cuántos cursos cursa el alumno?: ");

            Alumno alumno = new Alumno(nombre, apellido, documento, fechaNacimiento, fechaIngreso, cursos);
            agregarPersona(personas, alumno);

            continuar = pedirTexto(teclado, "¿Desea cargar otro alumno? Ingrese 1 para continuar: ");
        }
        while(continuar.equals("1"));
    }

    private static void cargarProfesores(Scanner teclado, Set<Persona> personas){
        String continuar;

        do{
            System.out.println("\n--- CARGA DE PROFESOR ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del profesor: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del profesor: ");

            Documento documento = pedirDocumento(teclado);

            if(existeDocumento(personas, documento)){
                System.out.println("No se agregó el profesor porque ya existe una persona con ese documento.");
                continuar = pedirTexto(teclado, "¿Desea cargar otro profesor? Ingrese 1 para continuar: ");
                continue;
            }

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento yyyy-MM-dd: ");
            LocalDate fechaCargo = pedirFecha(teclado, "Ingrese fecha de inicio del cargo yyyy-MM-dd: ");

            Double sueldo = pedirDouble(teclado, "Ingrese el sueldo del profesor: ");

            List<Curso> cursos = pedirCursos(teclado, "¿Cuántos cursos dicta el profesor?: ");

            Profesor profesor = new Profesor(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo, cursos);
            agregarPersona(personas, profesor);

            continuar = pedirTexto(teclado, "¿Desea cargar otro profesor? Ingrese 1 para continuar: ");
        }
        while(continuar.equals("1"));
    }

    private static Documento pedirDocumento(Scanner teclado){
        Documento documento = null;
        boolean documentoValido = false;

        while(!documentoValido){
            try{
                String tipoDocumento = pedirTexto(teclado, "Ingrese tipo de documento DNI, PAS, LE o CI: ");
                String numeroDocumento = pedirTexto(teclado, "Ingrese número de documento: ");

                documento = new Documento(tipoDocumento, numeroDocumento);
                documentoValido = true;
            }
            catch(DocumentoInvalidoException e){
                System.out.println("Error: " + e.getMessage());
                System.out.println("Vuelva a ingresar los datos del documento.");
                System.out.println();
            }
        }

        return documento;
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
        int numero = 0;
        boolean numeroValido = false;

        while(!numeroValido){
            try{
                numero = Integer.parseInt(pedirTexto(teclado, mensaje));

                if(numero < 0){
                    System.out.println("Error: debe ingresar un número entero positivo.");
                }
                else{
                    numeroValido = true;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }

        return numero;
    }

    private static Double pedirDouble(Scanner teclado, String mensaje){
        Double numero = null;
        boolean numeroValido = false;

        while(!numeroValido){
            try{
                numero = Double.parseDouble(pedirTexto(teclado, mensaje));

                if(numero < 0){
                    System.out.println("Error: debe ingresar un número positivo.");
                }
                else{
                    numeroValido = true;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Error: debe ingresar un número decimal válido.");
            }
        }

        return numero;
    }

    private static LocalDate pedirFecha(Scanner teclado, String mensaje){
        LocalDate fechaValida = null;
        boolean fechaCorrecta = false;

        while(!fechaCorrecta){
            try{
                System.out.print(mensaje);
                String fechaIngresada = teclado.nextLine();

                fechaValida = LocalDate.parse(fechaIngresada);
                fechaCorrecta = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Error: la fecha ingresada no es válida.");
                System.out.println("Debe ingresar una fecha con formato yyyy-MM-dd.");
                System.out.println("Ejemplo válido: 2003-04-15");
                System.out.println();
            }
        }

        return fechaValida;
    }

    private static boolean agregarPersona(Set<Persona> personas, Persona persona){
        boolean agregado = personas.add(persona);

        if(!agregado){
            System.out.println("No se agregó la persona porque ya existe otra persona con el documento " + persona.getDocumento() + ".");
        }

        return agregado;
    }

    private static boolean existeDocumento(Set<Persona> personas, Documento documento){
        for(Persona persona : personas){
            if(persona.getDocumento().equals(documento)){
                return true;
            }
        }

        return false;
    }
}