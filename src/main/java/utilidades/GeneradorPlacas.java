/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.Random;

/**
 * Clase que funge como un generador aleatorio de placas
 * @author 233133_233259
 */
public class GeneradorPlacas {
    
    /**
     * Método que genera una cadena con el formato de una placa de automovil
     * @return String con una placa aleatoria de un automovil
     */
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
