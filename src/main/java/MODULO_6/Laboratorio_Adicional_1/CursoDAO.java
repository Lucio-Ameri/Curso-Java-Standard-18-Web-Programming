package MODULO_6.Laboratorio_Adicional_1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO{

    public void cargarCursosIniciales() throws SQLException{
        insertarCursoSiNoExiste("Programación I");
        insertarCursoSiNoExiste("Programación Orientada a Objetos");
        insertarCursoSiNoExiste("HTML");
        insertarCursoSiNoExiste("CSS");
        insertarCursoSiNoExiste("JavaScript");
        insertarCursoSiNoExiste("Base de Datos I");
        insertarCursoSiNoExiste("SQL");
    }

    public Curso insertarCursoSiNoExiste(String nombreCurso) throws SQLException{
        Curso cursoExistente = buscarPorNombre(nombreCurso);

        if(cursoExistente != null){
            return cursoExistente;
        }

        String sql = "INSERT INTO curso (nombreCurso) VALUES (?)";

        try(
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setString(1, nombreCurso);
            ps.executeUpdate();

            try(ResultSet rs = ps.getGeneratedKeys()){
                if(rs.next()){
                    return new Curso(rs.getInt(1), nombreCurso);
                }
            }
        }

        throw new SQLException("No se pudo obtener el ID generado para el curso: " + nombreCurso);
    }

    public Curso buscarPorNombre(String nombreCurso) throws SQLException{
        String sql = "SELECT idCurso, nombreCurso FROM curso WHERE UPPER(nombreCurso) = UPPER(?)";

        try(
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ){
            ps.setString(1, nombreCurso == null ? "" : nombreCurso.trim());

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Curso(rs.getInt("idCurso"), rs.getString("nombreCurso"));
                }
            }
        }

        return null;
    }

    public Curso buscarPorId(int idCurso) throws SQLException{
        String sql = "SELECT idCurso, nombreCurso FROM curso WHERE idCurso = ?";

        try(
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)
        ){
            ps.setInt(1, idCurso);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new Curso(rs.getInt("idCurso"), rs.getString("nombreCurso"));
                }
            }
        }

        return null;
    }

    public List<Curso> obtenerTodos() throws SQLException{
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT idCurso, nombreCurso FROM curso ORDER BY idCurso";

        try(
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){
            while(rs.next()){
                cursos.add(new Curso(rs.getInt("idCurso"), rs.getString("nombreCurso")));
            }
        }

        return cursos;
    }

    public List<Integer> obtenerIdsPorNombres(String... nombresCursos) throws SQLException{
        List<Integer> idsCursos = new ArrayList<>();

        for(String nombreCurso : nombresCursos){
            Curso curso = buscarPorNombre(nombreCurso);

            if(curso == null){
                throw new SQLException("No existe el curso en la base de datos: " + nombreCurso);
            }

            idsCursos.add(curso.getId());
        }

        return idsCursos;
    }
}
