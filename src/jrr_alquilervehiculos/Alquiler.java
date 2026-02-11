/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author dam1
 */
public class Alquiler implements Serializable{

    final private DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyyMMdd");

    final private double PRECIO_DIA = 30;
    private LocalDateTime fecha;
    private int dias;
    private Vehiculo turismo;
    private Cliente cliente;

    public Alquiler(Cliente cliente, Vehiculo turismo) {
        this.cliente = cliente;
        this.turismo = turismo;

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

    public void cerrar() {
        this.getTurismo().setDisponible(true);

        this.dias = diferenciaDias(this.fecha) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(FORMATO_FECHA);
        sb.append("\n Precio").append(PRECIO_DIA);
        sb.append("\n").append(fecha);
        sb.append("\n numDias ").append(dias);
        sb.append("\nVehiculo=").append(turismo);
        sb.append(" cliente=").append(cliente);
        
        return sb.toString();
    }

}
