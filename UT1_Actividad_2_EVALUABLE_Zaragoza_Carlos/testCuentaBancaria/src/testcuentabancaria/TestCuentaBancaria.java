/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testcuentabancaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class TestCuentaBancaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        final String rutaJAR = "..//checkCuentaBancaria//dist//checkCuentaBancaria.jar";
        final File fEntrada = new File("..//ficheros//cuentas.txt");
        final File fSalida = new File("..//ficheros//resultado.txt");

        FileReader fr = null;
        BufferedReader bf = null;
        
        FileWriter fw = null;
        BufferedWriter bw = null;

        ProcessBuilder pb = new ProcessBuilder();

        pb.command("java", "-jar", rutaJAR);

        pb.redirectInput(fEntrada);
        pb.redirectOutput(fSalida);

        try {
            Process proceso = pb.start();

            //Esperamos a que finalice el proceso
            if (proceso.waitFor() > 0) {
                System.out.println("Se ha producido un error en la ejecución");
            }

            bf = new BufferedReader(fr = new FileReader(fSalida));
            bw = new BufferedWriter(fw = new FileWriter(fEntrada));
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                bw.append(linea);
                bw.newLine();
            }
            //bw.append(linea);
        } catch (IOException ex) {
        } catch (InterruptedException ex) {
        } finally {
            if (bf != null)try {
                bf.close();
            } catch (IOException ex) {

            }
        }

    }

}
