package java_intensive; // 패키지 선언

public class Calc implements Calculator { // Calculator 인터페이스를 구현한 Calc 클래스 선언

	public static final double PI = 3.14; // 원주율 값을 담은 상수 선언

	private int memory; // 인스턴스 변수로 정수형 변수 memory를 선언

//	public int add(int a, int b) { // 두 정수를 더한 후 그 결과를 반환하는 add 메소드 선언
//		int sum = a + b; // a와 b를 더한 값을 sum 변수에 저장
//		this.memory = sum; // 인스턴스 변수 memory에 sum 값을 저장
//		return sum; // sum 값을 반환
//	}

	public static double getCircleLenth(double r) { // 원의 둘레를 계산하여 반환하는 정적 메소드 getCircleLenth 선언
		return 2 * PI * r; // 원주율(상수 PI)과 반지름 r을 이용하여 원의 둘레를 계산하여 반환
						//Calc.PI // 클래스명 생략 가능한 static 변수 PI 사용 예시
	}

	public int getMemory() { // 인스턴스 변수 memory의 값을 반환하는 getMemory 메소드 선언
		return memory;
	}

	public void setMemory(int memory) { // 인스턴스 변수 memory에 값을 설정하는 setMemory 메소드 선언
		this.memory = memory; // 메소드 매개변수로 받은 값을 인스턴스 변수 memory에 저장
	}

	@Override
	public int add(int a, int b) { // Calculator 인터페이스에서 상속받은 add 메소드 구현
		return 0; // add 메소드의 기능 구현이 되어있지 않아서, 일단은 0을 반환하도록 임시 구현
	}
}
