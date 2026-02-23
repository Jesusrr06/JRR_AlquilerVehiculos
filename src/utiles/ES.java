/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import jrr_alquilervehiculos.Alquiler;

/**
 *
 * @author mgordillo
 */
public class ES {

    static public byte leerByte(String _msg, byte _min, byte _max) {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;

        Byte num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Byte.parseByte(s.nextLine());

                if (num >= _min && num <= _max) {
                    datoValido = true;
                } else {
                    System.out.printf("Debe ser un numero entre %d y %d.\n", _min, _max);
                }
            } catch (NumberFormatException e) {
                System.out.print("El dato introducido no es correcto");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    static public int leerEntero(String _msg) {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;

        int num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Integer.parseInt(s.nextLine());

                datoValido = true;

            } catch (NumberFormatException e) {
                System.out.print("El dato introducido no es correcto");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    static public byte leerByte(String _msg) {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;

        byte num = 0;
        do {
            try {
                System.out.print(_msg);
                num = Byte.parseByte(s.nextLine());

                datoValido = true;
            } catch (NumberFormatException e) {
                System.out.print("El dato introducido no es correcto");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    static public int leerInt(String _msg, int _min, int _max) {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;

        int num = 0;
        do {
            try {
                System.out.println(_msg + " entre " + _min + " y " + _max);
                num = Integer.parseInt(s.nextLine());

                if (num >= _min && num <= _max) {
                    datoValido = true;
                } else {
                    System.out.printf("Debe ser un numero entre %d y %d.\n", _min, _max);

                }
            } catch (NumberFormatException e) {
                System.out.print("El dato introducido no es correcto");
                System.out.println(" Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);

        return num;
    }

    static public boolean leerBoolean(String _msg) {
        Scanner sb = new Scanner(System.in);
        boolean valido = false;
        boolean valido2;
        try {
            System.out.println(_msg);

            String cadena = sb.next();

            if (cadena.toUpperCase().equals("SI") | cadena.toUpperCase().equals("S")) {
                valido = true;
                valido2 = true;

            } else if (cadena.toUpperCase().equals("NO") | cadena.toUpperCase().equals("N")) {
                valido = false;
                valido2 = false;

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return valido;

    }

    static public String leerCadena(String _msg) {
        Scanner s = new Scanner(System.in);
        String cadena;
        System.out.print(_msg);

        cadena = s.nextLine();
        System.out.println("");
        return cadena;
    }

    public static void escribirLn(String _cadena) {
        System.out.println(_cadena);
    }

    public static void escribir(String _cadena) {
        System.out.print(_cadena);
    }

    public static boolean escribirArchivo(String ruta, String linea, boolean sobreescribirArchivo) {

        try {

            File archivo = new File(ruta);
            try {
                BufferedWriter br = new BufferedWriter(new FileWriter(archivo, sobreescribirArchivo));

                if (archivo.exists()) {
                    br.write(linea);
                    br.close();
                    System.out.println("Archivo sobreescrito correctamente.");

                    System.out.println("Datos añadidos correctamente.");

                } else {
                    br = new BufferedWriter(new FileWriter(archivo));

                    br.write(linea + "\n");
                    br.close();
                    System.out.println("Archivo creado y datos guardados correctamente.");
                }

            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo.");
            }

        } catch (Error e) {
            System.out.println(e);
        }
        return false;
    }

    public static String leerArchivo(String ruta) {
        String datos = null;
             FileReader fichero;
        BufferedReader br = null;
try {
            fichero = new FileReader(ruta);
            br = new BufferedReader(fichero);
            String linea = br.readLine();
            while (linea != null) {
      
                   
                
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error abriendo fichero: " + ruta);
        }

       

        try {

            String linea=null;
            System.out.println("Contenido del archivo:");
            System.out.println("----------------------");

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                datos += linea + "\n";
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return datos;
    }
    
     public void cargarAlquilerestxt(String nombreF) {
        FileReader fichero;
        BufferedReader br;
jrr_alquilervehiculos.Alquiler v;
        try {
            fichero = new FileReader(nombreF);
            br = new BufferedReader(fichero);
            String linea = br.readLine();
            while (linea != null) {
                v= crearalquiler(linea);
                    // Lo inserta si no está ya en el ArrayList
                    
                
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error abriendo fichero: " + nombreF);
        }

    }
public jrr_alquilervehiculos.Alquiler crearalquiler (String linea) {
        jrr_alquilervehiculos.Alquiler nuevoAl = null;
        // Objeto Scanner separado por ";"
        Scanner s = new Scanner(linea).useDelimiter("#");
        // Datos comunes (los del padre)
        double PRECIO_DIA=s.nextDouble();
String tiempo= s.next();
        int dias = s.nextInt();
        String matricula = s.next();
        String marca = s.next();
                String modelo = s.next();
        int cilindrda = s.nextInt();
        boolean disponible = s.nextBoolean();
if( s.match(jrr_alquilervehiculos.Familiar.))
        jrr_alquilervehiculos.Vehiculo turismo  =  new 
        boolean conPatron = s.next().equals("S");
        boolean alquilado = s.next().equals("S");
        int diasNavegacion = s.nextInt();
        int diasAlquiler = s.nextInt();
        // Discriminamos según sea Lancha o Velero
        if (tipo.equals("L")) {
            // Atributos propios de Lancha
            float potencia = Float.parseFloat(s.next());
            // creamos Lancha
            nuevoAl = new Alquiler(cliente, turismo);
        } else if (tipo.equals("V")) {

            
        }
    
        return nuevoAl;
    }

}
