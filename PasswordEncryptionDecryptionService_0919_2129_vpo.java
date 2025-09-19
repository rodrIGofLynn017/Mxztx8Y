// 代码生成时间: 2025-09-19 21:29:25
package com.example.demo.service;

import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class PasswordEncryptionDecryptionService {

    private static final String ALGORITHM = "AES";

    // Generate a secret key for encryption and decryption
    public Key generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128); // You can change the key size
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }

    // Encrypt the password
    public String encryptPassword(String password, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt the password
    public String decryptPassword(String encryptedPassword, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(decodedValue);
        return new String(decryptedBytes);
    }

    // Wrapper method with error handling
    public String getEncryptedPassword(String password) {
        try {
            Key key = generateKey();
            return encryptPassword(password, key);
        } catch (Exception e) {
            // Log the error and handle it accordingly
            // For simplicity, just return the original password
            return password;
        }
    }

    // Wrapper method with error handling
    public String getDecryptedPassword(String encryptedPassword) {
        try {
            Key key = generateKey();
            return decryptPassword(encryptedPassword, key);
        } catch (Exception e) {
            // Log the error and handle it accordingly
            // For simplicity, just return the encrypted password
            return encryptedPassword;
        }
    }
}
