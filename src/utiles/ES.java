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

            Scanner scanner = new Scanner(System.in);
            File archivo = new File("C:\\" + ruta);

            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo, sobreescribirArchivo));

                if (archivo.exists()) {
                    salida.println(linea);
salida.close();
                    System.out.println("Archivo sobreescrito correctamente.");

                    System.out.println("Datos añadidos correctamente.");

                } else {
                    FileWriter writer = new FileWriter(archivo);
                    writer.write(linea + "\n");
                    writer.close();
                    System.out.println("Archivo creado y datos guardados correctamente.");
                }

            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo.");
            }

            scanner.close();
        } catch (Error e) {
            System.out.println(e);
        }
        return false;
    }

    public static String leerArchivo(String ruta) {
        String datos = null;
        File archivo = new File("C:\\" + ruta);

        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return "";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
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

}
