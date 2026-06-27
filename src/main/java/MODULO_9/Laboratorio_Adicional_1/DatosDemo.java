package MODULO_9.Laboratorio_Adicional_1;

import java.util.ArrayList;
import java.util.List;

public class DatosDemo{

    public static List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin@empresa.com", "1234"));
        usuarios.add(new Usuario("ana@empresa.com", "ana123"));
        usuarios.add(new Usuario("carlos@empresa.com", "carlos456"));
        return usuarios;
    }

    /** Colección de empleados administrativos. */
    public static List<Empleado> getEmpleadosAdministrativos(){
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(101, "María González", "Asistente Administrativo", "Recursos Humanos"));
        empleados.add(new Empleado(102, "Jorge Ramírez", "Coordinador Administrativo", "Finanzas"));
        empleados.add(new Empleado(103, "Lucía Fernández", "Secretaria Ejecutiva", "Gerencia"));
        empleados.add(new Empleado(104, "Pedro Sánchez", "Auxiliar Administrativo", "Contabilidad"));
        empleados.add(new Empleado(105, "Sofía Torres", "Jefa de Administración", "Operaciones"));
        return empleados;
    }
}
