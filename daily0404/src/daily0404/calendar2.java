package daily0404;

public class calendar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1���� 12���� �ݺ�(��)
			System.out.printf(" %d�� =>", k27_i);

			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1���� 31���� �ݺ�(��)
				System.out.printf("%d,", k27_j);

				if (k27_i == 4 || k27_i == 6 || k27_i == 9 || k27_i == 7 || k27_i == 1) {
					// ���� 4���̰ų� 6���̰ų� 9���̰ų� 7���̰ų� 1���� ���
						
					if (k27_j == 30)// ���� 30���� ��
						break;
				}
				if (k27_i == 2) {// ���� 2���� ��
					if (k27_j == 28)// ���� 28���� ��
						break;
				}
			}
			System.out.printf("\n");// �� �� ���
		}
	}

}
