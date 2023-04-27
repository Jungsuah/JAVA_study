package daily0324;

public class A4 {
	public static void main(String[] args) {

		String[] original = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String[] encrypted = { "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i",
				"h", "g", "f", "e", "d", " c", " b", "a" };

		String src = "abcd";
		String result = "";

		for (int i = 0; i < src.length(); i++) {
			char c = src.charAt(i);
			int index = (int) c;

			// 알파벳 암호화
			if (c >= 'a' && 'z' >= c) {
				// c == 'a' == 97 때문에 -97을 대입한다.
				// ex) encrypted[index-97]; == encrypted[0];
				result += encrypted[index - 97];
				// 숫자 암호화
			} else if (c >= '0' && '9' >= c) {
				// c == '0' == 97 때문에 -48을 대입한다.
				result += encrypted[index - 48];
			}
		}
		System.out.println("원본\t: " + src);
		System.out.println("암호화\t: " + result);

		String originalCode = "";

		for (int i = 0; i < result.length(); i++) {
			char c = result.charAt(i);
			// 알파벳 -> 원래 알파벳
			int index = 0;
			if (c >= 'a' && 'z' >= c) {
				for (int j = 0; j < encrypted.length; j++) {
					// c == 'w' == 1
					if (c == encrypted[j].charAt(index)) {
						index = j;
						break;
					}
				}
				index += 97;
				originalCode += (char) index;
			}
		}
		System.out.println("복호화\t: " + originalCode);
	}
}
