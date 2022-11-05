/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploprioridad;

import static java.lang.Thread.sleep;

/**
 *
 * @author usumaniana
 */
public class HiloA extends Thread{

    private Contador contador;
    private String n;

    public HiloA(String n, Contador c) {
        setName(n);
        contador = c;
    }



    public void run() {
        for (int i = 0; i < 300; i++) {
            contador.incrementa(); //incrementa el valor de contador
            try {
                sleep(100);
            } catch (InterruptedException e) {
            }

        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}



