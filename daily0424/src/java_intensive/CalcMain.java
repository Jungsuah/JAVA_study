package java_intensive;

public class CalcMain {
	public static void main(String[] args) {
		Calc calc1 = new Calc();
		Calc calc2 = new Calc();
//		Calculator calc1 = new Calc(); -> �������̽��� �����ϸ� �̷��� ����ϱ�
		
		int r1 = calc1.add(3, 5);
		int r2 = calc2.add(3, 5);
		
		System.out.println(calc1.getMemory());//heap ����
		System.out.println(calc2.getMemory());
		
		System.out.println(r1);//stack ����
		System.out.println(r2);
		
		double r3 = Calc.getCircleLenth(3);//static ������ �ִ� class �Ҽ����� ��
		System.out.println(r3);
	}
}
