package java_intensive; // ��Ű�� ����

public class Calc implements Calculator { // Calculator �������̽��� ������ Calc Ŭ���� ����

	public static final double PI = 3.14; // ������ ���� ���� ��� ����

	private int memory; // �ν��Ͻ� ������ ������ ���� memory�� ����

//	public int add(int a, int b) { // �� ������ ���� �� �� ����� ��ȯ�ϴ� add �޼ҵ� ����
//		int sum = a + b; // a�� b�� ���� ���� sum ������ ����
//		this.memory = sum; // �ν��Ͻ� ���� memory�� sum ���� ����
//		return sum; // sum ���� ��ȯ
//	}

	public static double getCircleLenth(double r) { // ���� �ѷ��� ����Ͽ� ��ȯ�ϴ� ���� �޼ҵ� getCircleLenth ����
		return 2 * PI * r; // ������(��� PI)�� ������ r�� �̿��Ͽ� ���� �ѷ��� ����Ͽ� ��ȯ
						//Calc.PI // Ŭ������ ���� ������ static ���� PI ��� ����
	}

	public int getMemory() { // �ν��Ͻ� ���� memory�� ���� ��ȯ�ϴ� getMemory �޼ҵ� ����
		return memory;
	}

	public void setMemory(int memory) { // �ν��Ͻ� ���� memory�� ���� �����ϴ� setMemory �޼ҵ� ����
		this.memory = memory; // �޼ҵ� �Ű������� ���� ���� �ν��Ͻ� ���� memory�� ����
	}

	@Override
	public int add(int a, int b) { // Calculator �������̽����� ��ӹ��� add �޼ҵ� ����
		return 0; // add �޼ҵ��� ��� ������ �Ǿ����� �ʾƼ�, �ϴ��� 0�� ��ȯ�ϵ��� �ӽ� ����
	}
}
