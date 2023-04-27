package daily0323;

import java.util.Scanner;

public class P10 {
	public static final int father = 1;
	public static final int mother = 2;
	public static final int son = 3;
	public static final int daughterr = 4;

	public static final String fathername = "john";
	public static final String mothername = "kate";
	public static final String sonname = "mike";
	public static final String daughtername = "anna";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = showMenu();

		print(num);
	}

	public static int showMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("#Printing a Name");
		System.out.println("1.Father");
		System.out.println("2.Mother");
		System.out.println("3.Son");
		System.out.println("4.Daughter");
		System.out.print("->");
		int num = scanner.nextInt();

		return num;
	}

	public static void print(int num) {
		if (num == father) {
			System.out.println(fathername);
		} else if (num == mother) {
			System.out.println(mothername);
		} else if (num == son) {
			System.out.println(sonname);
		} else {
			System.out.println(daughtername);
		}

	}

}
