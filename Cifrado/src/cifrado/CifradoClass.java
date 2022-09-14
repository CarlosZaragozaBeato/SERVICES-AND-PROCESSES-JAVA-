/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrado;

/**
 *
 * @author carlo
 */
public class CifradoClass {
    

public void Cifrado(String cadena){
    
   String acuPar = ""; 
   String acuImpar = "";
   String palabra = "";
   
   String cadenaFinal = "";
   
   String [] trozos = cadena.split(" ");
   

   for(int i = 0; i<trozos.length; i++){
      cadenaFinal += cortarPalabra(trozos[i])+" ";
   }
    System.out.println(cadenaFinal);
}

public String cortarPalabra(String palabra){
    
    String acuPar ="";
    String acuImpar ="";

    String palabraCortada = "";
    
    for(int i = 0; i<palabra.length(); i++){
        if(i%2==0){
            acuPar += palabra.charAt(i);
        }else{
             acuImpar += palabra.charAt(i);
        }
    }
    return palabraCortada =  acuPar+acuImpar;        
}
}
