package daily0404;

public class if1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k27_iI;// ���� ����
		double k27_iD;// ���� ����

		k27_iI = 10 / 3;// �ʱ�ȭ
		k27_iD = 10 / 3.0;// �ʱ�ȭ

		// int �� double �� ����������� �Ǽ��������̹Ƿ� ���� �ʴ�.
		if (k27_iI == k27_iD)
			System.out.printf("equla\n");// k27_iI �� k27_iD�� ���� ��� equal�� ���
		else
			System.out.printf("Not equal[%f][%f]\n", (double) k27_iI, k27_iD);// ���� ���� ��� ���

		// ���� ��ȿ���ڱ��� ǥ�õ� �� ������ �ٸ���.
		if (k27_iD == 3.333333)
			System.out.printf("equal\n");// k27_iD�� 3.333333�� ������ �߷�
		else
			System.out.printf("Not equal[3.333333][%f]\n", k27_iD);// �ٸ� ��� ���

		k27_iD = (int) k27_iD;// k27_iD�� int�� ����ȯ�����Ƿ� ����
		if (k27_iI == k27_iD)
			System.out.printf("equal\n");// k27_iI �� k27_iD�� ���� ��� equal�� ���
		else
			System.out.printf("Not equal[%f][%f]\n", (double) k27_iI, k27_iD);// ���� ���� ��� ���

		System.out.printf("int�� �μ�[%d][%f]\n", k27_iI, k27_iD);// k27_iI�� int�� �μ��ϸ� 3
		System.out.printf("double�� �μ� [%f][%f]\n", (double) k27_iI, k27_iD);// k27_iI�� double�� �μ��ϸ� 3.333333

		char k27_a = 'c';// ���� ����
		if (k27_a == 'b')// k27_a�� b�� ������
			System.out.printf("a�� b�̴�\n");// ���
		if (k27_a == 'c')// k27_a�� c�� ������
			System.out.printf("a�� c�̴�\n");// ���
		if (k27_a == 'd')// k27_a�� d�� ������
			System.out.printf("a�� d�̴�\n");// ���

		String k27_aa = "abcd";// ���� ����

		if (k27_aa.equals("abcd"))// ���ڿ� ���� ���� == ��ſ� equals�� ����.
			System.out.printf("aa�� abcd�̴�\n");// k27_aadhk abcd�� ������ ���
		else
			System.out.printf("aa�� abcd�� �ƴϴ�\n");// �ƴϸ� ���

		boolean k27_bb = true;// k27_bb�� �⺻������ true�� ����
		if (!!k27_bb)// ���� k27_bb��(!�� not�ε� !!�̹Ƿ� true) true�̸�
			System.out.printf("bb�� �ƴϸ� ���̴�.\n");// ���
		else
			System.out.printf("bb�� �ƴϸ� �����̴�\n");// �ƴϸ� ���

	}

}
