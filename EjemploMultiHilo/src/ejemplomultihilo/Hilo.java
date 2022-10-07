/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplomultihilo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usumaniana
 */
public class Hilo extends Thread{

    private String nombre;
    
    public Hilo(String nombre){
        this.nombre = nombre;
    }


    @Override
    public void run() {
        try {
            System.out.println("Iniciando hilo "+nombre);
            sleep(200);
            System.out.println("Finalizando el hilo "+nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}