/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lenguaje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Lenguaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String ruta = args[0];
        int numeroPalabras = Integer.parseInt(args[1]);

        if (args.length != 2) {
            System.exit(1);
        }

        for (int i = 0; i < numeroPalabras; i++) {
            int numero = (int) (Math.random() * (122 - 97 + 1) + 97);
            char characterConvertido = (char) numero;
           write(String.valueOf(characterConvertido), ruta);

        }
    }

    public static void write(String numero, String ruta) {
        FileOutputStream fo = null;
        BufferedWriter bw = null;
        File fichero = new File(ruta);

        try {
            fo = new FileOutputStream(fichero, true);
            bw = new BufferedWriter(new OutputStreamWriter(fo));



            bw.write(numero);
            bw.newLine();


        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
