package daily0404;

public class case1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1���� 12���� �ݺ�
			System.out.printf(" %d�� =>", k27_i);
			LOOP: for (int k27_j = 1; k27_j < 32; k27_j++) {// 1���� 31�� ���� �ݺ�
				System.out.printf("%d,", k27_j);

				switch (k27_i) {
				case 4:
				case 6:
				case 9:
				case 7:
				case 11: // 4��, 6��, 9��, 7��, 11���� ���
					if (k27_j == 30)// ���� 30���̸� LOOP�� ����������.
						break LOOP;//LOOP�� Ż��
					// ���� �̷� ǥ�� �� ��
					// LOOP��� ǥ���ڰ� ������ ������ ���
					break;//case�� Ż��
				case 2: if(k27_j==28) break LOOP;//LOOP�� Ż��
					break;//case�� Ż��
				}
			}
			System.out.printf("\n");// �� �� ���
		}

	}

}
