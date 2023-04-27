package daily0328;

import java.util.InputMismatchException;
import java.util.Scanner;

public class try_catch1 {
	public static void main(String[] args) {

		int a = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("try");
				a = Integer.parseInt(sc.next());
			} catch (InputMismatchException e) {
				System.out.println("catch");
			} finally {
			}
			if (a != 0) {
				break;
			}
		}
		System.out.println(a);
	}
}
