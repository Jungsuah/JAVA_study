package daily0404;

public class calendar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1���� 12���� �ݺ��ض�
			System.out.printf(" %d �� => ", k27_i);
			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1����31���� �ݺ��ض�

				System.out.printf("%d,", k27_j - 1);
				
				//�Ѵ� �����ؾ� �ϱ� ������ &&�� ����.
				if (k27_i == 1 && k27_j == 31) {// 1�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 2 && k27_j == 28) {// 2�����̰� 28���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 3 && k27_j == 31) {// 3�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 4 && k27_j == 30) {// 4�����̰� 30���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 5 && k27_j == 31) {// 5�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 6 && k27_j == 30) {// 6�����̰� 30���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 7 && k27_j == 31) {// 7�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 8 && k27_j == 31) {// 8�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 9 && k27_j == 30) {// 9�����̰� 30���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 10 && k27_j == 31) {// 10�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 11 && k27_j == 30) {// 11�����̰� 30���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
				if (k27_i == 12 && k27_j == 31) {// 12�����̰� 31���� ��
					System.out.printf("%d.", k27_j);//���
					break;
				}
			}
			System.out.printf("\n");
		}

	}

}
