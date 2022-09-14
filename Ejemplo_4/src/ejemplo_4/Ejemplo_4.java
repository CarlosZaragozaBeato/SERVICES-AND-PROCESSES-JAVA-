/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author usumaniana
 */
public class Ejemplo_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

           ProcessBuilder pb = new ProcessBuilder();
           
           final String programa = "../Calculadora/dist/Calculadora.jar";
           
           pb.command("java", "-jar", programa);
           
           
           // Stream para tipos primitivos
 
           DataOutputStream dOut = null;
           DataInputStream dIn = null;
           String linea = "";
           try{
             
               Process pc = pb.start();
               dOut = new DataOutputStream(pc.getOutputStream());
               dIn = new DataInputStream(pc.getInputStream());
               
               
               dOut.writeInt(5);
               
               dOut.writeInt(5);
             
                     
               dOut.flush();    
                
               linea = dIn.readUTF();

               System.out.println(linea);
              
           }catch(Exception e){
               System.out.println(e.getMessage());
           }finally {
              try{
                  if(dIn != null) dIn.close();
                  if(dOut != null) dIn.close();

              }catch(Exception e){
                  
              }
           }

    }
    
}
