package daily0403;

public class ppt3_7 {
	public static void main(String[] args) {

		// �迭 ����� ���ÿ� �ʱ�ȭ
		String[] kopo_27_item = { "������", "���Ͻ�", "�Ե�����", "����", "��극" };
		int[] kopo_27_price = { 1000, 2000, 3000, 2500, 1450 };
		int[] kopo_27_amount = { 10, 2, 1, 3, 5 };

		// ���� ���� �� �ʱ�ȭ
		double kopo_27_tax_rate = 0.1;// ����
		int kopo_27_total_sum = 0;// ��ü ��ǰ ����

		System.out.printf("*************************************************\n");
		System.out.printf("               ���� ���� ���ڵ�                  \n");
		System.out.printf("  �׸�       �ܰ�         ����           �հ�    \n");

		// kopo_27_item�� ���� ��ŭ �ݺ��ϸ鼭 �迭�� �б�
		for (int i = 0; i < kopo_27_item.length; i++) {
			// �Һ��ڰ� �� ��ǰ���� = ��ǰ���� * ����
			int kopo_27_sum = kopo_27_price[i] * kopo_27_amount[i]; 
			 // �Һ��ڰ� �� ��ǰ�� ������ ���� ��ǰ ���� �հ踦 ��ü ��ǰ ���� ������ ����
			kopo_27_total_sum = kopo_27_total_sum + kopo_27_sum;

			// ���� �����ֱ� ���� �迭�� ���̿� ���� ��� ������ ����
			if (kopo_27_item[i].length() >= 4) {
				System.out.printf(" %.5s    %4d    %8d    %12d\n", kopo_27_item[i], kopo_27_price[i], kopo_27_amount[i],
						kopo_27_sum);
			} else {
				System.out.printf(" %.5s\t    %5d\t    %d\t    %9d\n", kopo_27_item[i], kopo_27_price[i],
						kopo_27_amount[i], kopo_27_sum);
			}
		}
		System.out.printf("*************************************************\n");
		System.out.printf(" ���� �ݾ� :     %28d\n", kopo_27_total_sum);// �ش�ĭ�� ���缭 ���

		int kopo_27_total_net_price = (int) (kopo_27_total_sum / (1 + kopo_27_tax_rate));// ���� �ݾ� = �����ؾ��� �� �ݾ� / (1+����)
		System.out.printf(" ���� �ݾ� :     %28d\n", kopo_27_total_net_price);// �ش�ĭ�� ���缭 ���
		int kopo_27_tax = kopo_27_total_sum - kopo_27_total_net_price;// ���� = �����ؾ��� �� �ݾ� - ���� �ݾ�
		System.out.printf(" ��     �� :     %28d\n", kopo_27_tax);// �ش�ĭ�� ���缭 ���
	}
}
