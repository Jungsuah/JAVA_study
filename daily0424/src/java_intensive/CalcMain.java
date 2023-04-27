package java_intensive;

public class CalcMain {
	public static void main(String[] args) {
		Calc calc1 = new Calc();
		Calc calc2 = new Calc();
//		Calculator calc1 = new Calc(); -> 인터페이스로 구현하면 이렇게 사용하기
		
		int r1 = calc1.add(3, 5);
		int r2 = calc2.add(3, 5);
		
		System.out.println(calc1.getMemory());//heap 영역
		System.out.println(calc2.getMemory());
		
		System.out.println(r1);//stack 영역
		System.out.println(r2);
		
		double r3 = Calc.getCircleLenth(3);//static 영역에 있는 class 소속으로 들어감
		System.out.println(r3);
	}
}
