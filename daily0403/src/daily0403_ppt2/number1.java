package daily0403_ppt2;

public class number1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] k27_units = { "��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��" };// �迭 ����
		for (int k27_i = 0; k27_i < 101; k27_i++) {// 0���� 100���� �ݺ�
			if (k27_i >= 0 && k27_i < 10) {// k27_i�� 0���� ũ�ų� ���� 10���� ���� ��
				System.out.printf("���� �ڸ� : %s\n", k27_units[k27_i]);// ���
			} else if (k27_i >= 10 && k27_i < 100) {// k27_i�� 10���� ũ�ų� ����,100���� ���� ��
				int k27_i10, k27_i0;// ���� ����
				k27_i10 = k27_i / 10;// �����ڸ�
				k27_i0 = k27_i % 10;// ���� �ڸ�
				if (k27_i0 == 0) {// �����ڸ��� 0�� ��
					System.out.printf("�����ڸ� : %s��\n", k27_units[k27_i10]);// ���
				} else {
					System.out.printf("�����ڸ� : %s��%s\n", k27_units[k27_i10], k27_units[k27_i0]);// �ƴϸ� �̰����

				}
			} else
				System.out.printf("==> %d\n", k27_i);// �ݺ��� Ƚ�� ���
		}

	}

}
