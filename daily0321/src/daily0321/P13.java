package daily0321;

import java.util.Scanner;

public class P13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문장을 입력하세요: ");
		String sentence = sc.nextLine();
		System.out.print("단어를 입력하세요: ");
		String word = sc.next();

		int count = 0;
		int i = 0;
		int j = 0;
		while (i < sentence.length() && j < word.length()) {
			if (sentence.charAt(i) == ' ') {
				i++;
				continue;
			}
			if (word.charAt(j) == sentence.charAt(i)) {
				j++;
			}
			i++;
			if (j == word.length()) {
				count++;
				j = 0;
			}
		}
		System.out.println("만들 수 있는 단어 개수: " + count);
	}
}
