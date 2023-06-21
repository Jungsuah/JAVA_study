package daily0619_Encryption;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class P2 {
    public static void main(String[] args) {
           String key = "abcdefghijklmnop"; // 16-byte (128-bit) key
           String encryptedText = "1dGGFwB4VKhqD6jGCIwT7Q==";

           P2 p2 = new P2();
           String decryptedText = p2.decrypt(key, encryptedText);
           System.out.println("Decrypted Text: " + decryptedText);
       }
   
    public String decrypt(String key, String encryptedText) {
           String plainText = "";
           try {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(key.getBytes("UTF-8"),0,cipher.getBlockSize()));
               cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"),"AES"), ivspec);
               plainText = new String(cipher.doFinal(Base64.decodeBase64(encryptedText.getBytes("UTF-8"))), "UTF-8");
               
           } catch (Exception e) {
               plainText = "";
               e.printStackTrace();
           }
           return plainText;
       }
}