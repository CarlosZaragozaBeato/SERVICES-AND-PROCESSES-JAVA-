/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkcuentabancaria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class comprobacionCCC {

   
    /**
     * 
     * Comprobación de cuentas
     * 
     * @param cuenta
     * @throws Exception 
     */
    public static String CheckCuentaBancaria(String cuenta) throws Exception {

        String acu;

        String res;
        String numeros_cuentas;

        int digito_ent, digito_cuenta;

        String digitos_control;

        String valor_retorno  = "";
        
        if (cuenta.length() == 20) {

            for (int i = 0; i < 4; i++) {

                if (i == 0) {
                    acu = cuenta.substring(0, 4);
                    Integer.parseInt(acu);
                } else if (i == 1) {

                    acu = cuenta.substring(4, 8);
                    Integer.parseInt(acu);
                } else if (i == 2) {
                    acu = cuenta.substring(8, 10);

                    Integer.parseInt(acu);

                    res = "00" + cuenta.substring(0, 8);

                    numeros_cuentas = cuenta.substring(10, 20);

                    digito_ent = obtenerDigitoControl(res);
                    digito_cuenta = obtenerDigitoControl(numeros_cuentas);

                    digitos_control = String.valueOf(digito_ent) + String.valueOf(digito_cuenta);

                    if (!digitos_control.equals(acu)) {
                       valor_retorno = ("La cuenta " + cuenta + " no es valida");
                    } else {
                        valor_retorno =  ("La cuenta " + cuenta + " es valida");
                    }
                }
            }
        } else {
            valor_retorno = "La cuenta debe de disponer de 20 caracteres";
        }
            return valor_retorno;
    }

    
    /**
     * 
     * Este metodo obtiene el digito de control
     * 
     * @param valor_cuenta
     * @return 
     */
    public static int obtenerDigitoControl(String valor_cuenta) {

        int[] fc = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        int dg_control = 0;
        int dg_cuenta;

        for (int i = 0; i < valor_cuenta.length(); i++) {
            dg_cuenta = Integer.parseInt(String.valueOf(valor_cuenta.charAt(i)));
            dg_control += dg_cuenta * fc[i];
        }

        dg_control = 11 - (dg_control % 11);

        if (dg_control == 11) {
            dg_control = 0;
        } else if (dg_control == 10) {
            dg_control = 1;
        }
        return dg_control;
    }
}
