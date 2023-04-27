package daily0323;

public class overload1 {

	public static void main(String[] args) {
		print("hello?");
		print(1, 3);
		// TODO Auto-generated method stub

	}
	public static void print(String text) {
		System.out.println(text);
	}
	
	public static void print(int a, int b) {
		int sum = a + b;
		System.out.println(sum);
	}

}
