package daily0404;

import java.text.DecimalFormat;

public class price1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k27_item = "���";// ǰ�� ���� ����
		int k27_unit_price = 5000;// �ܰ� ���� ����
		int k27_num = 500;// ���� ���� ����
		int total = 0;// �հ� ���� ���� �� �ʱ�ȭ

		DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// ���ڸ� ���� �޸� ���

		System.out.printf("====================================================\n");// ���
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "ǰ��", "�ܰ�", "����", "�հ�");
		// �ʺ� 20���̰�, �ִ� ���ڼ��� 20�ڷ� ǰ�� ���, �ʺ� 8���̰�, �ִ� ���� ���� 8�ڷ� �ܰ�,����, �հ� ���
		System.out.printf("====================================================\n");// ���

		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n", k27_item, k27_df.format(k27_unit_price),
				k27_df.format(k27_num), k27_df.format(k27_unit_price * k27_num));// format�� �������� ���
		System.out.printf("=====================================================\n");// ���

	}

}
