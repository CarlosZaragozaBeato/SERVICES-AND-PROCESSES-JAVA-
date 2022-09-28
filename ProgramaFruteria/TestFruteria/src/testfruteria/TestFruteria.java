/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testfruteria;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usumaniana
 */
public class TestFruteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rutaJAR = "../Fruteria/dist/Fruteria.jar";
        String rutaFichero = "../ficheros/fruteria.txt";
        String[] productos = {"coco","cereza","piña","fresa","platano","ciruela","mango"};
        
        String[] productosConsulta = {"manzana","naranja","piña","uvas","sandia","platano","coco"};
        
        File fSalida = new File("../ficheros/salidaFruteria.txt");
        
        ProcessBuilder pb = new ProcessBuilder();
        Random generador = new Random();
        
        for (String producto : productos) 
        {
            try 
            {
                pb.command("java","-jar", rutaJAR,"write", producto, rutaFichero, String.valueOf(generador.nextInt(50)));           
                pb.start();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(TestFruteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (String producto : productosConsulta) 
        {
            try 
            {
                pb.command("java","-jar", rutaJAR,"read", producto, rutaFichero);
                pb.redirectOutput(fSalida);
                pb.start();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(TestFruteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try
        {
            sleep(10000);
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
}
