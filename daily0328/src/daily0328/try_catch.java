package daily0328;

import java.util.InputMismatchException;
import java.util.Scanner;

public class try_catch {
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
				System.out.println("catch");
				if (a == 0) {
					try {
						a = Integer.parseInt(sc.next());
					} catch (Exception e) {
					}
				} else {
					break;
				}
			}
			if (a != 0) {
				break;
			}
		}
		System.out.println(a);
	}
}
