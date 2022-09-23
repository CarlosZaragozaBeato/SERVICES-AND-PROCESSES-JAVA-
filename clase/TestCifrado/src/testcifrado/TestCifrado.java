/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testcifrado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usumaniana
 */
public class TestCifrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final String rutaJAR= "..//Practica1NE//dist//Practica1NE.jar";
        File fEntrada = new File("..//ficheros//cuentas.txt");
        File fSalida = new File("..//ficheros//textoCifrado.txt");
        File fError = new File("..//ficheros//ficheroErrores.txt");
        FileReader fr =null;
        FileWriter fw =null;
        BufferedReader bf=null;
        BufferedWriter bw = null;
        
        ProcessBuilder pb = new ProcessBuilder();
        
        pb.command("java","-jar",rutaJAR);
        pb.redirectInput(fEntrada);
        pb.redirectOutput(fSalida);
        pb.redirectError(fError);
        
        try {
            Process proceso = pb.start();
            
            //Esperamos a que finalice el proceso
            
            if(proceso.waitFor() > 0)
                System.out.println("Se ha producido un error en la ejecución");
            
             bf = new BufferedReader(fr = new FileReader(fSalida));
               
             bw = new BufferedWriter(fw = new FileWriter(fEntrada));
             
             
             String linea;
             while((linea = bf.readLine())!=null)
                 System.out.println(linea);
                 bw.append(linea);
        } catch (IOException ex) {
            Logger.getLogger(TestCifrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(bf !=null)try {
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(TestCifrado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
