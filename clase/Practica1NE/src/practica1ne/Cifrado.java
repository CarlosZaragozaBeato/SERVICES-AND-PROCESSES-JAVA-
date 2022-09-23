/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1ne;

/**
 *
 * @author usumaniana
 */
public class Cifrado {
    
    
    public static String cifrarTS(String mensaje){
        String resul = "";
        String[] trozos;
        trozos = mensaje.split("\\s+");

        
        for (int i = 0; i < trozos.length; i++) {
            String impar = "";
            String par = "";
            String palabra = "";
            for (int j = 0; j < trozos[i].length(); j++) {
                
                String l = trozos[i].substring(j,j+1);
                
                if(j%2==0){
                   impar = impar + l;
                }else{
                    par = par + l;
                }
            }
             palabra = impar + par;
             resul = resul + " " + palabra;
        }
        
        return resul;
    }
}
