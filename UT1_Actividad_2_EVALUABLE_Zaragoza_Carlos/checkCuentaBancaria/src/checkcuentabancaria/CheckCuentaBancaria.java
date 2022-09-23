/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package checkcuentabancaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class CheckCuentaBancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException, Exception{
    
        comprobacionCCC ccc = new comprobacionCCC();
        
        String linea = "";

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

  
        try{
            while((linea = bf.readLine()) != null)
            System.out.println(ccc.CheckCuentaBancaria(linea));
        }catch(IOException ex){
            System.out.println("Error");
        }finally{
            try{
                if(bf != null) bf.close();
            }catch(IOException ex){
                System.out.println("Error");
            }
        }
    }
   
}
