/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author jesus
 */
public abstract class Turismo extends Vehiculo {

    protected int npuertas;
    protected Enumerados.TipoCombustible combustible;

    public Turismo(int npuertas, Enumerados.TipoCombustible combustible, String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo, cilindrada);
        this.npuertas = npuertas;
        this.combustible = combustible;
    }

    public int getNpuertas() {
        return npuertas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());

        sb.append("npuertas=").append(npuertas);
        sb.append("\n");
        sb.append(", combustible=").append(combustible);
        sb.append("\n");
        return sb.toString();
    }

}
