package daily0619_Encryption;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class P1 {
    public static void main(String[] args) {
        String key = "abcdefghijklmnop"; // 16-byte (128-bit) key
        String text = "hello world";

        P1 p1 = new P1();
        String encryptedText = p1.encrypt(key, text);
        System.out.println("Encrypted Text: " + encryptedText);
    }

    public String encrypt(String key, String text) {
        String cipherText = "";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(key.getBytes("UTF-8"), 0, cipher.getBlockSize()));
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), ivspec);
            cipherText = new String(Base64.encodeBase64(cipher.doFinal(text.getBytes("UTF-8"))), "UTF-8");
        } catch (Exception e) {
            cipherText = "hello world";
            e.printStackTrace();
        }
        return cipherText;
    }
}