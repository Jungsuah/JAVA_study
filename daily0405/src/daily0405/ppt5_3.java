package daily0405;

public class ppt5_3 {
	public static void main(String[] args) {
		int k27_iWeekday = 5;// ���� �ʱ�ȭ
		int[] k27_iEnd = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// ���� ����¥ �迭 ����
		boolean k27_yd_flag = true;// ���� �˻�

		for (int k27_iMon = 0; k27_iMon < 12; k27_iMon++) {// 0���� 11���� �ݺ�
			System.out.printf("\n\n        %d��\n", k27_iMon + 1);// �� �������� ���
			System.out.printf("=====================\n");// ���
			System.out.printf(" �� �� ȭ �� �� �� ��\n");// ���

			if (k27_yd_flag == true) {// ������ true��
				k27_iEnd[1] = 29;// ����¥�� 29���̰�
			} else {
				k27_iEnd[1] = 28;// �ƴϸ� ����¥�� 28���̴�.
			}

			int k27_dayOfWeek = k27_iWeekday;// k27_iWeekday�� k27_dayOfWeek�� ����

			for (int k27_i = 1; k27_i <= k27_iEnd[k27_iMon]; k27_i++) {
				// 1���� k27_End[k27_iMon]�� �迭�� �ε��� ����ŭ �ݺ����鼭 1�� ������Ų��.(�� ���)
				if (k27_i == 1) {// 1���� ��
					for (int k27_j = 0; k27_j < k27_dayOfWeek; k27_j++) {
						// 0���� k27_dayOfWeek �� ������ �ݺ��ض�.
						System.out.printf("%3s", "");
					} // k27_dayOfWeek��ŭ ��ĭ ���
				}
				System.out.printf("%3d", k27_i);// ĭ�� ���缭 ������ ���ķ� ���
				k27_iWeekday++;// ���� ����

				if (k27_iWeekday == 7) {// ������ �Ͽ����̸�
					k27_iWeekday = 0;// 0���� �ٲ���
					System.out.printf("\n");// ���� �ٷ�
				}
			}

		}
	}
}
