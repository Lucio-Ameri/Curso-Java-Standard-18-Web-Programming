package MODULO_3.Laboratorio_Adicional_2;

public class Profesor extends Persona{
    private Double pago;

    public Profesor(Integer id, String nombre, String apellido, Documento documento, Integer edad, Double pago) {
        super(id, nombre, apellido, documento, edad);
        this.pago = pago;
    }

    public Double getPago(){
        return pago;
    }

    public void setPago(Double pago){
        this.pago = pago;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(". Pago: $%.2f", pago);
    }
}
