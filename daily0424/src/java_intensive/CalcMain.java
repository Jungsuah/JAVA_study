package java_intensive; // 패키지 선언

public class CalcMain { // Calc 클래스의 기능을 실행하는 메인 클래스 선언

	public static void main(String[] args) { // 프로그램의 시작점인 main 메소드 선언
		Calc calc1 = new Calc(); // Calc 클래스의 인스턴스 생성하여 calc1 변수에 할당
		Calc calc2 = new Calc(); // Calc 클래스의 인스턴스 생성하여 calc2 변수에 할당
//		Calculator calc1 = new Calc(); -> Calculator 인터페이스를 구현하도록 코드를 변경하면 이렇게 사용 가능

		int r1 = calc1.add(3, 5); // calc1 객체의 add 메소드를 호출하여 3과 5를 더한 값을 r1 변수에 저장
		int r2 = calc2.add(3, 5); // calc2 객체의 add 메소드를 호출하여 3과 5를 더한 값을 r2 변수에 저장

		System.out.println(calc1.getMemory()); // calc1 객체의 memory 값을 출력 (heap 영역에 저장됨)
		System.out.println(calc2.getMemory()); // calc2 객체의 memory 값을 출력 (heap 영역에 저장됨)

		System.out.println(r1); // r1 변수의 값을 출력 (stack 영역에 저장됨)
		System.out.println(r2); // r2 변수의 값을 출력 (stack 영역에 저장됨)

		double r3 = Calc.getCircleLenth(3); // Calc 클래스의 static 메소드인 getCircleLenth를 호출하여 반지름이 3인 원의 둘레를 계산하여 r3 변수에 저장
		System.out.println(r3); // r3 변수의 값을 출력
	}
}
