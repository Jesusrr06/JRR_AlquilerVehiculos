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
    private String localidad;
    private String codigoPostal;

    public Cliente(String dni, String nombre, String localidad, String codigoPostal) {
        this.dni = dni;
        this.nombre = nombre;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }
       public Cliente(Cliente c) {
        this.dni = c.dni;
        this.nombre = c.nombre;
        this.localidad = c.localidad;
        this.codigoPostal = c.codigoPostal;
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
