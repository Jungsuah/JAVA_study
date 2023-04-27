package daily0323;

public class Innerclass extends PrintClass {

	public static void main(String[] args) {

		PrintClass.pirintInteger();
		PrintClass.printAdd();

	}

}

class PrintClass {
	static int a, b, n;

	public PrintClass() {
		this(0, 0, 0);
	}

	public PrintClass(int a, int b, int n) {

		this.a = a;
		this.b = b;
		this.n = n;
	}

	public static void pirintInteger() {
		System.out.println(n);
	}

	public static void printAdd() {
		int sum;
		sum = a + b;
		System.out.println(sum);
	}
}
