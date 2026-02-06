/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jrr_alquilervehiculos;

import utiles.ES;
import utiles.Utilidades;
import java.util.Scanner;

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

    private static Vehiculo[] vehiculo = new Vehiculo[MAX_VEHICULOS];
    ;
    private static Cliente[] clientes = new Cliente[MAX_CLIENTES];
    ;
    private static Alquiler[] alquileres = new Alquiler[MAX_ALQUILERES];

    ;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clientes[0] = new Cliente("49526422Q", "Jesus", "11123", "Doshermansa", "4172");

        vehiculo[0] = new Vehiculo("123123", "Totyota", "V1", 42);
        int opcion;

        do {
            menu();
            opcion = ES.leerEntero("Introduzca una opcion");

            switch (opcion) {
                case 1:
                    String dni;
                    do {
                        dni = ES.leerCadena("Introduzca un Dni valido");
                    } while (!Utilidades.comprobarDni(dni));
                    String nombre = ES.leerCadena("Introduzca su nombre");
                    String direccion = ES.leerCadena("Introduzca su direccion");
                    String localidad = ES.leerCadena("Introduzca su localidad");
                    String codigoPostal = ES.leerCadena("Introduzca su codigo posta");

                    Cliente c = new Cliente(dni, nombre, direccion, localidad, codigoPostal);
                    AnadirClientes(c);
                    break;
                case 2:
                    dni = ES.leerCadena("Introduce el dni del ciente a borrar");
                    borrarCliente(dni);
                    break;
                case 3:
                    listarClientes();

                    break;
                case 4:
                    String matricula = ES.leerCadena("Introduzca la matricula valido");
                    String marca = ES.leerCadena("Introduzca la marca");
                    String modelo = ES.leerCadena("Introduzca el modelo");
                    int cilindrada = ES.leerEntero("Introduzca el numero de cilindradas");
                    Vehiculo v = new Vehiculo(matricula, marca, modelo, cilindrada);
                    AnadirVehiculo(v);
                    break;
                case 5:
                    matricula = ES.leerCadena("Introduce la matricula del coche a borrar");
                    borrarVehiculo(matricula);
                    break;
                case 6:
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        ES.escribir(vehiculo[i].toString());
                    }

                    break;
                case 7:
                    c = null;
                    v = null;
                    do {
                        dni = ES.leerCadena("Introduzca el dni del cliente");
                        if (Utilidades.comprobarDni(dni)) {
                            c = getCliente(dni);
                        } else {

                            ES.escribirLn("Error: Cliente no exisate");
                        }
                    } while (!Utilidades.comprobarDni(dni));

                    matricula = ES.leerCadena("Introduce la matricula del coche");
                    if (Utilidades.comprobarDni(dni)) {
                        v = getVehiculo(matricula);
                    } else {
                        ES.escribirLn("Error: vehiculo no existe");
                    }

                    insertarAlquiler(c, v);
                    break;
                case 8:
                    c = null;
                    v = null;
                    do {
                        dni = ES.leerCadena("Introduzca el dni del cliente");
                        if (Utilidades.comprobarDni(dni)) {
                            c = getCliente(dni);
                        } else {

                            ES.escribirLn("Error: Cliente no exisate");
                        }
                    } while (!Utilidades.comprobarDni(dni));

                    matricula = ES.leerCadena("Introduce la matricula del coche");
                    if (Utilidades.comprobarDni(dni)) {
                        v = getVehiculo(matricula);
                    } else {
                        ES.escribirLn("Error: vehiculo no existe");
                    }

                    insertarAlquiler(c, v);

                    break;
                case 9:
                    for (int i = 0; i < nAlquileres; i++) {
                        ES.escribir(alquileres[i].toString());
                    }

                    break;

                default:

            }

        } while (opcion != 0);

    }

    public static void menu() {
        ES.escribirLn("1.añadir cliente.");
        ES.escribirLn("2. borrar cliente.");
        ES.escribirLn("3. listar clientes.");
        ES.escribirLn("4. añadir vehículo.");
        ES.escribirLn("5. borrar vehículo.");
        ES.escribirLn("6. listar vehículo.");
        ES.escribirLn("7. abrir un alquiler.");
        ES.escribirLn("8. cerrar un alquiler.");
        ES.escribirLn("9.listar alquileres.");
        ES.escribirLn("0. salir.");
    }

    private static Cliente getCliente(String dnic) {
        for (int i = 0; i <= nClientes; i++) {
            if (clientes[i].getDni().equals(dnic)) {
                return clientes[i];

            }
        }

        return null;
    }

    private static Vehiculo getVehiculo(String m) {
        for (int i = 0; i <= nVehiculos; i++) {
            if (vehiculo[i].getMatricula().equals(m)) {
                return vehiculo[i];

            }
        }

        return null;
    }

    private static void AnadirClientes(Cliente c) {
        boolean b = false;
        if (nClientes < MAX_CLIENTES) {
            if (getCliente(c.getDni()) == null) {

                clientes[nClientes + 1] = c;
                b = true;

                nClientes++;
                ES.escribirLn("Cliente añadido con exito");
            }
        } else {
            System.out.println("Capacidad al maximo");
        }

    }

    private static void AnadirVehiculo(Vehiculo v) {
        boolean b = false;

        if (nVehiculos < MAX_VEHICULOS) {
            if (getCliente(v.getMatricula()) == null) {

                if (vehiculo[nClientes + 1] == null) {
                    vehiculo[nClientes + 1] = v;
                    nVehiculos++;
                    b = true;
                    ES.escribirLn("Cliente añadido con exito");
                }

            } else {
                ES.escribirLn("Capacidad al maximo");
            }
        }
    }

    private static void borrarCliente(String dni) {
        boolean b = false;
        Cliente c = null;

        if (getCliente(dni) != null) {

            getCliente(dni).setBaja(b);
            b = true;

        }

        if (b) {
            quitarHuecoC(dni);
            ES.escribirLn("INF: Cliente borrado");

        }
    }

    private static void borrarVehiculo(String matricula) {
        boolean b = false;
        Vehiculo v = null;
        for (int i = 0; i < nAlquileres && !b; i++) {
            if (alquileres[i] != null) {
                if (alquileres[i].getTurismo().getMatricula().equals(matricula)) {
                    alquileres[i].getTurismo().setDisponible(b);
                    b = true;

                } else {

                }

            }

        }
        if (b) {
            quitarHuecoT(matricula);
            ES.escribirLn("INF: Vehiculo borrado");

        }
    }

    private static void quitarHuecoC(String dni) {
        boolean b = false;
        for (int i = 0; i < MAX_ALQUILERES && !b; i++) {
                if (alquileres[i].getCliente().getDni().equals(dni)) {
                    clientes[i] = null;
                    clientes[i] = clientes[nClientes + 1];
                    clientes[nClientes + 1] = null;
                    nClientes--;
                    b = true;
                }
            

        }

    }

    private static void quitarHuecoT(String matricula) {
        boolean b = false;
        Vehiculo v = null;
        for (int i = 0; i < nVehiculos && !b; i++) {
            if (vehiculo[i] != null) {
                if (alquileres[i].getTurismo().getMatricula().equals(matricula)) {
                    vehiculo[i] = null;
                    vehiculo[i] = vehiculo[nVehiculos + 1];
                    vehiculo[nVehiculos + 1] = null;
                    nVehiculos--;
                    b = true;
                }
            }

        }

    }

    private static void nuevoAlquiler(Cliente c, Vehiculo v) {
        boolean b = false;
        if (c != null && v != null) {
            if (v.isDisponible()) {
                alquileres[nAlquileres] = new Alquiler(c, v);
                nAlquileres++;
                ES.escribir("FNF Alquiler creado");
            } else {

                ES.escribir("vehicilo no disponible");
            }
        }
    }

    private static void insertarAlquiler(Cliente c, Vehiculo v) {
        ES.escribirLn("insertand alquiler");

        nuevoAlquiler(c, v);

    }

    private static void cerrarAlquiler(Cliente c, Vehiculo v) {
        ES.escribirLn("Borrando Alquiler ");
        for (int i = 0; i < MAX_ALQUILERES; i++) {
            if (alquileres[i] != null) {
                if (alquileres[i].getCliente().equals(c) && alquileres[i].getTurismo().equals(v)) {
                    alquileres[i] = null;
                }
            }

        }

    }

    private static void listarClientes() {
        boolean b = false;
        for (int i = 0; i < MAX_CLIENTES && !b; i++) {
            if (clientes[i] != null) {
                ES.escribirLn(clientes[i].toString());

            } else {
                b = true;
                System.out.println(" no hay màs ");
            }
        }
    }
}
