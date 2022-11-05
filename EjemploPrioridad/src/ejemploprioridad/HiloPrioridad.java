/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploprioridad;

/**
 *
 * @author usumaniana
 */
public class HiloPrioridad extends Thread {
    
    
    private int c = 0;
     boolean stopHilo = false;
    
    public void paraHilo() {stopHilo = true; }
    
    public int getContador(){return c;}
    
    public void run(){
        while(!stopHilo) c++;

    }
    
}
