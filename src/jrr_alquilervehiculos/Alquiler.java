/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.Date;

/**
 *
 * @author dam1
 */
public class Alquiler {

    final private DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    final private double PRECIO_DIA = 30;
    private LocalDateTime fecha;
    private int dias;
    private Vehiculo turismo;
    private Cliente cliente;

    public Alquiler(Vehiculo turismo, Cliente cliente) {
        this.turismo = turismo;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getTurismo() {
        return turismo;
    }

    public LocalDateTime getFecha() {
        return fecha;

    }

    public int getDias() {
        return dias;
    }

    public double precioAlquiler() {

        return (double) PRECIO_DIA * this.dias + this.turismo.getCilindrada() / 100;
    }

    private int diferenciaDias(LocalDateTime fecha1) {
        LocalDateTime l = LocalDateTime.now();
        return (int) ChronoUnit.DAYS.between(fecha1, l);

    }

    public void cerrar() 
    {
        this.getTurismo().setDisponible(true);

        this.dias = diferenciaDias(this.fecha) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alquiler{");
        sb.append("FORMATO_FECHA=").append(FORMATO_FECHA);
        sb.append(", PRECIO_DIA=").append(PRECIO_DIA);
        sb.append(", fecha=").append(fecha);
        sb.append(", dias=").append(dias);
        sb.append(", turismo=").append(turismo);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }

}
