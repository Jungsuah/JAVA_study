package daily0404;

public class sin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 360��: 2pi = 1��:x

		double k27_fSin;// ���� ����
		for (int k27_i = 0; k27_i < 360; k27_i++) {// 0������ 359������ �ݺ�
			k27_fSin = Math.sin(k27_i * 3.141592 / 180);// 1���� ���� �ϸ鼭 ������ ���ؼ� �ش��ϴ� ���� �� ���
			System.out.printf("%d sin ==> %f\n", k27_i, k27_fSin);// 360������ ���� ��� ������ ���
		}
		for (int k27_i = 0; k27_i < 360; k27_i++) {// 0������ 359������ �ݺ�
			k27_fSin = Math.sin(k27_i * 3.141592 / 180);// 1���� ���� �ϸ鼭 ������ ���ؼ� �ش��ϴ� ���� �� ���

			int k27_iSpace = (int) ((1.0 + k27_fSin) * 50);// int������ ����ȯ
			// 1�� ���ϴ� ������ -1~1�������� -1�� ����� ������ֱ� ���ؼ� �׸��� *50�� �����ν� ���� ���� ���
			for (int k27_j = 0; k27_j < k27_iSpace; k27_j++)// k27_iSpace��ŭ ��ĭ�� ���
				System.out.printf(" ");// ���� ���
			System.out.printf("*[%f][%d]\n", k27_fSin, k27_iSpace);// �Ǽ��� ���������� ���

		}
	}

}
