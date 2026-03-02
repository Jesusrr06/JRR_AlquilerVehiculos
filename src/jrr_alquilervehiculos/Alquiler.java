/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import utiles.ES;

/**
 *
 * @author dam1
 */
public class Alquiler implements Serializable {

    final private DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    final private double PRECIO_DIA = 30;
    private LocalDateTime fechainicio;
    private int dias;
    private Vehiculo turismo;
    private Cliente cliente;

    public Alquiler(Cliente cliente, Vehiculo turismo) {
        this.cliente = cliente;
        this.turismo = turismo;
        this.fechainicio = LocalDateTime.now();

    }

    public void setFecha(LocalDateTime fecha) {
        this.fechainicio = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getTurismo() {
        return turismo;
    }

    public LocalDateTime getFecha() {
        return fechainicio;

    }

    public int getDias() {
        return dias;
    }

    public double precioAlquiler() {
        if (this.dias == 0) {
            this.dias = 1;
        }
        return (double) PRECIO_DIA * this.dias + (this.turismo.getCilindrada() / 100);
    }

    private int diferenciaDias(LocalDateTime fecha1) {
        LocalDateTime l = LocalDateTime.now();
        return (int) ChronoUnit.DAYS.between(fecha1, l);

    }

    public void cerrar() {
        this.getTurismo().setDisponible(true);
        double precioal = this.precioAlquiler();
        this.dias = diferenciaDias(this.fechainicio) + 1;

        ES.escribir("Su alquiler sale a " + precioal + "€ Despues de " + this.dias + "  dias");

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(PRECIO_DIA);
        sb.append("#").append(fechainicio.format(FORMATO_FECHA));
        sb.append("#").append(dias);
        sb.append("#").append(turismo);
        sb.append("#").append(cliente);
        sb.append("");
        return sb.toString();
    }

    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(turismo.getMatricula());
        sb.append("#").append(cliente.getDni());
        sb.append("#").append(fechainicio.format(FORMATO_FECHA));

        sb.append("#");
        return sb.toString();
    }
}
