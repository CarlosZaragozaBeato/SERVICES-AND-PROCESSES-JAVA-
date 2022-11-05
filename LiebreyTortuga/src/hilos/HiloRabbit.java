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
public class HiloRabbit extends Thread {

    private JProgressBar barra;
    private boolean condition;
    
    public HiloRabbit(JProgressBar barra) {
        this.barra = barra;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }
    
    
    
    @Override
    public void run() {
    condition = true;

       while(condition){

            try {
                switch (calcularProbabilidades()) {
                    case 1:
                        sleep(500);
                        break;
                    case 2:
                        barra.setValue(barra.getValue() + 9);
                        break;
                    case 3:
                        if (barra.getValue() >= 12) {
                            barra.setValue(barra.getValue() - 12);
                        }
                        break;
                    case 4:
                        barra.setValue(barra.getValue() + 1);
                        break;
                    case 5:
                        if (barra.getValue() >= 2) {
                            barra.setValue(barra.getValue() - 2);
                        }
                        break;
                }
           
              
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private int calcularProbabilidades() {
        Random random = new Random();

        int probabilidad = random.nextInt(+1 * 100);
        int accion = 0;

        if (probabilidad <= 20) {
            accion = 1;
        } else if (probabilidad <= 40) {
            accion = 2;
        } else if (probabilidad <= 50) {
            accion = 3;
        } else if (probabilidad <= 80) {
            accion = 4;
        } else if (probabilidad <= 100) {
            accion = 5;
        }
        return accion;
    }
}
