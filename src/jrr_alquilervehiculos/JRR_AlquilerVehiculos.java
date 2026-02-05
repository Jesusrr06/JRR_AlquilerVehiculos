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

    public static Vehiculo[] vehiculo= new Vehiculo[MAX_VEHICULOS];;
    public static Cliente[] clientes= new Cliente[MAX_CLIENTES];;
    public static Alquiler[] alquileres= new Alquiler[MAX_ALQUILERES];;


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
                    String dni;
                    do {
                        dni = ES.leerCadena("Introduzca un Dni valido");
                    } while (!Utilidades.comprobarDni(dni));
                    String nombre = ES.leerCadena("Introduzca su nombre");
                    String direccion = ES.leerCadena("Introduzca su direccion");
                    String localidad = ES.leerCadena("Introduzca su localidad");
                    String codigoPostal = ES.leerCadena("Introduzca su codigo posta");

                    Cliente c = new Cliente(dni, nombre, direccion, localidad, codigoPostal);
                    AñadirClientes(c);
                    break;
                case 2:
                    dni = ES.leerCadena("Introduce el dni del ciente a borrar");
                    borrarCliente(dni);
                    break;
                case 3:
                    for (int i = 0; i < MAX_CLIENTES; i++) {
                        ES.escribir(JRR_AlquilerVehiculos.clientes[i].toString());
                    }

                    break;
                case 4:
                    String matricula = ES.leerCadena("Introduzca la matricula valido");
                    String marca = ES.leerCadena("Introduzca la marca");
                    String modelo = ES.leerCadena("Introduzca el modelo");
                    int cilindrada = ES.leerEntero("Introduzca el numero de cilindradas");
                    Vehiculo v = new Vehiculo(matricula, marca, modelo, cilindrada);
                    AñadirVehiculo(v);
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
                     for (int i = 0; i < MAX_ALQUILERES; i++) {
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
       ES.escribirLn( "3. listar clientes.");
   ES.escribirLn("4. añadir vehículo.");
   ES.escribirLn("5. borrar vehículo.");
   ES.escribirLn("6. listar vehículo.");
   ES.escribirLn("7. abrir un alquiler.");
   ES.escribirLn("8. cerrar un alquiler.");
   ES.escribirLn("9.listar alquileres.");
   ES.escribirLn( "0. salir.");
}

    private static Cliente getCliente(String dnic) {
        for (int i = 0; i < MAX_CLIENTES; i++) {
            if (clientes[i].getDni().equals(dnic)) {
                return clientes[i];

            }
        }

        return null;
    }

    private static Vehiculo getVehiculo(String m) {
        for (int i = 0; i < MAX_VEHICULOS; i++) {
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
            quitarHuecoC(dni);
            ES.escribirLn("INF: Cliente borrado");

        }
    }

    private static void borrarVehiculo(String matricula) {
        boolean b = false;
        Vehiculo v = null;
        for (int i = 0; i < MAX_ALQUILERES && !b; i++) {
            if (alquileres[i].getTurismo().getMatricula().equals(matricula)) {

                alquileres[i].getTurismo().setDisponible(b);
                b = true;
            }

        }
        if (b) {
            quitarHuecoT(matricula);
            ES.escribirLn("INF: Vehiculo borrado");

        }
    }

    private static void quitarHuecoC(String dni) {
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

    private static void quitarHuecoT(String matricula) {
        boolean b = false;
        Vehiculo v = null;
        for (int i = 0; i < MAX_ALQUILERES && !b; i++) {
            if (alquileres[i].getTurismo().getMatricula().equals(matricula)) {
                vehiculo[i] = null;
                vehiculo[i] = vehiculo[MAX_VEHICULOS + 1];
                vehiculo[MAX_VEHICULOS + 1] = null;
                nVehiculos--;
                b = true;
            }

        }

    }

    private static void nuevoAlquiler(Cliente c, Vehiculo v) {
        boolean b = false;
        if (v.isDisponible()) {
            alquileres[nAlquileres] = new Alquiler(c, v);
            nAlquileres++;
            ES.escribir("FNF Alquiler creado");
        } else {

            ES.escribir("vehicilo no disponible");
        }

    }

    private static void insertarAlquiler(Cliente c, Vehiculo v) {
        ES.escribirLn("insertand alquiler");

        nuevoAlquiler(c, v);

    }

    private static void cerrarAlquiler(Cliente c, Vehiculo v) {
        ES.escribirLn("Borrando Alquiler ");
        for (int i = 0; i < MAX_ALQUILERES; i++) {
            if(alquileres[i].getCliente().equals(c) && alquileres[i].getTurismo().equals(v)){
            alquileres[i]= null;
            }
            
        }

    }
}
