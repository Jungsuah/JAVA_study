package daily0404;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] k27_iLMD = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// �迭 ����
		// �� �迭�� 0���� �����Ѵٴ� �Ϳ� ����
		// iLMD[0] ~ iLMD[11]�̴�.

		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1���� 12���� �ݺ�
			System.out.printf(" %d�� =>", k27_i);
			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1���� 31���� �ݺ�
				System.out.printf("%d", k27_j);

				if (k27_iLMD[k27_i - 1] == k27_j)
					break;
				System.out.print(",");// �������� �޸� �� ���

			}
			System.out.printf("\n");
		}
	}

}
