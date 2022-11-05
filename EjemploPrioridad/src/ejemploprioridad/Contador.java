/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploprioridad;

/**
 *
 * @author usumaniana
 */
public class Contador{
int c = 0; //atributo contador

public Contador(int c) {
    
    this.c = c;
}



public void incrementa() { c = c +1;}
public void decrementa() { c = c -1;}
public int getValor() { return c; }
}