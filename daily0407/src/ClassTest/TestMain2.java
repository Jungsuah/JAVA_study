package ClassTest;

public class TestMain2 extends Calc1 {// Calc1 Ŭ������ ��ӹ޾� �޼ҵ带 ����� ���ִ�
	public static void main(String[] args) {
		Calc1 cc = new Calc1();// �޼ҵ带 �������� ���� ��ü ����

		System.out.println("2���� ������ ȣ��� [" + cc.sum(1, 2) + "]");
		System.out.println("3���� ������ ȣ��� [" + cc.sum(1, 2, 3) + "]");
		System.out.println("4���� ������ ȣ��� [" + cc.sum(1, 2, 3, 4) + "]");
		System.out.println("�������� ������ ȣ��� [" + cc.sum(1.3, 2.4) + "]");
	}
}
