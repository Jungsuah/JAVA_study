package ClassTest;

public class TestMain2 extends Calc1 {// Calc1 클래스는 상속받아 메소드를 사용할 수있다
	public static void main(String[] args) {
		Calc1 cc = new Calc1();// 메소드를 가져오기 위해 객체 생성

		System.out.println("2개의 덧셈이 호출됨 [" + cc.sum(1, 2) + "]");
		System.out.println("3개의 덧셈이 호출됨 [" + cc.sum(1, 2, 3) + "]");
		System.out.println("4개의 덧셈이 호출됨 [" + cc.sum(1, 2, 3, 4) + "]");
		System.out.println("더블형의 덧셈이 호출됨 [" + cc.sum(1.3, 2.4) + "]");
	}
}
