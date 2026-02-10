/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author jesus
 */
public abstract class Mercancias extends Vehiculo {

    private int pma;
    private int volumen;

    public Mercancias(int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo, cilindrada);
        this.pma = pma;
        this.volumen = volumen;
    } 

    public Mercancias(int pma, int volumen, Vehiculo v) {
         super(v.getMatricula(), v.getMarca(), v.getModelo(), v.getCilindrada());
        this.pma = pma;
        this.volumen = volumen;

    }

    public int getPma() {
        return pma;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("pma").append(pma);
        sb.append(", volumen=").append(volumen);
        return sb.toString();
    }

}
