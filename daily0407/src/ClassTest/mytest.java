package ClassTest;

public class mytest {

	static Elevator2 elev1;
	static Elevator2 elev2;
	static Elevator2 elev3;

	public static void main(String[] args) {
		elev1 = new Elevator2(); // �⺻�����ڷ� ���� ����������
		elev2 = new Elevator2(20, 1, 8);// ���� ����������1
		elev3 = new Elevator2(50, -3, 5);// ���� ����������2

		for (int i = 0; i < 20; i++) {
			elev1.up();
			elev1.msg("1�� ���� ���� ������");
			elev2.up();
			elev2.msg("1�� ���� ���� ������");
			elev3.up();
			elev3.msg("1�� ���� ���� ������");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			elev1.up(2);
			elev1.msg("1�� ���� 2���� ������");
			elev2.up(2);
			elev2.msg("1�� ���� 2���� ������");
			elev3.up(2);
			elev3.msg("1�� ���� 2���� ������");
		}
		System.out.println();
		for (int i = 0; i < 20; i++) {
			elev1.up(3);
			elev1.msg("1�� ���� 3���� ������");
			elev2.up(3);
			elev2.msg("1�� ���� 3���� ������");
			elev3.up(3);
			elev3.msg("1�� ���� 3���� ������");
		}
	}
}
