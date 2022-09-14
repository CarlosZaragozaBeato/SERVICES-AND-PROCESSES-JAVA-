/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usumaniana
 */
public class Ejemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();
        BufferedReader bf = null;
        BufferedWriter bw = null;
        BufferedReader bError = null;

        String linea = "";
  
        try {
            pb.command("gcalccmd");
            Process pc = pb.start();
 
            
           bf = new BufferedReader(new InputStreamReader(pc.getInputStream(), "UTF-8"));
           bw = new BufferedWriter(new OutputStreamWriter(pc.getOutputStream(), "UTF-8"));
           bError = new BufferedReader(new InputStreamReader(pc.getErrorStream(),"UTF-8"));
           
           
           bw.write("8*");
           bw.newLine();
           
           bw.write("9/10\n");
           
           bw.write("qui");
           bw.newLine();
               
           bw.write("quit");
           bw.newLine();
           
           bw.flush();
           
           while((linea = bf.readLine()) !=null){
               System.out.println(linea);
           }
                      
           while((linea = bError.readLine()) !=null){
               System.err.println(linea);
           } 
           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
    
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(Ejemplo2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }

    }

}
