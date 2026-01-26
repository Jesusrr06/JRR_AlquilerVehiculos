/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

/**
 *
 * @author dam1
 */
public class Utilidades {

    public Utilidades() {
    }

    public static boolean comprobarMatricula(String m) {

        return false;

    }

    public static boolean comprobarDni(String dni) {
        String num = dni.substring(0, dni.length() - 1);
        int numdni = Integer.parseInt(num);

        int letra = numdni % 23;
        String L = null;
        switch (letra) {
            case 1:
                L = "R";
                break;
            case 2:
                L = "W";
                break;
            case 3:
                L = "A";
                break;
            case 4:
                L = "G";
                break;
            case 5:
                L = "M";
                break;
            case 6:
                L = "Y";
                break;
            case 7:
                L = "F";
                break;
            case 8:
                L = "P";
                break;
            case 9:
                L = "D";
                break;
            case 10:
                L = "X";
                break;
            case 11:
                L = "B";
                break;
            case 12:
                L = "N";
                break;
            case 13:
                L = "J";
                break;
            case 14:
                L = "Z";
                break;
            case 15:
                L = "S";
                break;
            case 16:
                L = "Q";
                break;
            case 17:
                L = "V";
                break;
            case 18:
                L = "H";
                break;
            case 19:
                L = "L";
                break;
            case 20:
                L = "C";
                break;
            case 21:
                L = "K";
                break;
            case 22:
                L = "E";
                break;
            case 0:
                L = "T";
                break;
        }
        if (dni.endsWith(L)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean comprobarCodigoPostal(String codP) {

        return false;

    }
}
