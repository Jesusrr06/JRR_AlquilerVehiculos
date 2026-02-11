/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author jesus
 */
public class Furgoneta extends Mercancias {

    private boolean refrigerado;
    private Enumerados.Tamano tamanio;

    public Furgoneta(boolean refrigerado, Enumerados.Tamano tamanio, int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) {
        super(pma, volumen, matricula, marca, modelo, cilindrada);
        this.refrigerado = refrigerado;
        this.tamanio = tamanio;
    }

    public Furgoneta(boolean refrigerado, Enumerados.Tamano tamanio, int pma, int volumen, Vehiculo v) {
        super(pma, volumen, v);
        this.refrigerado = refrigerado;
        this.tamanio = tamanio;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public Enumerados.Tamano getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("refrigerado=").append(refrigerado);
        sb.append(", tamanio=").append(tamanio);
        sb.append('}');
        return sb.toString();
    }

}
