package daily0404;

public class for2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_sum = 0;
		for (int k27_i = 0; k27_i < 10; k27_i++) {// 0���� 9���� �ݺ��ض�
			k27_sum = k27_sum + k27_i;// ������ ���ϱ�
		}
		System.out.printf("k27_sum %d\n", k27_sum);// ������ ���� �� ���

		for (int k27_i = 1; k27_i < 10; k27_i++) {// 1���� 9���� �ٺ��ض�
			System.out.printf("**********************\n", k27_i);
			System.out.printf("     ������ %d ��\n", k27_i);// for�� ���鼭 �� �� ����
			System.out.printf("**********************\n", k27_i);

			for (int k27_j = 1; k27_j < 10; k27_j++) {// 1���� 9���� �ݺ��ض�
				System.out.printf(" %d * %d = %d \n", k27_i, k27_j, k27_i * k27_j);
				// i�� �ѹ� ���� j�� 9�� ���鼭 ���Ѱ� ���
			}

		}

	}

}
