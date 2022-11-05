/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author usumaniana
 */
public class HiloTurtle extends Thread {

    private JProgressBar barra;
    private boolean condition;
    
    public HiloTurtle(JProgressBar barra) {
        this.barra = barra;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    

    
    
    @Override
    public void run() {
        condition = true;

        while(condition){
            barra.repaint();
            
            switch(calcularProbabilidades()){
                case 1:
                    barra.setValue(barra.getValue()+3);
                    break;
                case 2:
                    if(barra.getValue()>=6){
                        barra.setValue(barra.getValue()-6);
                    }
                    break;
                case 3:
                        barra.setValue(barra.getValue()+1);
                    break;
            }      
           
            sleep();
           
           if(barra.getValue() == barra.getMaximum()){
               condition = false;
           }
        }
    }
    
    private int calcularProbabilidades(){
        Random random = new Random();
        
       int probabilidad =  random.nextInt(+1*100);
       int accion = 0;
              
       if(probabilidad<=50){
           accion = 1;
       }else if(probabilidad<=70){
           accion = 2;
       }else if(probabilidad<=100){
           accion = 3;
       }
       return accion;   
    }
}
