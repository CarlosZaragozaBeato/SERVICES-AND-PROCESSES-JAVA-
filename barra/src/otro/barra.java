/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otro;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author usumaniana
 */
public class barra extends JProgressBar implements Runnable{

    @Override
    public void run() {

          for(int i = this.getMinimum(); i<= this.getMaximum(); i++){   
             try {
              this.setValue(i);
              this.repaint();
              sleep(500);
              } catch (InterruptedException ex) {
                  Logger.getLogger(barra.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        
    } 
}
