/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

/**
 *
 * @author usumaniana
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

          DataOutputStream dOut = new DataOutputStream(System.out);
           DataInputStream dIn =  new DataInputStream(System.in);

        try{
                int valor1 = dIn.readInt();

                int valor2 = dIn.readInt();
                String resultado = valor1 + " + " + valor2 +" = " +(valor1+valor2); 
                dOut.writeUTF(resultado);
                dOut.flush();
        }catch(Exception e){

        }
        
       
        
    }
    
}
