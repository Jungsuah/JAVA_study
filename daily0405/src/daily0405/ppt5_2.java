package daily0405;

public class ppt5_2 {
	public static void main(String[] args) {
		for (int k27_dan = 1; k27_dan <= 3; k27_dan++) {//k27_dan�� 3���� ���� -> �� 3�� �ݺ� ���� -> +1�Ǹ� i�� 2�� �Ǿ� 2 5 8 �� ���
			System.out.printf("************\t************\t************\n");// �ٳѱ�
			System.out.printf(" ������ %d ��  \t ������ %d �� \t ������ %d ��\t\n",k27_dan,k27_dan+3,k27_dan+6);
			System.out.printf("************\t************\t************\n");// �ٳѱ�
			for (int k27_i = 1; k27_i <= 9; k27_i++) {//j�� 1-9���� ��� ->i�� 3�� �����ϴϱ� -> 1 * 1 = 1	 4 * 1 = 4	 7 * 1 = 7
				System.out.printf(k27_dan + " * " + k27_i + " = " + (k27_dan * k27_i));//1��
				System.out.printf("\t ");//4ĭ ����
				System.out.printf(k27_dan+3 + " * " + k27_i + " = " + (k27_dan+3) * k27_i) ;//4��
				System.out.printf("\t ");//4ĭ ����
				System.out.printf(k27_dan+6 + " * " + k27_i + " = " + (k27_dan+6) * k27_i);//7��
				System.out.printf("\t ");//4ĭ ����
				System.out.println();//�ٳѱ�
			}
		}
	}
}
