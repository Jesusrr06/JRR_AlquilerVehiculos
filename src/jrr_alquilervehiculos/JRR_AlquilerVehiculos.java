/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jrr_alquilervehiculos;

import utiles.ES;
import utiles.Utilidades;

/**
 *
 * @author Jesus
 */
public class JRR_AlquilerVehiculos {

    private final static int MAX_ALQUILERES = 50;
    private static int nAlquileres = 0;

    private final static int MAX_CLIENTES = 50;
    private static int nClientes = 0;

    private final static int MAX_VEHICULOS = 50;
    private static int nVehiculos = 0;

    public static Vehiculo[] vehiculo;
    public static Cliente[] clientes;
    public static Alquiler[] alquileres;

    public JRR_AlquilerVehiculos() {
        vehiculo = new Vehiculo[MAX_VEHICULOS];
        clientes = new Cliente[MAX_CLIENTES];
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion;

        do {
            menu();
            opcion = ES.leerEntero("Introduzca una opcion");

            switch (opcion) {
                case 1:
                    String dni = ES.leerCadena("Introduzca un Dni valido");
                    String nombre = ES.leerCadena("Introduzca su nombre");
                    String localidad = ES.leerCadena("Introduzca su localidad");
                    String codigoPostal = ES.leerCadena("Introduzca su codigo posta");

                    Cliente c = new Cliente(dni, nombre, localidad, codigoPostal);
                    AñadirClientes(c);
                    break;
                case 2:
                    dni = ES.leerCadena("Introduce el dni del ciente a borrar");
                    borrarCliente(dni);
                    break;
                case 3:
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        ES.escribir(clientes[i].toString());
                    }

                    break;
                case 4:
                     String matricula = ES.leerCadena("Introduzca un Dni valido");
                    String  marca = ES.leerCadena("Introduzca su nombre");
                    String modelo = ES.leerCadena("Introduzca su localidad");
                    int cilindrada = ES.leerEntero("Introduzca su codigo posta");
                    Vehiculo v= new Vehiculo(matricula, marca, modelo, cilindrada);
                    AñadirVehiculo(v);
                    break;
                case 5:
                    
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    break;

                default:
                    throw new AssertionError();
            }

        } while (opcion != 0);

    }

    public static void menu() {
        ES.escribir("1.añadir cliente,"
                + "2. borrar cliente,"
                + "3. listar clientes,"
                + "4. añadir vehículo,"
                + "5. borrar vehículo,"
                + "6. listar vehículo,"
                + "7. abrir un alquiler,"
                + "8. cerrar un alquiler,"
                + "9.listar alquileres "
                + "0. salir");
    }

    private static Cliente getCliente(String dnic) {
        for (int i = 0; i < 10; i++) {
            if (clientes[i].getDni().equals(dnic)) {
                return clientes[i];

            }
        }

        return null;
    }

    private static Vehiculo getVehiculo(String m) {
        for (int i = 0; i < 10; i++) {
            if (vehiculo[i].getMatricula().equals(m)) {
                return vehiculo[i];

            }
        }

        return null;
    }

    private static void AñadirClientes(Cliente c) {
        boolean b = false;
        for (int i = 0; i < MAX_CLIENTES && !b; i++) {
            if (nClientes < MAX_CLIENTES) {
                if (!clientes[i].getDni().equals(c.getDni())) {
                    if (clientes[i] == null) {
                        clientes[i] = c;
                        nClientes++;
                        b = true;
                        ES.escribirLn("Cliente añadido con exito");
                    }
                } else {
                    ES.escribirLn("Ya existe ese dni");
                }
            } else {

            }
        }

    }
     private static void AñadirVehiculo(Vehiculo v) {
        boolean b = false;
        for (int i = 0; i < MAX_VEHICULOS && !b; i++) {
            if (nVehiculos < MAX_VEHICULOS) {
                if (!vehiculo[i].getMatricula().equals(v.getMatricula())) {
                    if (vehiculo[i] == null) {
                        vehiculo[i] = v;
                        nVehiculos++;
                        b = true;
                        ES.escribirLn("Cliente añadido con exito");
                    }
                } else {
                    ES.escribirLn("Ya existe ese dni");
                }
            } else {

            }
        }

    }

    private static void borrarCliente(String dni) {
        boolean b = false;
        Cliente c = null;
        for (int i = 0; i < MAX_ALQUILERES && !b; i++) {
            if (alquileres[i].getCliente().getDni().equals(dni)) {

                alquileres[i].getCliente().setBaja(b);
                b = true;
            }

        }
        if (b) {
            quitarHueco(dni);
            ES.escribirLn("INF: Cliente borrado");

        }
    }

    private static void quitarHueco(String dni) {
        boolean b = false;
        Cliente c = null;
        for (int i = 0; i < MAX_ALQUILERES && !b; i++) {
            if (alquileres[i].getCliente().getDni().equals(dni)) {
                clientes[i] = null;
                clientes[i] = clientes[MAX_CLIENTES + 1];
                clientes[MAX_CLIENTES + 1] = null;
                nClientes--;
                b = true;
            }

        }

    }

    private static void nuevoAlquiler(Cliente c, Vehiculo v) {
        boolean b = false;
        if (v.isDisponible()) {
            alquileres[MAX_ALQUILERES] = new Alquiler(c, v);
            nAlquileres++;
            ES.escribir("FNF Alquiler creado");
        } else {

            ES.escribir("vehicilo no disponible");
        }

    }

    private static void insertarAlquiler() {
        ES.escribirLn("insertand alquiler");
        String dni, matricula;
        Cliente c;
        Vehiculo v;

        do {
            dni = ES.leerCadena("Introduzca el dni");
        } while (Utilidades.comprobarDni(dni));

        do {
            matricula = ES.leerCadena("Introduzca la matricula");

        } while (Utilidades.comprobarMatricula(matricula));
        c = getCliente(dni);
        if (c != null) {

            v = getVehiculo(matricula);
            if (v != null) {
                nuevoAlquiler(c, v);
            } else {
                ES.escribirLn("Error: vehhiculo no existe");
            }

        } else {
            ES.escribirLn("Error: Cliente no exisate");
        }

    }
}
