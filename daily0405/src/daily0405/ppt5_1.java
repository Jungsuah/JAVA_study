package daily0405;

public class ppt5_1 {
	public static void main(String[] args) {
		for (int k27_dan = 1; k27_dan <= 9; k27_dan += 3) {// k27_dan�� 1-9���� ���� -> �ѹ� ū ������ �������� 3�ܾ� ����
			System.out.printf("************\t************\t************\n");// �ٳѱ�
			System.out.printf(" ������ %d ��  \t ������ %d �� \t ������ %d ��\t\n", k27_dan, k27_dan + 1, k27_dan + 2);// 1 2 3 �� ���
			System.out.printf("************\t************\t************\n");// �ٳѱ�
			for (int k27_i = 1; k27_i <= 9; k27_i++) {// j�� 1-9���� ��� -> 3�ܾ� ��� -> 1 * 1 = 1 2 * 1 = 2 3 * 1 = 3
				System.out.printf(k27_dan + " * " + k27_i + " = " + (k27_dan * k27_i));
				System.out.printf("\t ");// 4ĭ ����
				System.out.printf(k27_dan + 1 + " * " + k27_i + " = " + (k27_dan + 1) * k27_i);
				System.out.printf("\t ");// 4ĭ ����
				System.out.printf(k27_dan + 2 + " * " + k27_i + " = " + (k27_dan + 2) * k27_i);
				System.out.printf("\t ");// 4ĭ ����
				System.out.println();
				;// 3�� �� ����ϸ� �ٳѱ�
			}
		}
	}
}
