package daily0328;

import java.util.Scanner;

public class main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		while (true) {
			try {
				number = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {

			} finally {

			}
			if (number != 0) {
				break;
			}
		}
		System.out.println("#" + number);
	}

}
