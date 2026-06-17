package MODULO_6.Laboratorio_Adicional_2;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

public class EjercicioPropuesto{
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        CursoDAO cursoDAO = new CursoDAO();
        PersonaDAO personaDAO = new PersonaDAO();

        try{
            cursoDAO.cargarCursosIniciales();
            cargarDatosAutomaticos(personaDAO, cursoDAO);

            System.out.println("\n===== DICCIONARIO DE CURSOS =====");
            mostrarDiccionarioCursos(cursoDAO);

            System.out.println("\n===== DATOS CARGADOS AUTOMÁTICAMENTE / YA EXISTENTES EN BASE DE DATOS =====");
            mostrarPersonas(personaDAO.obtenerTodas());

            cargarDirectores(teclado, personaDAO);
            cargarAdministrativos(teclado, personaDAO);
            cargarAlumnos(teclado, personaDAO, cursoDAO);
            cargarProfesores(teclado, personaDAO, cursoDAO);

            Set<Persona> personas = personaDAO.obtenerTodas();

            System.out.println("\n==============================");
            System.out.println("TODAS LAS PERSONAS CARGADAS EN BASE DE DATOS");
            System.out.println("Ordenadas por tipo y número de documento");
            System.out.println("==============================");

            mostrarPersonas(personas);

            System.out.println("\n==============================");
            System.out.println("TOMA DE ASISTENCIA");
            System.out.println("Ordenadas por edad de mayor a menor");
            System.out.println("==============================");

            atenderPersonasPorEdad(personas);

            System.out.println("\n==============================");
            System.out.println("EJECUTANDO MÉTODOS ABM");
            System.out.println("==============================");

            ejecutarABM(personas);

            System.out.println("\nCantidad total de personas existentes en la base de datos: " + personas.size());
            System.out.println("Cantidad total de objetos Persona creados durante esta ejecución: " + Persona.getContadorPersonas());
        }
        catch (DocumentoInvalidoException e) {
            System.out.println("Error al crear un documento.");
            System.out.println(e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("Error al trabajar con la base de datos.");
            System.out.println(e.getMessage());
        }
        finally {
            teclado.close();
        }
    }

    private static void cargarDatosAutomaticos(PersonaDAO personaDAO, CursoDAO cursoDAO) throws DocumentoInvalidoException, SQLException{
        List<Integer> idsCursosProgramacion = obtenerIdsCursos(cursoDAO, "Programación I", "Programación Orientada a Objetos");
        List<Integer> idsCursosWeb = obtenerIdsCursos(cursoDAO, "HTML", "CSS", "JavaScript");
        List<Integer> idsCursosBaseDatos = obtenerIdsCursos(cursoDAO, "Base de Datos I", "SQL");

        personaDAO.guardar(new Director("María", "Gómez", new Documento("DNI", "10000001"), LocalDate.of(1975, 3, 12), LocalDate.of(2015, 2, 1), 950000.0, "Tecnicatura en Programación"));
        personaDAO.guardar(new Director("Carlos", "Pérez", new Documento("DNI", "10000002"), LocalDate.of(1970, 8, 25), LocalDate.of(2012, 4, 10), 980000.0, "Ingeniería en Sistemas"));
        personaDAO.guardar(new Director("Laura", "Fernández", new Documento("DNI", "10000003"), LocalDate.of(1980, 11, 5), LocalDate.of(2018, 7, 15), 920000.0, "Analista de Sistemas"));

        personaDAO.guardar(new Administrativo("Sofía", "Ramírez", new Documento("DNI", "20000001"), LocalDate.of(1990, 1, 20), LocalDate.of(2020, 3, 1), 450000.0));
        personaDAO.guardar(new Administrativo("Jorge", "López", new Documento("DNI", "20000002"), LocalDate.of(1988, 6, 14), LocalDate.of(2019, 5, 6), 470000.0));
        personaDAO.guardar(new Administrativo("Valentina", "Torres", new Documento("DNI", "20000003"), LocalDate.of(1995, 9, 30), LocalDate.of(2021, 8, 12), 430000.0));

        personaDAO.guardar(new Profesor("Andrés", "Molina", new Documento("DNI", "30000001"), LocalDate.of(1982, 4, 18), LocalDate.of(2016, 3, 1), 650000.0, idsCursosProgramacion));
        personaDAO.guardar(new Profesor("Patricia", "Suárez", new Documento("DNI", "30000002"), LocalDate.of(1979, 12, 9), LocalDate.of(2017, 4, 1), 670000.0, idsCursosWeb));
        personaDAO.guardar(new Profesor("Ricardo", "Benítez", new Documento("DNI", "30000003"), LocalDate.of(1985, 7, 22), LocalDate.of(2019, 3, 15), 640000.0, idsCursosBaseDatos));

        personaDAO.guardar(new Alumno("Lucía", "Martínez", new Documento("DNI", "40000001"), LocalDate.of(2003, 2, 17), LocalDate.of(2023, 3, 1), idsCursosProgramacion));
        personaDAO.guardar(new Alumno("Mateo", "Herrera", new Documento("DNI", "40000002"), LocalDate.of(2002, 10, 11), LocalDate.of(2022, 3, 1), idsCursosWeb));
        personaDAO.guardar(new Alumno("Camila", "Arias", new Documento("DNI", "40000003"), LocalDate.of(2004, 5, 6), LocalDate.of(2024, 3, 1), idsCursosBaseDatos));
    }

    private static List<Integer> obtenerIdsCursos(CursoDAO cursoDAO, String... nombresCursos) throws SQLException{
        return cursoDAO.obtenerIdsPorNombres(nombresCursos);
    }

    private static void mostrarDiccionarioCursos(CursoDAO cursoDAO) throws SQLException{
        for(Curso curso : cursoDAO.obtenerTodos()){
            System.out.println(curso);
        }
    }

    private static void mostrarPersonas(Set<Persona> personas){
        if(personas.isEmpty()){
            System.out.println("No hay personas cargadas en la base de datos.");
            return;
        }

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

    private static void cargarDirectores(Scanner teclado, PersonaDAO personaDAO) throws SQLException{
        String continuar;

        do{
            System.out.println("\n--- CARGA DE DIRECTOR ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del director: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del director: ");

            Documento documento = pedirDocumento(teclado);

            if(personaDAO.existeDocumento(documento)){
                System.out.println("No se agregó el director porque ya existe una persona con ese documento.");
                continuar = pedirTexto(teclado, "¿Desea cargar otro director? Ingrese 1 para continuar: ");
                continue;
            }

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento dd/MM/aaaa: ");
            LocalDate fechaCargo = pedirFecha(teclado, "Ingrese fecha de inicio del cargo dd/MM/aaaa: ");
            Double sueldo = pedirDouble(teclado, "Ingrese el sueldo del director: ");
            String carrera = pedirTexto(teclado, "Ingrese la carrera del director: ");

            Director director = new Director(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo, carrera);
            boolean guardado = personaDAO.guardar(director);

            if(guardado){
                System.out.println("Director guardado correctamente en la base de datos.");
            }
            else{
                System.out.println("El director no se guardó porque ya existía una persona con ese documento.");
            }

            continuar = pedirTexto(teclado, "¿Desea cargar otro director? Ingrese 1 para continuar: ");
        }
        while (continuar.equals("1"));
    }

    private static void cargarAdministrativos(Scanner teclado, PersonaDAO personaDAO) throws SQLException{
        String continuar;

        do{
            System.out.println("\n--- CARGA DE ADMINISTRATIVO ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del administrativo: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del administrativo: ");

            Documento documento = pedirDocumento(teclado);

            if(personaDAO.existeDocumento(documento)){
                System.out.println("No se agregó el administrativo porque ya existe una persona con ese documento.");
                continuar = pedirTexto(teclado, "¿Desea cargar otro administrativo? Ingrese 1 para continuar: ");
                continue;
            }

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento dd/MM/aaaa: ");
            LocalDate fechaCargo = pedirFecha(teclado, "Ingrese fecha de inicio del cargo dd/MM/aaaa: ");
            Double sueldo = pedirDouble(teclado, "Ingrese el sueldo del administrativo: ");

            Administrativo administrativo = new Administrativo(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo);
            boolean guardado = personaDAO.guardar(administrativo);

            if(guardado){
                System.out.println("Administrativo guardado correctamente en la base de datos.");
            }
            else{
                System.out.println("El administrativo no se guardó porque ya existía una persona con ese documento.");
            }

            continuar = pedirTexto(teclado, "¿Desea cargar otro administrativo? Ingrese 1 para continuar: ");
        }
        while(continuar.equals("1"));
    }

    private static void cargarAlumnos(Scanner teclado, PersonaDAO personaDAO, CursoDAO cursoDAO) throws SQLException{
        String continuar;

        do{
            System.out.println("\n--- CARGA DE ALUMNO ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del alumno: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del alumno: ");

            Documento documento = pedirDocumento(teclado);

            if(personaDAO.existeDocumento(documento)){
                System.out.println("No se agregó el alumno porque ya existe una persona con ese documento.");
                continuar = pedirTexto(teclado, "¿Desea cargar otro alumno? Ingrese 1 para continuar: ");
                continue;
            }

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento dd/MM/aaaa: ");
            LocalDate fechaIngreso = pedirFecha(teclado, "Ingrese fecha de ingreso dd/MM/aaaa: ");

            List<Integer> idsCursos = pedirCursos(teclado, cursoDAO, "¿Cuántos cursos cursa el alumno?: ");

            Alumno alumno = new Alumno(nombre, apellido, documento, fechaNacimiento, fechaIngreso, idsCursos);
            boolean guardado = personaDAO.guardar(alumno);

            if(guardado){
                System.out.println("Alumno guardado correctamente en la base de datos.");
            }
            else{
                System.out.println("El alumno no se guardó porque ya existía una persona con ese documento.");
            }

            continuar = pedirTexto(teclado, "¿Desea cargar otro alumno? Ingrese 1 para continuar: ");
        }
        while(continuar.equals("1"));
    }

    private static void cargarProfesores(Scanner teclado, PersonaDAO personaDAO, CursoDAO cursoDAO) throws SQLException{
        String continuar;

        do{
            System.out.println("\n--- CARGA DE PROFESOR ---");

            String nombre = pedirTexto(teclado, "Ingrese el nombre del profesor: ");
            String apellido = pedirTexto(teclado, "Ingrese el apellido del profesor: ");

            Documento documento = pedirDocumento(teclado);

            if(personaDAO.existeDocumento(documento)){
                System.out.println("No se agregó el profesor porque ya existe una persona con ese documento.");
                continuar = pedirTexto(teclado, "¿Desea cargar otro profesor? Ingrese 1 para continuar: ");
                continue;
            }

            LocalDate fechaNacimiento = pedirFecha(teclado, "Ingrese fecha de nacimiento dd/MM/aaaa: ");
            LocalDate fechaCargo = pedirFecha(teclado, "Ingrese fecha de inicio del cargo dd/MM/aaaa: ");

            Double sueldo = pedirDouble(teclado, "Ingrese el sueldo del profesor: ");

            List<Integer> idsCursos = pedirCursos(teclado, cursoDAO, "¿Cuántos cursos dicta el profesor?: ");

            Profesor profesor = new Profesor(nombre, apellido, documento, fechaNacimiento, fechaCargo, sueldo, idsCursos);
            boolean guardado = personaDAO.guardar(profesor);

            if(guardado){
                System.out.println("Profesor guardado correctamente en la base de datos.");
            }
            else{
                System.out.println("El profesor no se guardó porque ya existía una persona con ese documento.");
            }

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

    private static List<Integer> pedirCursos(Scanner teclado, CursoDAO cursoDAO, String mensajeCantidad) throws SQLException{
        List<Integer> idsCursos = new ArrayList<>();

        System.out.println("\nCursos disponibles:");
        mostrarDiccionarioCursos(cursoDAO);

        int cantidadCursos = pedirEntero(teclado, mensajeCantidad);

        for(int i = 0; i < cantidadCursos; i++){
            Curso curso = pedirCursoExistente(teclado, cursoDAO, "Ingrese nombre del curso " + (i + 1) + ": ");
            idsCursos.add(curso.getId());
        }

        return idsCursos;
    }

    private static Curso pedirCursoExistente(Scanner teclado, CursoDAO cursoDAO, String mensaje) throws SQLException{
        Curso curso = null;

        while(curso == null){
            String nombreCurso = pedirTexto(teclado, mensaje);
            curso = cursoDAO.buscarPorNombre(nombreCurso);

            if(curso == null){
                System.out.println("Error: el curso ingresado no existe en la base de datos.");
                System.out.println("Vuelva a ingresar un curso válido.");
                System.out.println("Cursos disponibles:");
                mostrarDiccionarioCursos(cursoDAO);
                System.out.println();
            }
        }

        return curso;
    }

    private static String pedirTexto(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        return teclado.nextLine().trim();
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
                String fechaIngresada = pedirTexto(teclado, mensaje);

                fechaValida = LocalDate.parse(fechaIngresada, FORMATO_FECHA);
                fechaCorrecta = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Error: la fecha ingresada no es válida.");
                System.out.println("Debe ingresar una fecha con formato dd/MM/aaaa.");
                System.out.println("Ejemplo válido: 15/03/1983");
                System.out.println();
            }
        }

        return fechaValida;
    }

    private static void atenderPersonasPorEdad(Set<Persona> personas){
        Queue<Persona> colaAsistencia = new PriorityQueue<>(Comparator.comparing(Persona::getFechaNacimiento).thenComparing(Persona::getDocumento));

        colaAsistencia.addAll(personas);

        while(!colaAsistencia.isEmpty()){
            Persona proximaPersona = colaAsistencia.peek();
            System.out.println("Será atendida: " + describirPersonaParaAsistencia(proximaPersona));

            Persona personaAtendida = colaAsistencia.poll();
            System.out.println("Está siendo atendida: " + describirPersonaParaAsistencia(personaAtendida));
            System.out.println("------------------------------");
        }
    }

    private static String describirPersonaParaAsistencia(Persona persona){
        return String.format("%s Edad: %d años.", persona.mostrarTipoPersona(), calcularEdad(persona));
    }

    private static int calcularEdad(Persona persona){
        return Period.between(persona.getFechaNacimiento(), LocalDate.now()).getYears();
    }
}
