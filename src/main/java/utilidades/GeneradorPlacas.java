/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Random;

/**
 *
 * @author mario
 */
public class GeneradorPlacas {
    
    public static String generarCadena() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        // Generamos tres letras aleatorias
        for (int i = 0; i < 3; i++) {
            char c = (char) (rnd.nextInt(26) + 'a');
            sb.append(c);
        }
        // Añadimos el guión
        sb.append("-");
        // Generamos un número aleatorio de tres cifras
        int numero = rnd.nextInt(900) + 100;
        sb.append(numero);

        return sb.toString();
    }
    
}
