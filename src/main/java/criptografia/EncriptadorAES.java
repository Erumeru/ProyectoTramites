/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package criptografia;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncriptadorAES {

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final int AES_KEY_SIZE = 128;
    private static final String ENCODING = "UTF-8";
    private static final String SECRET_KEY_STRING = "kJ_d4Mn3_lM25sDf";
    private static SecretKey secretKey;

    static {
        try {
            secretKey = generarClaveSecreta(SECRET_KEY_STRING.getBytes(ENCODING));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertirColumnaBD(String atributo) {
        if (atributo == null) {
            return null;
        }
        try {
            byte[] encryptedBytes = encriptar(atributo.getBytes(ENCODING), secretKey);
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertirAtributoEntidad(String valorBd) {
        if (valorBd == null) {
            return null;
        }
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(valorBd);
            byte[] decryptedBytes = desencriptar(encryptedBytes, secretKey);
            return new String(decryptedBytes, ENCODING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static SecretKey generarClaveSecreta(byte[] keyBytes) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static byte[] encriptar(byte[] data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    private static byte[] desencriptar(byte[] encryptedBytes, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedBytes);
    }
}