/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criptografia;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Esta clase sirve para realizar el encriptado de los campos en la base de datos.
 * @author 233133_233259
 */
@Converter
public class EncriptadorAESConverter implements AttributeConverter<String, String> {

    /**
     * Este atributo representa la clave secreta utilizada para realizar el encriptado de los campos.
     */
    private static final String CLAVE_SECRETA = "k4dc2D_gD2_5DSa_bdMs_dc2DlSV_553";

    /**
     * Este método realiza el encriptado de una cadena utilizando el algoritmo aes.
     * @param attribute Representa la cadena a encriptar.
     * @return Regresa la cadena encriptada con el algoritmo aes.
     */
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            Key clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            byte[] textoCifrado = cifrador.doFinal(attribute.getBytes());
            return Base64.getEncoder().encodeToString(textoCifrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Este método realiza el desencriptado de una cadena utilizando el algoritmo aes.
     * @param dbData Representa la cadena a desencriptar.
     * @return Regresa el texto en claro.
     */
    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            Key clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cifrador.init(Cipher.DECRYPT_MODE, clave);
            byte[] textoDescifrado = cifrador.doFinal(Base64.getDecoder().decode(dbData));
            return new String(textoDescifrado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Este método realiza el encriptado de una cadena utilizando el algoritmo aes.
     * @param texto Representa la cadena a encriptar.
     * @return Regresa la cadena encriptada con el algoritmo aes.
     */
    private String encriptar(String texto) {
        return convertToDatabaseColumn(texto);
    }

    /**
     * Este método realiza el desencriptado de una cadena utilizando el algoritmo aes.
     * @param textoEncriptado Representa la cadena a desencriptar.
     * @return Regresa el texto en claro.
     */
    private String desencriptar(String textoEncriptado) {
        return convertToEntityAttribute(textoEncriptado);
    }
}