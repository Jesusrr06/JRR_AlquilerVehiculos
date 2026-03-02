/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jrr_alquilervehiculos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import utiles.ES;
import utiles.Utilidades;

/**
 *
 * @author Jesus
 */
public class JRR_AlquilerVehiculos {

    private final static String RUTA_A = "Alquileres_JRR.txt";
    private final static String RUTA_V = "Vehiculos_JRR.txt";
    private final static String RUTA_C = "Clientes_JRR.txt";

    private final static int MAX_ALQUILERES = 50;
    private static int nAlquileres = 0;

    private final static int MAX_CLIENTES = 50;
    private static int nClientes = 0;

    private final static int MAX_VEHICULOS = 50;
    private static int nVehiculos = 0;

    private static Vehiculo[] vehiculos = new Vehiculo[MAX_VEHICULOS];

    private static Cliente[] clientes = new Cliente[MAX_CLIENTES];

    private static Alquiler[] alquileres = new Alquiler[MAX_ALQUILERES];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion;
        String dni;
        String matricula;
        boolean b = ES.leerBoolean("Desea cargar los datos anteriores? (Solo falla la fecha)");
        if (b) {
            cargarClientestxt();
            cargarVehiculostxt();
            cargarAlquilerestxt(); // la Fecha da problemas

        }
        do {
            menu();
            opcion = ES.leerEntero("Introduzca una opcion: \n");

            switch (opcion) {
                case 1:
                    Cliente c = insertarClientes();
                    AnadirClientes(c);
                    break;
                case 2:
                    dni = ES.leerCadena("Introduce el dni del ciente a borrar \n");
                    darBajaCliente(dni);
                    break;
                case 3:
                    listarClientes();

                    break;
                case 4:
                    listarClientesBaja();
                    break;
                case 5:

                    Vehiculo v = insertarVehiculo();
                    AnadirVehiculo(v);
                    break;
                case 6:
                    matricula = ES.leerCadena("Introduce la matricula del coche a borrar \n");
                    darBajaVehiculo(matricula);
                    break;
                case 7:
                    listarVehiculos();

                    break;
                case 8:
                    listarVehiculosBaja();
                    break;

                case 9:
                    c = null;
                    v = null;
                    do {
                        dni = ES.leerCadena("Introduzca el dni del cliente ");
                        if (Utilidades.comprobarDni(dni)) {
                            c = getClientes(dni);
                        } else {
                            ES.escribirLn("Error: Cliente no exisate");
                        }
                    } while (!Utilidades.comprobarDni(dni));

                    matricula = ES.leerCadena("Introduce la matricula del coche ");
                    if (Utilidades.comprobarDni(dni)) {
                        v = getVehiculos(matricula);
                    } else {
                        ES.escribirLn("Error: vehiculo no existe");
                    }

                    insertarAlquiler(c, v);
                    break;
                case 10:
                    c = null;
                    v = null;
                    do {
                        dni = ES.leerCadena("Introduzca el dni del cliente \n");
                        if (Utilidades.comprobarDni(dni)) {
                            c = getClientes(dni);
                        } else {

                            ES.escribirLn("Error: Cliente no exisate");
                        }
                    } while (!Utilidades.comprobarDni(dni));

                    matricula = ES.leerCadena("Introduce la matricula del coche\n");
                    if (Utilidades.comprobarMatricula(matricula)) {
                        v = getVehiculos(matricula);
                    } else {
                        ES.escribirLn("Error: vehiculo no existe");
                    }

                    cerrarAlquiler(c, v);

                    break;
                case 11:
                    listarAlquileres();

                    break;
                case 12:
                    guardarDatos();
                    break;

                case 13:
                    CargarDatos();

                    break;
                default:
            }
        } while (opcion != 0);

    }

    public static void menu() {
        ES.escribirLn("1.anadir cliente.");
        ES.escribirLn("2. Dar de baja a un cliente.");
        ES.escribirLn("3. listar clientes.");
        ES.escribirLn("4. listar clientes de baja.");

        ES.escribirLn("5. anadir vehiculo.");
        ES.escribirLn("6. Dar de baja a un vehiculo.");
        ES.escribirLn("7. listar vehiculos.");
        ES.escribirLn("8. listar vehiculos de baja.");

        ES.escribirLn("9. abrir un alquiler.");
        ES.escribirLn("10. cerrar un alquiler.");
        ES.escribirLn("11.listar alquileres.");
        ES.escribirLn("12. Guardar datos alquiler/Cliente/Vehiculos.");
        ES.escribirLn("13. Cargar datos alquiler/clientes/Vehiculos.");

        ES.escribirLn("0. salir.");

    }

    private static Cliente getClientes(String dnic) {
        for (int i = 0; i <= nClientes; i++) {
            if (clientes[i] == null) {
                return null;
            } else if (clientes[i].getDni().equals(dnic)) {
                return clientes[i];

            }
        }

        return null;
    }

    private static Vehiculo getVehiculos(String m) {
        for (int i = 0; i <= nVehiculos; i++) {
            if (vehiculos[i] == null) {
                return null;
            } else if (vehiculos[i].getMatricula().equals(m)) {
                return vehiculos[i];

            }
        }

        return null;
    }

    private static void AnadirClientes(Cliente c) {
        boolean b = false;
        if (nClientes < MAX_CLIENTES) {
            if (getClientes(c.getDni()) == null && !b) {

                clientes[nClientes] = c;

                nClientes++;
                ES.escribirLn("Cliente añadido con exito");
            } else if (getClientes(c.getDni()).equals(c)) {
                ES.escribirLn("Ya esxiste alguien con ese dni");
                b = true;
            }
        } else {
            System.out.println("Capacidad al maximo");
        }

    }

    private static void AnadirVehiculo(Vehiculo v) {
        boolean b = false;

        if (nVehiculos < MAX_VEHICULOS) {
            if (getVehiculos(v.getMatricula()) == null && !b) {

                vehiculos[nVehiculos] = v;
                nVehiculos++;
                ES.escribirLn("Vehiculo añadido con exito");

            } else if (getVehiculos(v.getMatricula()) != null) {
                if (getVehiculos(v.getMatricula()).equals(v)) {
                    ES.escribirLn("Ya esxiste alguien con esa matricula");
                    b = true;
                }

            }
        } else {
            ES.escribirLn("Capacidad al maximo");
        }
    }

    private static void borrarCliente(String dni) {
        boolean b = false;

        while (!Utilidades.comprobarDni(dni)) {
            dni = ES.leerCadena("Introduzca un Dni valido");
        }
        for (int i = 0; i < nAlquileres && !b; i++) {
            if (alquileres[i] != null) {
                if (alquileres[i].getCliente().getDni().equals(dni)) {
                    alquileres[i].getCliente().setBaja(b);
                    b = true;

                }
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
        for (int i = 0; i < nAlquileres && !b; i++) {
            if (alquileres[i] != null) {
                if (alquileres[i].getTurismo().getMatricula().equals(matricula)) {
                    alquileres[i].getTurismo().setDisponible(b);
                    b = true;

                }

            }

        }
        if (b) {
            quitarHuecoT(matricula);
            ES.escribirLn("INF: Vehiculo borrado");

        }
    }

    private static void darBajaCliente(String dni) {
        boolean b = false;

        while (!Utilidades.comprobarDni(dni)) {
            dni = ES.leerCadena("Introduzca un Dni valido");
        }
        getClientes(dni).setBaja(b);
        ES.escribirLn("Cliente dado de baja");
        ES.escribirLn("");
        b = true;
    }

    private static void darBajaVehiculo(String matricula) {
        boolean b = false;

        while (!Utilidades.comprobarDni(matricula)) {
            matricula = ES.leerCadena("Introduzca un Dni valido");
        }
        getVehiculos(matricula).setBaja(b);
        b = true;

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
        for (int i = 0; i < nVehiculos && !b; i++) {
            if (vehiculos[i] != null) {
                if (alquileres[i].getTurismo().getMatricula().equals(matricula)) {
                    vehiculos[i] = null;
                    vehiculos[i] = vehiculos[nVehiculos + 1];
                    vehiculos[nVehiculos + 1] = null;
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
                ES.escribirLn("Vehiculo no disponible");
            }
        }
        if (v == null) {

            ES.escribir("vehiculo no disponible");
        }
        if (c == null) {
            ES.escribir("Cliente no disponible");

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
                    alquileres[i].toString();
                    alquileres[i].cerrar();

                }
            }

        }

    }

    private static void listarClientes() {
        boolean b = false;
        for (int i = 0; i <= nClientes && !b; i++) {
            if (clientes[i] != null) {
                ES.escribirLn(clientes[i].toString());

            } else {
                b = true;
            }
        }
    }

    private static void listarVehiculos() {
        boolean b = false;
        for (int i = 0; i <= nVehiculos && !b; i++) {
            if (vehiculos[i] != null) {
                ES.escribirLn(vehiculos[i].toString());

            } else {
                b = true;
            }
        }
    }

    private static void listarAlquileres() {
        for (int i = 0; i < nAlquileres; i++) {
            if (alquileres[i] != null) {
                ES.escribir(alquileres[i].toString());
            }
        }
    }

    private static Cliente insertarClientes() {
        Cliente c;
        String dni;
        String codigoPostal;
        String nombre;
        String direccion;
        String localidad;

        do {
            dni = ES.leerCadena("Introduzca un Dni valido");
        } while (!Utilidades.comprobarDni(dni));
        nombre = ES.leerCadena("Introduzca su nombre");
        direccion = ES.leerCadena("Introduzca su direccion");
        localidad = ES.leerCadena("Introduzca su localidad");
        do {
            codigoPostal = ES.leerCadena("Introduzca su codigo posta");
        } while (!Utilidades.comprobarCodigoPostal(codigoPostal));

        return c = new Cliente(dni, nombre, direccion, localidad, codigoPostal);
    }

    private static Vehiculo insertarVehiculo() {
        String matricula;
        Vehiculo v = null;
        do {
            matricula = ES.leerCadena("Introduzca la matricula valido");
        } while (!Utilidades.comprobarMatricula(matricula));

        String marca = ES.leerCadena("Introduzca la marca");
        String modelo = ES.leerCadena("Introduzca el modelo");
        int cilindrada = ES.leerEntero("Introduzca el numero de cilindradas");
        int opcion = ES.leerInt("Eligee tipo de vehiculo \n 1.Turismo 2.Mercancias", 1, 2);
        switch (opcion) {
            case 1:
                int npuertas = ES.leerEntero("Introduce el numero de puertas\n");
                opcion = ES.leerInt("Elije el tipo de combustible \n"
                        + "1.Gasolina \n"
                        + "2.Diesel\n"
                        + "3.Hibrido\n"
                        + "4.Electrico\n", 1, 4);
                Enumerados.TipoCombustible combustible = null;
                switch (opcion) {
                    case 1:
                        combustible = Enumerados.TipoCombustible.GASOLINA;
                        break;
                    case 2:
                        combustible = Enumerados.TipoCombustible.DIESEL;

                        break;
                    case 3:
                        combustible = Enumerados.TipoCombustible.HIBRIDO;

                        break;
                    case 4:
                        combustible = Enumerados.TipoCombustible.ELECTRICO;

                        break;
                }
                opcion = ES.leerInt("Eligee tipo de vehiculo \n 1.Familiar \n 2.Deportivo \n", 1, 2);

                switch (opcion) {
                    case 1:
                        int nPlazas = ES.leerInt("Introduzca el numero de plazas", 4, 7);
                        boolean sillaBebe = ES.leerBoolean("Introduzca si quiere solicita la sillla de bebe(si) o no");

                        v = new Familiar(nPlazas, sillaBebe, npuertas, combustible, matricula, marca, modelo, cilindrada);
                        break;
                    case 2:
                        boolean descapotable = ES.leerBoolean("introduzca si quiere que sea Descapotable(si) o no");
                        opcion = ES.leerInt("Elija si quiere que sea \n 1.Automatico o 2.Manual", 1, 2);
                        Enumerados.CajaCambio caja = null;
                        switch (opcion) {
                            case 1:
                                caja = Enumerados.CajaCambio.AUTOMATICA;
                                break;
                            case 2:
                                caja = Enumerados.CajaCambio.MANUAL;

                                break;
                        }
                        v = new Deportivo(descapotable, caja, npuertas, combustible, matricula, marca, modelo, cilindrada);
                        break;

                }

                break;

            case 2:
                int pma = ES.leerEntero("Introduzca el peso maximo de la furgoneta");
                int volumen = ES.leerEntero("Introduzca el volumen de la furgoneta");
                boolean refrigerado = ES.leerBoolean("Introduzca si es refrigerado o no");
                Enumerados.Tamano tamano = null;
                opcion = ES.leerInt("Introduzca el tamanio de la furgoneta \n"
                        + "1.Pequena"
                        + "2.Mediana"
                        + "3.Grande \n", 1, 3);
                switch (opcion) {
                    case 1:
                        tamano = Enumerados.Tamano.PEQUENA;

                        break;
                    case 2:
                        tamano = Enumerados.Tamano.MEDIANA;

                        break;
                    case 3:
                        tamano = Enumerados.Tamano.GRANDE;
                        break;
                }

                v = new Furgoneta(refrigerado, tamano, pma, volumen, matricula, marca, modelo, cilindrada);
                break;

        }

        return v;
    }

    private static void listarClientesBaja() {
        for (int i = 0; i < nClientes; i++) {
            if (clientes[i] != null) {
                if (clientes[i].isBaja()) {
                    ES.escribirLn(clientes[i].toString());

                }
            }

        }
    }

    private static void listarVehiculosBaja() {
        for (int i = 0; i < nVehiculos; i++) {
            if (vehiculos[i] != null) {
                if (vehiculos[i].isBaja()) {
                    ES.escribirLn(vehiculos[i].toString());

                }
            }
        }
    }

    public static void guardarAlquilerEnFichero(Alquiler[] a) {
        try {
            try (FileOutputStream fichero = new FileOutputStream("Alquileres_JRR.dat"); ObjectOutputStream salida = new ObjectOutputStream(fichero)) {
                salida.writeObject(a);
                System.out.println("Guardado con exito");
            }
        } catch (IOException e) {
            System.out.println("Error guardando fichero Alquileres_JRR.dat");
        }
    }

    public static void guardarVehiculosEnFichero(Vehiculo[] v) {
        try {
            try (FileOutputStream fichero = new FileOutputStream("Vehiculos_JRR.dat")) {
                ObjectOutputStream salida = new ObjectOutputStream(fichero);
                salida.writeObject(v);
                System.out.println("Cargado con exito");
                salida.close();
            }
        } catch (IOException e) {
            System.out.println("Error guardando fichero Vehiculos.dat");
        }
    }

    public static void guardarClientesEnFichero(Cliente[] c) {
        try {
            try (FileOutputStream fichero = new FileOutputStream("Clientes_JRR.dat")) {
                ObjectOutputStream salida = new ObjectOutputStream(fichero);
                salida.writeObject(c);
                System.out.println("Guardado con exito");
            }
        } catch (IOException e) {
            System.out.println("Error guardando fichero Clientes_JRR.dat");
        }
    }

    public static Alquiler[] cargarAlquileres() {
        Alquiler[] a = new Alquiler[MAX_ALQUILERES];
        boolean b = false;
        try {
            try (FileInputStream fichero = new FileInputStream("Alquileres_JRR.dat")) {
                ObjectInputStream entrada = new ObjectInputStream(fichero);
                a = (Alquiler[]) entrada.readObject();
                for (int i = 0; i < MAX_CLIENTES && !b; i++) {
                    if (a[i] == null) {
                        b = true;
                    } else {
                        nAlquileres++;
                    }
                }
                System.out.println("Cargado con exito");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo fichero Alquileres_JRR.dat");
        }
        return a;
    }

    private static Cliente[] cargarClientes() {
        Cliente[] c = new Cliente[MAX_CLIENTES];
        boolean b = false;
        try {
            try (FileInputStream fichero = new FileInputStream("Clientes_JRR.dat")) {
                ObjectInputStream entrada = new ObjectInputStream(fichero);
                c = (Cliente[]) entrada.readObject();
                for (int i = 0; i < MAX_CLIENTES && !b; i++) {
                    if (c[i] == null) {
                        b = true;
                    } else {
                        nClientes++;
                    }
                }

                System.out.println("Cargado con exito");

            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo fichero Clientes_JRR.dat");
        }
        return c;
    }

    private static Vehiculo[] cargarVehiculos() {
        Vehiculo[] v = new Vehiculo[MAX_VEHICULOS];
        boolean b = false;
        try {
            try (FileInputStream fichero = new FileInputStream("Vehiculos_JRR.dat")) {
                ObjectInputStream entrada = new ObjectInputStream(fichero);
                v = (Vehiculo[]) entrada.readObject();
                for (int i = 0; i < MAX_CLIENTES && !b; i++) {
                    if (v[i] == null) {
                        b = true;
                    } else {
                        nVehiculos++;
                    }
                }
                System.out.println("Cargado con exito");

            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo fichero Vehiculos_JRR.dat");
        }
        return v;
    }

    public static void leerDatos() {
        int opcion = ES.leerEntero("Introduce si quiere guerdar los archivos en (1)binario o (2)Fichero txt ");

        switch (opcion) {
            case 1:
                alquileres = cargarAlquileres();
                vehiculos = cargarVehiculos();
                clientes = cargarClientes();
                break;
            case 2:

                if (cargarVehiculostxt()) {
                    ES.escribirLn("Vehiculos Cargados correctamente");
                }

                if (cargarClientestxt()) {
                    ES.escribirLn("Clientes Cargados correctamente");
                }

                if (cargarAlquilerestxt()) {
                    ES.escribirLn("Alquileres Cargados correctamente");
                }
                break;
        }

    }

    public static boolean cargarAlquilerestxt() {
        Alquiler a;
        Cliente c;
        Vehiculo v;
        int i = 0;
        String linea = ES.leerArchivo(RUTA_A);
        try {
            Scanner s = new Scanner(linea).useDelimiter("#");
            while (!linea.equals("")) {
                String matricula = s.next();
                String dni = s.next();
                v = getVehiculos(matricula);
                c = getClientes(dni);
                a = new Alquiler(c, v);
                String date = s.next();
                alquileres[i] = a;
                i++;
                nAlquileres++;
                ES.escribir("Se ha añadido un alquiler");
                LocalDateTime fecha = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE);

                a.setFecha(fecha);

            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean cargarClientestxt() {
        Cliente c;
        int i = 0;
        String linea = ES.leerArchivo(RUTA_C);
        try {
            Scanner s = new Scanner(linea).useDelimiter("#");
            while (!linea.equals("")) {
                String dni = s.next();
                String nombre = s.next();
                String direccion = s.next();
                String localidad = s.next();
                String codPostal = s.next();
                boolean baja = s.nextBoolean();
                c = new Cliente(dni, nombre, direccion, localidad, codPostal, baja);
                clientes[i] = c;
                i++;
                nClientes++;
                ES.escribir("Se ha añadido un cliente");
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean cargarVehiculostxt() {
        Vehiculo v = null;
        int i = 0;
        String linea = ES.leerArchivo(RUTA_V);
        try {
            Scanner s = new Scanner(linea).useDelimiter("#");
            while (!linea.equals("") && s.hasNext()) {
                String matricula = s.next();
                String marca = s.next();
                String modelo = s.next();
                int cilindrada = s.nextInt();
                boolean disponible = s.nextBoolean();
                boolean baja = s.nextBoolean();
                String tipo = s.next();
                if (tipo.equals("T")) {
                    int npuertas = s.nextInt();
                    String tcombustible = s.next();
                    Enumerados.TipoCombustible combustible = null;
                    switch (tcombustible) {
                        case "GASOLINA":
                            combustible = Enumerados.TipoCombustible.GASOLINA;
                            break;
                        case "DIESEL":
                            combustible = Enumerados.TipoCombustible.DIESEL;
                            break;
                        case "HIBRIDO":
                            combustible = Enumerados.TipoCombustible.HIBRIDO;
                            break;
                        case "ELECTRICO":
                            combustible = Enumerados.TipoCombustible.ELECTRICO;
                            break;

                    }
                    tipo = s.next();
                    if (tipo.equals("F")) {
                        int nPlazas = s.nextInt();
                        boolean sillaBebe = s.nextBoolean();

                        v = new Familiar(nPlazas, sillaBebe, npuertas, combustible, matricula, marca, modelo, cilindrada);

                    } else if (tipo.equals("D")) {
                        boolean descapotable = s.nextBoolean();
                        String tcajacambio = s.next();
                        Enumerados.CajaCambio cambio = null;
                        switch (tcajacambio) {
                            case "AUTOMATICA":
                                cambio = Enumerados.CajaCambio.AUTOMATICA;
                                break;
                            case "MANUAL":
                                cambio = Enumerados.CajaCambio.MANUAL;

                                break;
                        }
                        v = new Deportivo(descapotable, cambio, npuertas, combustible, matricula, marca, modelo, cilindrada);

                    }

                } else if (tipo.equals("M")) {
                    int pma = s.nextInt();
                    int volumen = s.nextInt();
                    boolean refrigerado = s.nextBoolean();
                    Enumerados.Tamano tamanio = null;
                    String tipotamanio = s.next();
                    switch (tipotamanio) {
                        case "PEQUENA":
                            tamanio = Enumerados.Tamano.PEQUENA;

                            break;
                        case "MEDIANA":
                            tamanio = Enumerados.Tamano.MEDIANA;

                            break;
                        case "GRANDE":
                            tamanio = Enumerados.Tamano.GRANDE;
                            break;
                    }

                    v = new Furgoneta(refrigerado, tamanio, pma, volumen, matricula, marca, modelo, cilindrada);
                    break;

                }

                vehiculos[i] = v;
                i++;
                ES.escribir("Se ha añadido un vehiculo");

            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        nVehiculos = i;
        return true;
    }

    public static void guardarDatos() {
        int opcion = ES.leerEntero("Introduce si quiere guerdar los archivos en (1)binario o (2)Fichero txt ");

        switch (opcion) {
            case 1:
                guardarAlquilerEnFichero(alquileres);
                guardarClientesEnFichero(clientes);
                guardarVehiculosEnFichero(vehiculos);

                break;
            case 2:
                boolean b = ES.leerBoolean("Desea sobreescribir los ficheros  de txt?");
                String linea = ConvertirAString();
                ES.escribirArchivo("Alquileres_JRR.txt", linea, b);

                linea = ConvertirCString();
                ES.escribirArchivo("Clientes_JRR.txt", linea, b);

                linea = ConvertirVString();
                ES.escribirArchivo("Vehiculos_JRR.txt", linea, b);

                break;
        }
    }

    public static String ConvertirAString() {
        if (alquileres[0] != null) {
            String linea = alquileres[0].toString2();
            for (int i = 1; i < nAlquileres; i++) {
                linea += alquileres[i].toString2();
            }
            return linea;
        }
        return null;
    }

    public static String ConvertirCString() {
        if (clientes[0] != null) {
            String linea = clientes[0].toString();
            if (clientes[1] != null) {
                for (int i = 1; i < nClientes; i++) {
                    linea += clientes[i].toString();
                }
            }
            return linea;
        }
        return null;
    }

    public static String ConvertirVString() {
        if (vehiculos[0] != null) {
            String linea = vehiculos[0].toString();
            if (clientes[1] != null) {

                for (int i = 1; i < nVehiculos; i++) {
                    linea += vehiculos[i].toString();
                }
            }
            return linea;
        }
        return null;
    }

    public static void CargarDatos() {
        int opcion = ES.leerEntero("Introduce si quiere guerdar los archivos en (1)binario o (2)Fichero txt ");

        switch (opcion) {
            case 1:
                clientes = cargarClientes();
                vehiculos = cargarVehiculos();
                alquileres = cargarAlquileres();

                break;
            case 2:
                cargarClientestxt();
                cargarVehiculostxt();
                cargarAlquilerestxt();

                break;
        }

    }

}
