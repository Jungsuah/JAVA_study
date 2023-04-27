package daily0322_ppt4;

public class A4class {

	String word = null;

	public A4class(String word) {

		this.word = word;

	}

	public String Encryption(String m) {
		StringBuilder encryptedMessage = new StringBuilder();
		for (char c : m.toCharArray()) {
			if (c == ' ') {
				encryptedMessage.append(' ');
				continue;
			}
			char shifted = (char) ((c - 'a' + 3) % 26 + 'a');
			encryptedMessage.append(shifted);
		}
		return encryptedMessage.toString();

	}

	public static String decrypt(String m) {
		StringBuilder decryptedMessage = new StringBuilder();
		for (char c : m.toCharArray()) {
			if (c == ' ') {
				decryptedMessage.append(' ');
				continue;
			}
			char shifted = (char) ((c - 'a' - 3 + 26) % 26 + 'a');
			decryptedMessage.append(shifted);
		}
		return decryptedMessage.toString();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
