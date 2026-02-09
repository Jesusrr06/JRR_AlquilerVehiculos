/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author jesus
 */
public class Deportivo extends Turismo {

    private boolean descapotable;
    private Enumerados.CajaCambio cambio;

   

    public Deportivo(boolean descapotable, Enumerados.CajaCambio cambio, int npuertas, Enumerados.TipoCombustible combustible, String matricula, String marca, String modelo, int cilindrada) {
        super(npuertas, combustible, matricula, marca, modelo, cilindrada);
        this.descapotable = descapotable;
        this.cambio = cambio;
    }

    public boolean isDescapotable() {
        return descapotable;
    }

    public Enumerados.CajaCambio getCambio() {
        return cambio;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public Enumerados.TipoCombustible getCombustible() {
        return combustible;
    }

 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("descapotable=").append(descapotable);
        sb.append(", cambio=").append(cambio);
        sb.append('}');
        return sb.toString();
    }

}
