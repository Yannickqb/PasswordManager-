import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    public byte[] key;

    public String encrypt(String datatosend, User user) {
        key = user.getPassword().getBytes(StandardCharsets.UTF_8);
        byte[] safebyte;
        //... secret sequence of bytes
        byte[] dataToSend = datatosend.getBytes(StandardCharsets.UTF_8);


        try {
            Cipher c = Cipher.getInstance("AES");

            SecretKeySpec k = new SecretKeySpec(key, "AES");
            c.init(Cipher.ENCRYPT_MODE, k);
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
        }

        return "fehler";
    }

    public String decryption(String data) {
        try {
            byte[] decodedData = Base64.getDecoder().decode(data);
            Cipher c = Cipher.getInstance("AES");
            SecretKeySpec k = new SecretKeySpec(key, "AES");
            c.init(Cipher.DECRYPT_MODE, k);
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
        }
        return "fehler";
    }
}