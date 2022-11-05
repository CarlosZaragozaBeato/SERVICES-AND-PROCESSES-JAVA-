/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrashilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author usumaniana
 */
public class Hilos extends Thread{

    private JProgressBar barra;
    private int i;

    public Hilos(JProgressBar barra) {
        this.barra = barra;
    }

    public void setI(int i) {
        this.i = i;
    }
   
   
    @Override
    public void run() {
        
        barra.setValue(barra.getMinimum());
       
       
        for(i = barra.getMinimum(); i<=barra.getMaximum(); i++){   
            barra.setValue(i);
            
         
            barra.repaint();
        }
        
    }
}
