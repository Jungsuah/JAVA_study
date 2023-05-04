package java_intensive; // ��Ű�� ����

public class CalcMain { // Calc Ŭ������ ����� �����ϴ� ���� Ŭ���� ����

	public static void main(String[] args) { // ���α׷��� �������� main �޼ҵ� ����
		Calc calc1 = new Calc(); // Calc Ŭ������ �ν��Ͻ� �����Ͽ� calc1 ������ �Ҵ�
		Calc calc2 = new Calc(); // Calc Ŭ������ �ν��Ͻ� �����Ͽ� calc2 ������ �Ҵ�
//		Calculator calc1 = new Calc(); -> Calculator �������̽��� �����ϵ��� �ڵ带 �����ϸ� �̷��� ��� ����

		int r1 = calc1.add(3, 5); // calc1 ��ü�� add �޼ҵ带 ȣ���Ͽ� 3�� 5�� ���� ���� r1 ������ ����
		int r2 = calc2.add(3, 5); // calc2 ��ü�� add �޼ҵ带 ȣ���Ͽ� 3�� 5�� ���� ���� r2 ������ ����

		System.out.println(calc1.getMemory()); // calc1 ��ü�� memory ���� ��� (heap ������ �����)
		System.out.println(calc2.getMemory()); // calc2 ��ü�� memory ���� ��� (heap ������ �����)

		System.out.println(r1); // r1 ������ ���� ��� (stack ������ �����)
		System.out.println(r2); // r2 ������ ���� ��� (stack ������ �����)

		double r3 = Calc.getCircleLenth(3); // Calc Ŭ������ static �޼ҵ��� getCircleLenth�� ȣ���Ͽ� �������� 3�� ���� �ѷ��� ����Ͽ� r3 ������ ����
		System.out.println(r3); // r3 ������ ���� ���
	}
}
