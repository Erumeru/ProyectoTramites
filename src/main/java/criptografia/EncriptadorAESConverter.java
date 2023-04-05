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
 *
 * @author mario
 */
@Converter
public class EncriptadorAESConverter implements AttributeConverter<String, String> {

    private static final String CLAVE_SECRETA = "k4dc2D_gD2_5DSa_bdMs_dc2DlSV_553";

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
    
    private String encriptar(String texto) {
        return convertToDatabaseColumn(texto);
    }

    private String desencriptar(String textoEncriptado) {
        return convertToEntityAttribute(textoEncriptado);
    }
}