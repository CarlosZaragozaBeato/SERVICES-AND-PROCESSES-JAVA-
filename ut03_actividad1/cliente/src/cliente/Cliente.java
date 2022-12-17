/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usumaniana
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String HOST = "localhost";
        int PUERTO = 5000;
        Socket sc;
        DataOutputStream salida;
        DataInputStream entrada;
        String mensajeRecibido;
        Scanner teclado = new Scanner(System.in);

        try {
            sc = new Socket(HOST, PUERTO);
            salida = new DataOutputStream(sc.getOutputStream());
            entrada = new DataInputStream(sc.getInputStream());
            String msn = " ";
            while (!msn.equals("END")) {
                System.out.println("Escriba un comando para enviar");
                msn = teclado.nextLine().toUpperCase();
                salida.writeUTF(msn);
                mensajeRecibido = entrada.readUTF();
                System.out.println(mensajeRecibido);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


