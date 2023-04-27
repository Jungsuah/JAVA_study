package daily0324;

import java.util.Iterator;

//사용자가 문자열 입력
//암호화된 문자열 출력

//문자열을 암호화하려면 배열을 사용하여 문자를 일대일로 일치시킵니다.
//(ex, original = {1, 2, 3}, encrypted = {a, b, c})
//
//시나리오 작성 및 구성
//
//abcd
//zyxw

public class A3 {
	public static void main(String[] args) {
		// 채우는 구문
		String[] original = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String[] encrypted = { "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i",
				"h", "g", "f", "e", "d", " c", " b", "a" };
		
		String src = "abcd123";
		String result = "";
 		
		for (int i = 0; i < src.length(); i++) {
			char c = src.charAt(i);
			int index = (int)c;
			
			// 알파벳 암호화
			if(c >= 'a'&& 'z' >= c) {
				// c == 'a' == 97 때문에 -97을 대입한다.
				// ex) encrypted[index-97]; == encrypted[0];
				result += encrypted[index-97];
			// 숫자 암호화	
			}else if(c >= '0'&& '9' >= c) {
				// c == '0' == 97 때문에 -48을 대입한다.
				result += encrypted[index-48];
			}
		}
		System.out.println("원본\t: "+src);
		System.out.println("암호화\t: "+result);
	}
}
