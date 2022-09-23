/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1ne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author usumaniana
 */
public class Practica1NE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String resul = null;
        Cifrado cf = new Cifrado();
        /*resul = cf.cifrarTS("deja de espiarme");
        System.out.println(resul);*/
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String linea;
        
        try{
            while((linea = bf.readLine()) != null)
            System.out.println(cf.cifrarTS(linea));
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