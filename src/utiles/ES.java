/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utiles;

import java.util.Scanner;

/**
 *
 * @author mgordillo
 */
public class ES 
{
    static public byte leerByte( String _msg, byte _min, byte _max)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        Byte num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Byte.parseByte( s.nextLine());
                
                if( num >= _min && num <= _max)
                    datoValido = true;
                else 
                    System.out.printf("Debe ser un número entre %d y %d.\n", _min, _max);
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    
    static public int leerEntero( String _msg)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        int num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Integer.parseInt( s.nextLine());
                
                
                datoValido = true;
                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
    static public byte leerByte( String _msg)
    {
        Scanner s = new Scanner(System.in);
        boolean datoValido = false;
        
        byte num = 0;
        do 
        {
            try 
            {
                System.out.print( _msg);
                num = Byte.parseByte( s.nextLine());
                
                datoValido = true;                
            } 
            catch (Exception e) 
            {
                System.out.print( "El dato introducido no es correcto");
                System.out.println( " Por favor, introduzca un valor correcto.");
            }
        } while (!datoValido);
        
        return num ;
    }
    
        static public boolean leerByoolean( String _msg){
        Scanner sb = new Scanner(System.in);
boolean    valido = false;
       boolean valido2;
        try{
         System.out.println(_msg);
          String  cadena= sb.next();
            if(cadena.toUpperCase().equals("SI")| cadena.toUpperCase().equals("S")){
            valido= true;
                    valido2= true;
                            
            }else if(cadena.toUpperCase().equals("NO")| cadena.toUpperCase().equals("N")){
                valido= false;
                    valido2= false;
                            
            
            } 
        
        }catch(Exception e){
            System.out.println(e);

        }
        return  valido;
           
        
        }

    static public String leerCadena( String _msg)
    {
        Scanner s = new Scanner(System.in);
        String cadena = "" ;
        System.out.print( _msg);
        
        cadena = s.nextLine();               
                
        
        return cadena ;
    }
    
    public static void escribirLn( String _cadena)
    {
        System.out.println( _cadena );
    }
    
    public static void escribir( String _cadena)
    {
        System.out.print( _cadena );
    }
    
}
