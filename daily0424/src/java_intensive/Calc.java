package java_intensive;

public class Calc implements Calculator{
	public static final double PI = 3.14;//��� - ���� �ٲ��� ����
	private int memory;
	
//	public int add(int a, int b) {
//		int sum = a + b;
//		this.memory = sum;
//		return sum;
//	}
	
	public static double getCircleLenth(double r) {//��ü ���忡�� ���������� ���Ǵ� ���̸� static���� �����ؼ� ���
		return 2 * PI * r;
//		Calc.PI //Calc�� ������ ���̴�
	}
	
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
