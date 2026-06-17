package MODULO_6.Laboratorio_Adicional_1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PersonaDAO{

    public boolean guardar(Persona persona) throws SQLException{
        Connection conexion = null;

        try{
            conexion = ConexionBD.obtenerConexion();
            conexion.setAutoCommit(false);

            int idDocumento = obtenerOInsertarDocumento(conexion, persona.getDocumento());
            Integer idPersonaExistente = buscarIdPersonaPorDocumento(conexion, idDocumento);

            if(idPersonaExistente != null){
                conexion.commit();
                return false;
            }

            int idPersona = insertarPersona(conexion, persona, idDocumento);

            if(persona instanceof Director){
                Director director = (Director) persona;
                insertarEmpleado(conexion, director, idPersona);
                insertarDirector(conexion, director, idPersona);
            }
            else if(persona instanceof Administrativo){
                Administrativo administrativo = (Administrativo) persona;
                insertarEmpleado(conexion, administrativo, idPersona);
                insertarAdministrativo(conexion, idPersona);
            }
            else if(persona instanceof Profesor){
                Profesor profesor = (Profesor) persona;
                insertarEmpleado(conexion, profesor, idPersona);
                insertarProfesor(conexion, idPersona);
                insertarCursosProfesor(conexion, idPersona, profesor.getIdsCursosQueDicta());
            }
            else if(persona instanceof Alumno){
                Alumno alumno = (Alumno) persona;
                insertarAlumno(conexion, alumno, idPersona);
                insertarCursosAlumno(conexion, idPersona, alumno.getIdsCursos());
            }
            else{
                throw new SQLException("Tipo de persona no soportado: " + persona.getClass().getSimpleName());
            }

            conexion.commit();
            return true;
        }
        catch(SQLException e){
            if(conexion != null){
                conexion.rollback();
            }

            throw e;
        }
        finally{
            if(conexion != null){
                conexion.setAutoCommit(true);
                conexion.close();
            }
        }
    }

    public boolean existeDocumento(Documento documento) throws SQLException{
        String sql = "SELECT p.id " + "FROM persona p " + "INNER JOIN documento d ON p.idDocumento = d.id " + "WHERE d.tipo = ? AND d.numero = ?";

        try(
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ){
            ps.setString(1, documento.getTipo());
            ps.setString(2, documento.getNumero());

            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }

    public Set<Persona> obtenerTodas() throws SQLException, DocumentoInvalidoException{
        Set<Persona> personas = new TreeSet<>();

        try(Connection conexion = ConexionBD.obtenerConexion()){
            personas.addAll(obtenerDirectores(conexion));
            personas.addAll(obtenerAdministrativos(conexion));
            personas.addAll(obtenerProfesores(conexion));
            personas.addAll(obtenerAlumnos(conexion));
        }

        return personas;
    }

    public boolean borrarPorDocumento(Documento documento) throws SQLException{
        String sql = "DELETE p FROM persona p " + "INNER JOIN documento d ON p.idDocumento = d.id " + "WHERE d.tipo = ? AND d.numero = ?";

        try(
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ){
            ps.setString(1, documento.getTipo());
            ps.setString(2, documento.getNumero());
            return ps.executeUpdate() > 0;
        }
    }

    private int obtenerOInsertarDocumento(Connection conexion, Documento documento) throws SQLException{
        Integer idDocumento = buscarIdDocumento(conexion, documento);

        if (idDocumento != null) {
            return idDocumento;
        }

        return insertarDocumento(conexion, documento);
    }

    private Integer buscarIdDocumento(Connection conexion, Documento documento) throws SQLException{
        String sql = "SELECT id FROM documento WHERE tipo = ? AND numero = ?";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, documento.getTipo());
            ps.setString(2, documento.getNumero());

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getInt("id");
                }
            }
        }

        return null;
    }

    private Integer buscarIdPersonaPorDocumento(Connection conexion, int idDocumento) throws SQLException{
        String sql = "SELECT id FROM persona WHERE idDocumento = ?";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idDocumento);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getInt("id");
                }
            }
        }

        return null;
    }

    private int insertarDocumento(Connection conexion, Documento documento) throws SQLException{
        String sql = "INSERT INTO documento (tipo, numero) VALUES (?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, documento.getTipo());
            ps.setString(2, documento.getNumero());
            ps.executeUpdate();

            return obtenerIdGenerado(ps);
        }
    }

    private int insertarPersona(Connection conexion, Persona persona, int idDocumento) throws SQLException{
        String sql = "INSERT INTO persona (nombre, apellido, idDocumento, fechaNacimiento, tipoPersona) " + "VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, idDocumento);
            ps.setDate(4, Date.valueOf(persona.getFechaNacimiento()));
            ps.setString(5, obtenerTipoPersona(persona));
            ps.executeUpdate();

            return obtenerIdGenerado(ps);
        }
    }

    private void insertarEmpleado(Connection conexion, Empleado empleado, int idPersona) throws SQLException{
        String sql = "INSERT INTO empleado (idPersona, fechaCargo, sueldo) VALUES (?, ?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idPersona);
            ps.setDate(2, Date.valueOf(empleado.getFechaCargo()));
            ps.setDouble(3, empleado.getSueldo());
            ps.executeUpdate();
        }
    }

    private void insertarDirector(Connection conexion, Director director, int idPersona) throws SQLException{
        String sql = "INSERT INTO director (idPersona, carrera) VALUES (?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idPersona);
            ps.setString(2, director.getCarrera());
            ps.executeUpdate();
        }
    }

    private void insertarAdministrativo(Connection conexion, int idPersona) throws SQLException{
        String sql = "INSERT INTO administrativo (idPersona) VALUES (?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idPersona);
            ps.executeUpdate();
        }
    }

    private void insertarProfesor(Connection conexion, int idPersona) throws SQLException{
        String sql = "INSERT INTO profesor (idPersona) VALUES (?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idPersona);
            ps.executeUpdate();
        }
    }

    private void insertarAlumno(Connection conexion, Alumno alumno, int idPersona) throws SQLException{
        String sql = "INSERT INTO alumno (idPersona, fechaIngreso) VALUES (?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idPersona);
            ps.setDate(2, Date.valueOf(alumno.getFechaIngreso()));
            ps.executeUpdate();
        }
    }

    private void insertarCursosProfesor(Connection conexion, int idProfesor, List<Integer> idsCursos) throws SQLException{
        String sql = "INSERT INTO profesor_curso (idProfesor, idCurso) VALUES (?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            for(Integer idCurso : idsCursos){
                ps.setInt(1, idProfesor);
                ps.setInt(2, idCurso);
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }

    private void insertarCursosAlumno(Connection conexion, int idAlumno, List<Integer> idsCursos) throws SQLException{
        String sql = "INSERT INTO alumno_curso (idAlumno, idCurso) VALUES (?, ?)";

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            for(Integer idCurso : idsCursos){
                ps.setInt(1, idAlumno);
                ps.setInt(2, idCurso);
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }

    private String obtenerTipoPersona(Persona persona) throws SQLException{
        if(persona instanceof Director){
            return "DIRECTOR";
        }

        if(persona instanceof Administrativo){
            return "ADMINISTRATIVO";
        }

        if(persona instanceof Profesor){
            return "PROFESOR";
        }

        if(persona instanceof Alumno){
            return "ALUMNO";
        }

        throw new SQLException("No se pudo determinar el tipo de persona.");
    }

    private int obtenerIdGenerado(PreparedStatement ps) throws SQLException{
        try(ResultSet rs = ps.getGeneratedKeys()){
            if(rs.next()){
                return rs.getInt(1);
            }
        }

        throw new SQLException("No se pudo obtener el ID generado.");
    }

    private List<Director> obtenerDirectores(Connection conexion) throws SQLException, DocumentoInvalidoException{
        List<Director> directores = new ArrayList<>();
        String sql = "SELECT p.nombre, p.apellido, p.fechaNacimiento, " + "d.tipo AS tipoDocumento, d.numero AS numeroDocumento, " + "e.fechaCargo, e.sueldo, dir.carrera " + "FROM director dir " + "INNER JOIN empleado e ON dir.idPersona = e.idPersona " + "INNER JOIN persona p ON e.idPersona = p.id " + "INNER JOIN documento d ON p.idDocumento = d.id";

        try(PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                directores.add(new Director(rs.getString("nombre"), rs.getString("apellido"), crearDocumento(rs), rs.getDate("fechaNacimiento").toLocalDate(), rs.getDate("fechaCargo").toLocalDate(), rs.getDouble("sueldo"), rs.getString("carrera")));
            }
        }

        return directores;
    }

    private List<Administrativo> obtenerAdministrativos(Connection conexion) throws SQLException, DocumentoInvalidoException{
        List<Administrativo> administrativos = new ArrayList<>();
        String sql = "SELECT p.nombre, p.apellido, p.fechaNacimiento, " + "d.tipo AS tipoDocumento, d.numero AS numeroDocumento, " + "e.fechaCargo, e.sueldo " + "FROM administrativo a " + "INNER JOIN empleado e ON a.idPersona = e.idPersona " + "INNER JOIN persona p ON e.idPersona = p.id " + "INNER JOIN documento d ON p.idDocumento = d.id";

        try(PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                administrativos.add(new Administrativo(rs.getString("nombre"), rs.getString("apellido"), crearDocumento(rs), rs.getDate("fechaNacimiento").toLocalDate(), rs.getDate("fechaCargo").toLocalDate(), rs.getDouble("sueldo")));
            }
        }

        return administrativos;
    }

    private List<Profesor> obtenerProfesores(Connection conexion) throws SQLException, DocumentoInvalidoException{
        List<Profesor> profesores = new ArrayList<>();
        String sql = "SELECT p.id AS idPersona, p.nombre, p.apellido, p.fechaNacimiento, " + "d.tipo AS tipoDocumento, d.numero AS numeroDocumento, " + "e.fechaCargo, e.sueldo " + "FROM profesor pr " + "INNER JOIN empleado e ON pr.idPersona = e.idPersona " + "INNER JOIN persona p ON e.idPersona = p.id " + "INNER JOIN documento d ON p.idDocumento = d.id";

        try(PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idPersona = rs.getInt("idPersona");

                profesores.add(new Profesor(rs.getString("nombre"), rs.getString("apellido"), crearDocumento(rs), rs.getDate("fechaNacimiento").toLocalDate(), rs.getDate("fechaCargo").toLocalDate(), rs.getDouble("sueldo"), obtenerIdsCursosProfesor(conexion, idPersona)));
            }
        }

        return profesores;
    }

    private List<Alumno> obtenerAlumnos(Connection conexion) throws SQLException, DocumentoInvalidoException{
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT p.id AS idPersona, p.nombre, p.apellido, p.fechaNacimiento, " + "d.tipo AS tipoDocumento, d.numero AS numeroDocumento, " + "a.fechaIngreso " + "FROM alumno a " + "INNER JOIN persona p ON a.idPersona = p.id " + "INNER JOIN documento d ON p.idDocumento = d.id";

        try(PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idPersona = rs.getInt("idPersona");

                alumnos.add(new Alumno(rs.getString("nombre"), rs.getString("apellido"), crearDocumento(rs), rs.getDate("fechaNacimiento").toLocalDate(), rs.getDate("fechaIngreso").toLocalDate(), obtenerIdsCursosAlumno(conexion, idPersona)));
            }
        }

        return alumnos;
    }

    private Documento crearDocumento(ResultSet rs) throws SQLException, DocumentoInvalidoException{
        return new Documento(rs.getString("tipoDocumento"), rs.getString("numeroDocumento"));
    }

    private List<Integer> obtenerIdsCursosProfesor(Connection conexion, int idProfesor) throws SQLException{
        String sql = "SELECT idCurso FROM profesor_curso WHERE idProfesor = ? ORDER BY idCurso";
        return obtenerIdsCursos(conexion, sql, idProfesor);
    }

    private List<Integer> obtenerIdsCursosAlumno(Connection conexion, int idAlumno) throws SQLException{
        String sql = "SELECT idCurso FROM alumno_curso WHERE idAlumno = ? ORDER BY idCurso";
        return obtenerIdsCursos(conexion, sql, idAlumno);
    }

    private List<Integer> obtenerIdsCursos(Connection conexion, String sql, int idPersona) throws SQLException{
        List<Integer> idsCursos = new ArrayList<>();

        try(PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, idPersona);

            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()) {
                    idsCursos.add(rs.getInt("idCurso"));
                }
            }
        }

        return idsCursos;
    }
}
