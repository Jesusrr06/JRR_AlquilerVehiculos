/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jrr_alquilervehiculos;

/**
 *
 * @author dam1
 */
public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible;

    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
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

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
      public boolean isDisponible(boolean d) {
          return d;
      }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{");
        sb.append("matricula= ").append(matricula);
        sb.append(", marca= ").append(marca);
        sb.append(", modelo= ").append(modelo);
        sb.append(", cilindrada= ").append(cilindrada);
        sb.append(", disponible= ").append(disponible);
        sb.append('}');
        return sb.toString();
    }
    
    
}
