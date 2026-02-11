/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author jesus
 */
public class Familiar extends Turismo {

    private int nPlazas;
    private boolean sillaBebe;

    public Familiar(int nPlazas, boolean sillaBebe, int npuertas, Enumerados.TipoCombustible combustible, String matricula, String marca, String modelo, int cilindrada) {
        super(npuertas, combustible, matricula, marca, modelo, cilindrada);
        this.nPlazas = nPlazas;
        this.sillaBebe = sillaBebe;
    }

    public int getnPlazas() {
        return nPlazas;
    }

    public boolean isSillaBebe() {
        return sillaBebe;
    }

    public void setSillaBebe(boolean sillaBebe) {
        this.sillaBebe = sillaBebe;
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
        sb.append("nPlazas=").append(nPlazas);
        sb.append(", sillaBebe=").append(sillaBebe);
        sb.append('}');
        return sb.toString();
    }

}
