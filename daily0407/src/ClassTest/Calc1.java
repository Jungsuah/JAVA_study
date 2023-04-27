package ClassTest;

public class Calc1 {//메소드 오버라이딩 -> 메소드 명은 같으나 매개변수나 갯수가 다를때 사용!
	public int sum(int a, int b) {
		return a + b;
	}

	public int sum(int a, int b, int c) {
		return a + b + c;
	}

	public int sum(int a, int b, int c, int d) {
		return a + b + c + d;
	}

	public double sum(double a, double b) {
		return a + b;
	}
}
