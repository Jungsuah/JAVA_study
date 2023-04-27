package daily0323;

import java.util.Scanner;

public class A10 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while(true) {
		String sentence1 = scanner.next();
		String sentence2 = scanner.next();

		int truecount = 0;
		for (int i = 0; i < sentence1.length(); i++) {
			char ch1 = sentence1.charAt(i);
			for (int j = 0; j < sentence2.length(); j++) {
				char ch2 = sentence2.charAt(j);
				if (ch1 == ch2) {
					truecount++;
				}
			}
		}
		if (truecount == sentence1.length()) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}

	}
	}

}
