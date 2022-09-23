/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkcuentabancaria;

import java.util.regex.Pattern;

/**
 *
 * @author carlo
 */
public class comprobacionCuenta {
      public static boolean checkCuenta(String valor){
       
     String pat = Pattern.compile("\\d{4}[\\s | -]\\d{4}[\\s | -]\\d{2}[\\s | -]\\d{10}").toString();
                                                                         
     if (valor.matches(pat)) {
         return true;
     } else {
       return false;                                                                                
     }
    }
}
