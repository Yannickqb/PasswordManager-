package verschluesselung;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Encryption {

    public SecretKey hash(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        char[] password = user.getPassword().toCharArray();
        byte[] username = user.getUsername().getBytes(StandardCharsets.UTF_8);
        KeySpec spec = new PBEKeySpec(password, username, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");
        return secret;
    }

    public String encrypt(String datatosend, User user) {
        byte[] safebyte;
        //... secret sequence of bytes
        byte[] dataToSend = datatosend.getBytes(StandardCharsets.UTF_8);


        try {
            Cipher c = Cipher.getInstance("AES");

            SecretKey secretKey = hash(user);
            c.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = c.doFinal(dataToSend);

            safebyte = Base64.getEncoder().encode(encryptedData);
            String encodedDataString = new String(safebyte);
            return encodedDataString;
        }
        catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return "fehler";
    }

    public String decryption(String data, User user) {
        try {
            byte[] decodedData = Base64.getDecoder().decode(data);
            Cipher c = Cipher.getInstance("AES");
            SecretKey secretKey = hash(user);
            c.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = c.doFinal(decodedData);
            String dataString = new String(decryptedData);
            return dataString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "fehler";
    }
}