package ClassTest;

public class Calc2 {
	
	public int sum(int a, int b, int c) {//���� 3���޾Ƽ� �����ϴ� �޼ҵ�
		return a + b + c;//����
	}

	public int sum(int a, int b, int c, int d) {//���� 4���޾Ƽ� �����ϴ� �޼ҵ�
		return a + b + c + d;//����
	}

	public int sum(int a, int b, int c, int d, int e) {//���� 5���޾Ƽ� �����ϴ� �޼ҵ�
		return a + b + c + d + e;//����
	}

	public int avg(int a, int b, int c) {//���� 3���޾Ƽ� ����� ���ϴ� �޼ҵ�
		return (int)(a + b + c) / 3;//����
	}

	public double avg(int a, int b, int c, int d) {//���� 4���޾Ƽ� ����� ���ϴ� �޼ҵ�
		return (a + b + c + d) / 4;//����
	}

	public double avg(int a, int b, int c, int d, int e) {//���� 5���޾Ƽ� ����� ���ϴ� �޼ҵ�
		return (a + b + c + d + e) / 5;//����
	}
}
