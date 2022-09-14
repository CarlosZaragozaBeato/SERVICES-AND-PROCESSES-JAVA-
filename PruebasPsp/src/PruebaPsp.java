import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
/**
 *
 * @author usumaniana
 */
public class PruebaPsp {

    public static void main(String[] args) {
        
        BufferedReader bf = null ;
        
        try {
            ProcessBuilder pb = new ProcessBuilder();
            
            /*pb.command("firefox");
            pb.start();
            pb.command("gnome-calculator");
            pb.start();*/
            
            //*Prepara el comando a lanzar*//
            pb.command("cal");
            Process pc = pb.start();
            
            InputStream in = pc.getInputStream();
            
            /*Secuencia de bites de entrada como cadena de caracteres*/
             bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            
            String linea = "";
            
            while ((linea = bf.readLine()) !=null){
                System.out.println(linea);
            }
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(PruebaPsp.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try{
                bf.close();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
                  
        }

    }
}
