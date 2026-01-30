/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author dam1
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigoPostal;
    private boolean baja;

    public Cliente(String dni, String nombre,String direccion ,String localidad, String codigoPostal) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion= direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.baja = false;
    }

    public Cliente(Cliente c) {
        this.dni = c.dni;
        this.nombre = c.nombre;
        this.localidad = c.localidad;
        this.codigoPostal = c.codigoPostal;
        c.baja = false;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("dni=").append(dni);
        sb.append(", nombre=").append(nombre);
        sb.append(", localidad=").append(localidad);
        sb.append(", codigoPostal=").append(codigoPostal);
        sb.append('}');
        return sb.toString();
    }

}
