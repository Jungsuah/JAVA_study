package daily0403_ppt2;

public class star2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_n, k27_m;
		k27_m = 20;// ��
		k27_n = 1;// ������

		while (true) {
			for (int k27_i = 0; k27_i < k27_m; k27_i++)// ������ �� ������ ���� ������ �ݺ�
				System.out.printf(" ");// ���� ���
			for (int k27_i = 0; k27_i < k27_n; k27_i++)// �� ������ ������ ���� ������ �ݺ�
				System.out.printf("��");// �� ���
			System.out.printf("\n");// �� �� ���

			k27_m = k27_m - 1;// ���� �ϳ��� �ش�.
			k27_n = k27_n + 2;// ���� 2���� �þ��

			if (k27_m < 0)// ���� 0���� ������ break
				break;

		}

	}

}
