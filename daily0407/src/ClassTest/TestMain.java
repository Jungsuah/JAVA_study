package ClassTest;

public class TestMain {
	private static int inVal;//Ŭ���������� ����Ҽ��ִ� ������ ���� ����

	public static void up() {//static �޼ҵ� up ����
		inVal++;//ȣ��Ǹ� ������ inVal+1
		System.out.printf("�� �׳� �޼ҵ�[%d]\n", inVal);//+1�� inVal�� ���
	}

	public static void main(String[] args) {//���κ�
		inVal = 0;//static ���� inVal 0���� �ʱ�ȭ
		Elevator elev = new Elevator();//Elevator ��ü ����

		up();//TestMain�� �ִ� up �޼ҵ� ȣ��

		for (int i = 0; i < 10; i++) {//0 - 9���� 10�� �ݺ�
			elev.up(); // ������ Elevator ��ü�� �ִ� �޼ҵ� up�� ȣ��
			System.out.printf("MSG[%s]\n", elev.help);//up�޼ҵ�� ������� ���ڿ� help ��� 
		}

		for (int i = 0; i < 10; i++) {//0 - 9���� 10�� �ݺ�
			elev.down();// ������ Elevator ��ü�� �ִ� �޼ҵ� down�� ȣ��
			System.out.printf("MSG[%s]\n", elev.help);//up�޼ҵ�� ������� ���ڿ� help ��� 
		}
	}
}
