
package ejemplo_3;
import java.io.File;

public class Ejemplo_3 {


    public static void main(String[] args) { 
        
         ProcessBuilder pb = new ProcessBuilder();
         pb.command();
         
         File fEntrada = new File("./ficheros/Entrada.txt");
         File fSalida = new File("./ficheros/fSalida.txt");
         File fError = new File("./ficheros/fError.txt");
         
         /*Redireccion de la entrada y salida estandar del proceso externo*/
         
         pb.redirectInput(fEntrada);
         pb.redirectError(fError);
         pb.redirectOutput(fSalida);
         
        try {
           Process pc =  pb.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
