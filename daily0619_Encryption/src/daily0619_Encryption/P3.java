package daily0619_Encryption;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class P3 {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			String number = String.format("%03d", i);

			String key = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + number;
			String encryptedText = "ruDZ3CTS5Md3+ipVKt20hQ==";

			String decryptedText = "";
			try {
				decryptedText = decrypt(key, encryptedText);
				if (decryptedText != "") {
					System.out.println("Decrypted Text: " + number + " " + decryptedText);
				}
			} catch (Exception e) {
			}
		}
	}

	public static String decrypt(String key, String encryptedText) {
		String plainText = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec ivspec = new IvParameterSpec(
					Arrays.copyOfRange(key.getBytes("UTF-8"), 0, cipher.getBlockSize()));
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), ivspec);
			plainText = new String(cipher.doFinal(Base64.decodeBase64(encryptedText.getBytes("UTF-8"))), "UTF-8");

		} catch (Exception e) {
			plainText = "";
		}
		return plainText;
	}
}
