/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jrr_alquilervehiculos;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    private static ArrayList<Cliente> clientes = new ArrayList<>();

    private static ArrayList<Alquiler> alquileres = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion;
        String dni;
        String matricula;
        boolean b = ES.leerBoolean("Desea cargar los datos anteriores?");
        if (b) {
            CargarDatos();
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
        b = ES.leerBoolean("Desea guardar los datos?");
        if (b) {
            guardarDatos();
        }

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
        for (Cliente c : clientes) {

            if (c.getDni().equals(dnic)) {
                return c;

            }
        }

        return null;
    }

    private static Vehiculo getVehiculos(String m) {
        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equals(m)) {
                return v;

            }
        }

        return null;
    }

    private static void AnadirClientes(Cliente c) {
        boolean b = false;
        if (nClientes < MAX_CLIENTES) {
            if (getClientes(c.getDni()) == null && !b) {

                clientes.add(c);

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

                vehiculos.add(v);
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

    /*
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
     */
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

    /*   private static void quitarHuecoC(String dni) {
        boolean b = false;
        for (Alquiler a : alquileres) {
            if (a.getCliente().getDni().equals(dni)) {
                a.
                clientes= null;
                clientes = clientes[nClientes + 1];
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

     */ private static void nuevoAlquiler(Cliente c, Vehiculo v) {
        boolean b = false;
        if (c != null && v != null) {
            if (v.isDisponible()) {

                alquileres.add(new Alquiler(c, v));
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
        for (Alquiler a : alquileres) {
            if (a.getCliente().equals(c) && a.getTurismo().equals(v)) {
                a.toString();
                a.cerrar();

            }
        }

    }

    private static void listarClientes() {
        boolean b = false;
        for (Cliente c : clientes) {

            ES.escribirLn(c.toString());

        }
    }

    private static void listarVehiculos() {
        boolean b = false;
        for (Vehiculo v : vehiculos) {
            ES.escribirLn(v.toString());

        }
    }

    private static void listarAlquileres() {
        for (Alquiler a : alquileres) {

            ES.escribir(a.toString());
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
        for (Cliente c : clientes) {

            if (c.isBaja()) {
                ES.escribirLn(c.toString());

            }
        }

    }

    private static void listarVehiculosBaja() {
        for (Vehiculo v : vehiculos) {

            if (v.isBaja()) {
                ES.escribirLn(v.toString());

            }
        }
    }

    /*  public static void guardarAlquilerEnFichero(Alquiler[] a) {
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
    }*/
    
    public static void leerDatos() {
        /*   int opcion = ES.leerEntero("Introduce si quiere guerdar los archivos en (1)binario o (2)Fichero txt ");

        switch (opcion) {
            case 1:
                alquileres = cargarAlquileres();
                vehiculos = cargarVehiculos();
                clientes = cargarClientes();
                break;
            case 2*/

        if (cargarVehiculostxt()) {
            ES.escribirLn("Vehiculos Cargados correctamente");
        }

        if (cargarClientestxt()) {
            ES.escribirLn("Clientes Cargados correctamente");
        }

        if (cargarAlquilerestxt()) {
            ES.escribirLn("Alquileres Cargados correctamente");
            /*  }
                break;*/
        }

    }

    public static boolean cargarAlquilerestxt() {
        Alquiler a;
        Cliente c;
        Vehiculo v;
        nAlquileres = 0;
        alquileres.clear();
        int i = 0;
        String fichero = ES.leerArchivo(RUTA_A);
        String[] linea = fichero.split("\n");
        String[] unAlquiler = null;
        try {
            while (i < linea.length) {
                unAlquiler = linea[i].split("#");

                String[] matricula = unAlquiler[0].split("#");
                String[] dni = unAlquiler[1].split("#");
                String[] date = unAlquiler[2].split("-");
                v = getVehiculos(matricula[i]);
                c = getClientes(dni[i]);
                a = new Alquiler(c, v);
                int year = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int day = Integer.parseInt(date[2]);
                LocalDateTime fecha = LocalDateTime.of(year, month, day, 0, 0);
                a.setFecha(fecha);
                alquileres.add(a) ;
                i++;
                nAlquileres++;
                
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean cargarClientestxt() {
        Cliente c;
        nClientes = 0;
        int i = 0;
        clientes.clear();
        String fichero = ES.leerArchivo(RUTA_C);
        String[] linea = fichero.split("\n");
        String[] unCliente = null;
        try {
            while (i < linea.length) {
                unCliente = linea[i].split("#");
                String[] dni = unCliente[0].split("#");
                String[] nombre = unCliente[1].split("#");
                String[] direccion = unCliente[2].split("#");
                String[] localidad = unCliente[3].split("#");
                String[] codPostal = unCliente[4].split("#");
                String[] isbaja = unCliente[5].split("#");
                boolean baja = Boolean.parseBoolean(isbaja[i]);
                c = new Cliente(dni[i], nombre[i], direccion[i], localidad[i], codPostal[i], baja);
                clientes.add(c);
                i++;
                nClientes++;

            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static boolean cargarVehiculostxt() {
        Vehiculo v = null;
        nVehiculos = 0;
        vehiculos.clear();
        int i = 0;
        String fichero = ES.leerArchivo(RUTA_V);
        String[] linea = fichero.split("\n");
        String[] unVehiculo = null;
        try {
            while (i < linea.length) {
                unVehiculo = linea[i].split("#");;
                String[] matricula = unVehiculo[0].split("#");
                String[] marca = unVehiculo[1].split("#");
                String[] modelo = unVehiculo[2].split("#");

                String[] num = unVehiculo[3].split("#");
                int cilindrada = 0;
                cilindrada = Integer.parseInt(num[i]);

                String[] isdisponible = unVehiculo[4].split("#");
                boolean disponible = Boolean.parseBoolean(isdisponible[i]);

                String[] isbaja = unVehiculo[5].split("#");
                boolean baja = Boolean.parseBoolean(isbaja[i]);

                String[] tipo = unVehiculo[6].split("#");
                if (tipo[i].equals("T")) {
                    int npuertas = 0;
                    String[] numpuertas = unVehiculo[7].split("#");
                    npuertas = Integer.parseInt(numpuertas[i]);

                    String[] tcombustible = unVehiculo[8].split("#");;
                    Enumerados.TipoCombustible combustible = null;
                    switch (tcombustible[i]) {
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
                    String[] tipo2 = unVehiculo[9].split("#");
                    if (tipo2[i].equals("F")) {
                        String[] numplazas = unVehiculo[10].split("#");;
                        int nPlazas = 0;
                        nPlazas = Integer.parseInt(numplazas[i]);

                        String[] issillabebe = unVehiculo[11].split("#");
                        boolean sillaBebe = Boolean.parseBoolean(issillabebe[i]);
                        v = new Familiar(nPlazas, sillaBebe, npuertas, combustible, matricula[i], marca[i], modelo[i], cilindrada);

                    } else if (tipo2[i].equals("D")) {
                        String[] isdesc = unVehiculo[9].split("#");
                        boolean descapotable = Boolean.parseBoolean(isdesc[i]);
                        String[] tcajacambio = unVehiculo[10].split("#");;
                        Enumerados.CajaCambio[] cambio = null;
                        switch (tcajacambio[i]) {
                            case "AUTOMATICA":
                                cambio[i] = Enumerados.CajaCambio.AUTOMATICA;
                                break;
                            case "MANUAL":
                                cambio[i] = Enumerados.CajaCambio.MANUAL;

                                break;
                        }
                        v = new Deportivo(descapotable, cambio[i], npuertas, combustible, matricula[i], marca[i], modelo[i], cilindrada);

                    }

                } else if (tipo[i].equals("M")) {
                    int pma = 0;
                    String[] ispma = unVehiculo[7].split("#");
                    pma = Integer.parseInt(ispma[i]);
                    int volumen = 0;
                    String[] isvol = unVehiculo[8].split("#");
                    volumen = Integer.parseInt(isvol[i]);
                    String[] isrefrigerado = unVehiculo[9].split("#");
                    boolean refrigerado = Boolean.parseBoolean(isrefrigerado[i]);

                    Enumerados.Tamano[] tamanio = null;
                    String[] tipotamanio = unVehiculo[10].split("#");
                    switch (tipotamanio[i]) {
                        case "PEQUENA":
                            tamanio[i] = Enumerados.Tamano.PEQUENA;

                            break;
                        case "MEDIANA":
                            tamanio[i] = Enumerados.Tamano.MEDIANA;

                            break;
                        case "GRANDE":
                            tamanio[i] = Enumerados.Tamano.GRANDE;
                            break;
                    }

                    v = new Furgoneta(refrigerado, tamanio[i], pma, volumen, matricula[i], marca[i], modelo[i], cilindrada);
                    break;

                }

               vehiculos.add(v) ;
                i++;
                nVehiculos++;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

   /* public static LocalDateTime leerfecha(String linea) {
        Scanner date = new Scanner(linea).useDelimiter("-").useDelimiter(":").useDelimiter(".");
        int anio = date.nextInt();
        int mes = date.nextInt();
        int dia = date.nextInt();
        int hora = date.nextInt();
        int minuto = date.nextInt();
        int segundo = date.nextInt();
        int microsegundos = date.nextInt();
        LocalDateTime fecha = LocalDateTime.of(dia, minuto, minuto, hora, minuto, segundo, microsegundos);

        return fecha;

    }
*/
    public static void guardarDatos() {
        /*   int opcion = ES.leerEntero("Introduce si quiere guerdar los archivos en (1)binario o (2)Fichero txt ");

        switch (opcion) {
            case 1:
                guardarAlquilerEnFichero(alquileres);
                guardarClientesEnFichero(clientes);
                guardarVehiculosEnFichero(vehiculos);

                break;
            case 2:
         */
        boolean b = ES.leerBoolean("Desea sobreescribir los ficheros  de txt?");
        String linea = ConvertirAString();
        ES.escribirArchivo("Alquileres_JRR.txt", linea, b);

        linea = ConvertirCString();
        ES.escribirArchivo("Clientes_JRR.txt", linea, b);

        linea = ConvertirVString();
        ES.escribirArchivo("Vehiculos_JRR.txt", linea, b);

        /*     break;
        }*/
    }

    public static String ConvertirAString() {
        String linea = "";
        for (Alquiler a : alquileres) {
            linea += a.toString2();
        }
        return linea;
    }

    public static String ConvertirCString() {
        String linea = "";

        for (Cliente c : clientes) {
            linea += c.toString();
        }

        return linea;
    }

    public static String ConvertirVString() {
        String linea = "";

        for (Vehiculo v : vehiculos) {
            linea += v.toString();
        }
        return linea;
    }

    public static void CargarDatos() {
        /*  int opcion = ES.leerEntero("Introduce si quiere guerdar los archivos en (1)binario o (2)Fichero txt ");

        switch (opcion) {
            case 1:
                clientes = cargarClientes();
                vehiculos = cargarVehiculos();
                alquileres = cargarAlquileres();

                break;
         case 2:
         */
        cargarClientestxt();
        cargarVehiculostxt();
        cargarAlquilerestxt();

        /*
        break;
       }
         */
    }
}
