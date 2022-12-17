/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usumaniana
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, IOException, IOException {
        int PUERTO = 5000;
        ServerSocket sc = null;
        Socket so;
        DataOutputStream salida;
        DataInputStream entrada;
        String mensajeRecibido;

        try {

            Scanner teclado = new Scanner(System.in);

            try {
                sc = new ServerSocket(PUERTO);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            so = new Socket();

            System.out.println("Esperando conexión...");
            so = sc.accept();
            System.out.println("Se conecto uno...");
            entrada = new DataInputStream(so.getInputStream());
            salida = new DataOutputStream(so.getOutputStream());
            
            mensajeRecibido = entrada.readUTF();
            while (!mensajeRecibido.equals("END")) {
         
                System.out.println(mensajeRecibido);
                salida.writeUTF(LeerComando(mensajeRecibido));
                mensajeRecibido = entrada.readUTF();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sc.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static String LeerComando(String comando) {
        String resultado = "";
        Date fecha = new Date();
        switch (comando) {
            case "DAY":
                resultado = "" + fecha.getDay();
                break;
            case "MONTH":
                resultado = "" + (fecha.getMonth()+1);
                break;
            case "YEAR":
                resultado = "" + (fecha.getYear()+1900);
                break;
            case "TIME":
                resultado = "" + + fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds();
                break;
            case "ALL":
                resultado = "" + fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds()+ " "+fecha.getDay()+"/"+fecha.getMonth()+"/"+fecha.getYear();
                break;
            case "END":
                resultado = "Conexiones Cerradas";
                break;
            default:
                resultado = "“No se reconoce el comando solicitado";
        }
      return resultado;
    }
}
