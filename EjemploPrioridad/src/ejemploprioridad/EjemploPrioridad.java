/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploprioridad;


import static java.lang.Thread.sleep;

/**
 *
 * @author usumaniana
 */
public class EjemploPrioridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*HiloPrioridad p1 = new HiloPrioridad();
        HiloPrioridad p2 = new HiloPrioridad();
        HiloPrioridad p3 = new HiloPrioridad();

        p3.setPriority(Thread.NORM_PRIORITY);
        p2.setPriority(Thread.MAX_PRIORITY);
        p1.setPriority(Thread.MIN_PRIORITY);

        p1.start();
        p2.start();
        p3.start();
        
        try{
            sleep(1000);
        }catch(Exception ex){}
        
        p2.paraHilo();
        p1.paraHilo();
        p3.paraHilo();
        
        System.out.println("p2 (prioridad Máxima): "+p2.getContador());
        System.out.println("p3 (prioridad Mínima): "+p3.getContador());
        System.out.println("p1 (prioridad Normal): "+p1.getContador());*/

        Contador c = new Contador(100);
        HiloA a = new HiloA("HiloA",c);
        HiloB b = new HiloB("HiloB", c);
 
        a.start();
        b.start();
    }

}
