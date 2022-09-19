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
    


//Funcion para dividir las letras segun sea pares o impares, devuelviendo la cadena correcta
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

/*Metodo que dividie primero la palabra en trozos segun los espacion que
contenga. Llama a la afuncion "cortaPalabra" para que por cada trozo que tengamos
lo ordena correctamente y estos a su vez son añadidos a una variable llamada cadena 
final.*/
public void Cifrado(String cadena){
    
   String cadenaFinal = "";
   
   String [] trozos = cadena.split(" ");
   

   for(int i = 0; i<trozos.length; i++){
      cadenaFinal += cortarPalabra(trozos[i])+" ";
   }
    System.out.println(cadenaFinal);
}
}
