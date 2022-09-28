/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruteria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
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
 * @author usumaniana
 */
public class Fruteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        System.out.println("Numero de argumentos: "+args.length);
//        
//        for (String arg:args)
//        {
//            System.out.println(arg);
//        }
        
        if (args.length != 3 && args.length != 4)
        {
            System.exit(1);
        }
        
        String modo = args[0]; //Read o write
        String producto = args[1];
        String ruta = args[2]; //Ruta del fichero (RECURSO COMPARTIDO)
        
        if (modo.equals("read"))
        {
            try {
                read(producto, ruta);
            } catch (IOException ex) {
                Logger.getLogger(Fruteria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (modo.equals("write"))
        {
            write(producto, args[3], ruta);
        }
    }
    
    public static void read(String producto, String ruta) throws IOException
    {
        File fichero = new File(ruta);
        BufferedReader bf = null;
        FileInputStream fi = null;
               
        try
        {
            fi = new FileInputStream(fichero);
            bf = new BufferedReader(new InputStreamReader(fi));
            
            //Realizamos una busqueda secuencial desde el inicio
            String linea = null;
            boolean salir = false;
            String[] partes = null;
            
            //INICIO DE LA SECCIÓN CRÍTICA
            
            //Bloqueamos el recurso
            FileLock cerrojo = fi.getChannel().lock(0, fichero.length(), true); //Lock falla con InputStream Reader, por eso hay que poner eso.
                       
            while ((linea = bf.readLine()) != null && (!salir))
            {
                partes = linea.split(":");
                salir =(partes != null) && (partes.length == 2) && (producto.equals(partes[0]));
            }
            
            //FIN DE LA SECCIÓN CRITICA (Instrucciones que acceden al recurso común)
            
            //Desbloqueamos el recurso
            cerrojo.release();
            
            if (salir)
            {
                System.out.println(producto + " tiene "+ partes[1] + " unidades");
            }
            else
            {
                System.out.println("No se ha encontrado el producto "+producto);
            }
                       
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            try
            {
                if (bf != null)
                {
                    bf.close();
                }
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static void write(String producto, String unidades, String ruta)
    {
        FileOutputStream fo = null;
        BufferedWriter bw = null;
        File fichero = new File(ruta);
        
        try 
        {
            fo = new FileOutputStream(fichero, true);
            bw = new BufferedWriter(new OutputStreamWriter(fo));
            
            //SECCION CRITICA
            //Bloqueamos
            FileLock cerrojo = fo.getChannel().lock(); //Con la escritura solo se pone el lock()
            
            bw.write(producto+":"+unidades);
            bw.newLine();
            
            //Liberamos
            cerrojo.release();
            //FIN SECCION CRITICA
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Fruteria.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Fruteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                if (bw != null)
                {
                    bw.close();
                }
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }           
        }
    }
}
