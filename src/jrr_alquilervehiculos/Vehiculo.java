/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

import java.io.Serializable;

/**
 *
 * @author dam1
 */
public abstract class Vehiculo implements Serializable{

    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;
    private boolean baja;


    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        disponible= true;
        baja= false;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(matricula);
        sb.append("#");
        sb.append("").append(marca);
                sb.append("#");

        sb.append("").append(modelo);
        sb.append("#");
        sb.append("#").append(cilindrada);
        sb.append("#");
        sb.append("").append(disponible);
        sb.append("#");
        sb.append("#").append(baja);
        return sb.toString();
    }

   

}
