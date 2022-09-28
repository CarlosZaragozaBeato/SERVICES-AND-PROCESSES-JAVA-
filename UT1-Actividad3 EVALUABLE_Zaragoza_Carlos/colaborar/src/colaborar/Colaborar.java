/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colaborar;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Colaborar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String rutaJar = "../lenguaje/dist/lenguaje.jar";
        String rutaFichero = "../ficheros/salidaTexto.txt";
        
        File fSalida = new File(rutaFichero);
        ProcessBuilder pb = new ProcessBuilder();
    
         try {
             
             for(int i = 10; i<=100; i+=10){
                pb.command("java","-jar", rutaJar, rutaFichero ,String.valueOf(i));       
                pb.redirectOutput(fSalida);
                pb.start();
             }
            
            
            } 
            catch (IOException ex){System.out.println(ex.getMessage());}
   
    }
    
}
