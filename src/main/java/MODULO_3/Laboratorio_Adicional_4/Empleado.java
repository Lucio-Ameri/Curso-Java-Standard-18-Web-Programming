package MODULO_3.Laboratorio_Adicional_4;

import java.time.LocalDate;

public abstract class Empleado extends Persona {
    private LocalDate fechaCargo;
    private Double sueldo;

    public Empleado(String nombre, String apellido, Documento documento, LocalDate fechaNacimiento, LocalDate fechaCargo, Double sueldo){
        super(nombre, apellido, documento, fechaNacimiento);

        this.fechaCargo = fechaCargo;
        this.sueldo = sueldo;
    }

    public LocalDate getFechaCargo(){
        return fechaCargo;
    }

    public Double getSueldo(){
        return sueldo;
    }

    @Override
    public String toString(){
        return String.format("%s Fecha Inicio de Cargo: %s.  Sueldo: %.2f", super.toString(), fechaCargo.toString(), sueldo);
    }
}
