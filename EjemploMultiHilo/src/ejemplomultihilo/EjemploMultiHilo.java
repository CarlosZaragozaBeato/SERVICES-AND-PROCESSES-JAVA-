/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplomultihilo;

/**
 *
 * @author usumaniana
 */
public class EjemploMultiHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Inicializando Hilo");
        System.out.println("");
        for(int i = 1; i<=10; i++){
             Hilo hilo = new Hilo("Hilo: "+i);
             hilo.start();
        }
        System.out.println("");
        System.out.println("Finalizacion del hilo");
       
    }
    
}
