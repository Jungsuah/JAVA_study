package daily0405;

public class sss {
	public static void main(String[] args) {
		int k27_iNumVal = 200000000;// ���� ���� �� �ʱ�ȭ
		String k27_sNumVal = String.valueOf(k27_iNumVal);// string ������ ����ϱ� ���� string.valueOf�� ���� (10�ڸ�)
		String k27_sNumVoice = "";// ���� ���� �� �ʱ�ȭ
		System.out.printf(" ==> %s [%d�ڸ�]\n", k27_sNumVal, k27_sNumVal.length());// k27_sNumVal�� �ڸ��� ���

		int k27_i, k27_j;// ���� ����
		String[] k27_units = { "��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��" };// �迭 ����
		String[] k27_unitX = { "", "��", "��", "õ", "��", "��", "��", "õ", "��", "��" };// �迭 ����

		k27_i = 0;// ���� �ڸ���
		k27_j = k27_sNumVal.length() - 1;// k27_sNumval�� ���̿��� �ϳ� ���� ���� ����(9)

		while (true) {
			if (k27_i >= k27_sNumVal.length())// k27_i�� k27_sNumVal����(10)���� ũ�ų� ������ break;
				break;

			System.out.printf("%s[%s]", k27_sNumVal.substring(k27_i, k27_i + 1),
					// substring���� k27_i���� k27_i + 1 �ڸ��� �������� �߶� ���
					k27_units[Integer.parseInt(k27_sNumVal.substring(k27_i, k27_i + 1))]);
			// int������ ����ȯ�� ���� k27_units�� �ε��� ������ �־���
			if (k27_iNumVal == 0 && k27_sNumVal.length() == 1) {
				k27_sNumVoice = k27_units[0];
				break;
			}
			if (k27_sNumVal.substring(k27_i, k27_i + 1).equals("0")) {
				// �ش� �ڸ����� 0�̶� ������
				if (k27_unitX[k27_j].equals("��") || k27_unitX[k27_j].equals("��")) {
					// k27_unitX�� �ش� �ε����� ���̳� ���� ������
					if (k27_i > 2 && k27_sNumVal.substring(k27_i - 3, k27_i).equals("000")) {
						// k27_i > 2�� �ϴ� ������ k27_i - 3�� �� �� ������ ����� �ʰ� �ϱ����ؼ�
						// k27_i - 3���� k27_i������ �߶� �� ���� 000�̸�
						k27_sNumVoice = k27_sNumVoice + "";// ""�� ����
					} else {
						k27_sNumVoice = k27_sNumVoice + "" + k27_unitX[k27_j];// �ƴϸ� �� �� ����
					}
				} else {
					// �ƹ����� �� ��

				}
			} else {
				k27_sNumVoice = k27_sNumVoice + k27_units[Integer.parseInt(k27_sNumVal.substring(k27_i, k27_i + 1))]
						+ k27_unitX[k27_j];// ����
			}
			k27_i++;// �ڸ����� �ϳ� �÷���
			k27_j--;// �ڸ����� �ϳ� �ٿ���

		}

		System.out.printf("\n %s[%s]\n", k27_sNumVal, k27_sNumVoice);// ������ �� ���
	}
}
