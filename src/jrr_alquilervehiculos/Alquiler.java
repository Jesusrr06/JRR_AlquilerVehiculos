/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author dam1
 */
public class Alquiler {
   final private DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
    final private double    PRECIO_DIA = 0;
private   LocalDateTime fecha;
    final int MILISEGUNDOS_DIA = 0;
    private int dias;
    private Vehiculo turismo;
    private  Cliente cliente;

    public Alquiler(Vehiculo turismo, Cliente cliente) {
        this.turismo = turismo;
        this.cliente = cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
      
    }

   
    public int getDias() {
        return dias;
    }

    public Vehiculo getTurismo() {
        return turismo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alquiler{");
        sb.append("FORMATO_FECHA=").append(FORMATO_FECHA);
        sb.append(", PRECIO_DIA=").append(PRECIO_DIA);
        sb.append(", MILISEGUNDOS_DIA=").append(MILISEGUNDOS_DIA);
        sb.append(", fecha=").append(fecha);
        sb.append(", dias=").append(dias);
        sb.append(", turismo=").append(turismo);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }

    
    
 


}
