package daily0404;

public class star1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_iA, k27_iB;// ���� ����

		k27_iA = 0;// ���� ��Ÿ���� ������ ���⼭ �ʱ�ȭ�� �ؾ� �ؿ��� ++�� A�� while���� Ż ��
					// �ʱ�ȭ���� �ʴ´�.

		while (true) {// �ݺ�
			k27_iB = 0;// ���� ������ ���� ���ؼ� �ʱ�ȭ���ش�.
			while (true) {// �ݺ�
				System.out.printf("��");

				if (k27_iA == k27_iB)// ���� k27_iA�� k27_iB�� ������ ������
					break;
				k27_iB++;// +1

			}
			System.out.printf("\n");// �� �� ���
			k27_iA++;// +1
			if (k27_iA == 30)// ����k27_iA�� 30�̰����� (30��°)������
				break;
		}

	}

}
