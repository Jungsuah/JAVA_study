package daily0404;

public class while1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int k27_i = 2; k27_i <= 9; k27_i++) {
			for (int k27_j = 1; k27_j <= 9; k27_j++) {
				System.out.println(k27_i + " * " + k27_j + " = " + k27_i * k27_j);
			}
		}
		int k27_i = 2;// ���� ���� �� �ʱ�ȭ
		while (k27_i <= 9) {// i�� 9���� �۰ų� ���� ������ �ݺ�
			int k27_j = 1;// ���� ���� �� �ʱ�ȭ
			while (k27_j <= 9) {// j�� 9���� �۰ų� ���� ������ �ݺ�
				System.out.println(k27_i + " * " + k27_j + " = " + k27_i * k27_j);// ���
				k27_j++;// j�� +1 ���ش�.

			}
			k27_i++;// i�� +1 ���ش�.
		}

	}

}
