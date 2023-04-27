package daily0405;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ppt5_7_���̼�2 {// ����ü 10
	public static void main(String[] args) {

		DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// ���ڸ� ���� �޸� ���

		LocalDateTime k27_now = LocalDateTime.now(); // ����ð� �ҷ�����
		String k27_formatTime = k27_now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));// ��¥ ��� ���� ������
		LocalDateTime k27_k = k27_now.plusDays(14);// ���糯¥�� 14�� ���ϱ�
		String k27_tk = k27_k.format(DateTimeFormatter.ofPattern("MM��dd��"));// ��¥ ��� ���� ������
		// �̸��迭 ���� �� �ʱ�ȭ
		String[] k27_itemname = { "���� ��ټ� �׸���20L", "�̸��� 10kg����", "�ĸӽ��� ���� ����" };
		// ���ݹ迭 ���� �� �ʱ�ȭ
		int[] k27_price = { 10, 10000, 100 };
		// �ڵ�迭 ���� �� �ʱ�ȭ
		String[] k27_itemcode = { "1031725", "11088152", "1021800" };
		// �����迭 ���� �� �ʱ�ȭ
		int[] k27_num = { 99, 10, 1 };
		// ���� �հ� ���� �� �ʱ�ȭ
		int k27_val_total = 0;

		System.out.printf("%23s", "\"���ΰ���, ���̼�\"\n");// ������ ���� ���
		System.out.printf("%-34s", "(��)�Ƽ����̼�_�д缭����");// ���� ���� ���
		System.out.printf("\n%-34s", "��ȭ:031-702-6016");// ���� ���� ���
		System.out.printf("\n%-33s", "����:���� ������ ���μ�ȯ�� 2748 (���) \n��ǥ��:������ , ��ȣ�� 213-81-52063");// ���� ���� ���
		System.out.printf("\n��ǥ��:������ , ��ȣ�� 213-81-52063");
		System.out.println("\n����:��⵵ ������ �д籸 �д��53���� 11 (������)");
		System.out.println("========================================");
		System.out.printf("%22s", "�Һ����߽ɰ濵(CCM) �������");// ������ ���� ���
		System.out.printf("\n%24s", "ISO 9001 ǰ���濵�ý��� �������");// ������ ���� ���
		System.out.printf("\n========================================\n");
		System.out.printf("%26s", "��ȯ/ȯ�� 14��(" + k27_tk + ")�̳�.");// ������ ���� ��� + ���� �ð��� 14�� ���� �ð� ���
		System.out.printf("\n%25s", "(����)������, ����ī�� ���� �� ���Ը��忡�� ����");// ������ ���� ���
		System.out.printf("\n%24s", "����/���� �� �Ѽս� ��ȯ/ȯ�� �Ұ�");// ������ ���� ���
		System.out.printf("\n%24s", "üũī�� ��� �� �ִ� 7�� �ҿ�");// ������ ���� ���
		System.out.printf("\n========================================");
		System.out.printf("\n%-15s", "[POS 1058231]");// ���� ���� ���
		System.out.printf("%25s", k27_formatTime);// ������ ���� ��� �� ����ð� ���
		System.out.println("\n========================================");// �ٳѱ�
		for (int i = 0; i < k27_itemname.length; i++) {// �̸��迭�� ���̸�ŭ for�� ����
			String cc = k27_cutString2(k27_itemname[i], 21); // �迭�� i��° ���� �ڸ��� �޼ҵ�� �ѱ�� -> 13���ڷ� �߶����

			if (i % 5 == 0 && i != 0) {// 5���� ��µɶ����� ������ ��� �� �ٳѱ�
				System.out.printf("---------------------------------------- \n");
			}
			// i��° ���� , ���� , ����*���� ���
			System.out.printf("%s%8s%3d%8s\n", cc, k27_df.format(k27_price[i]), k27_num[i],
					k27_df.format(k27_price[i] * k27_num[i]));
			k27_val_total += k27_price[i] * k27_num[i];
			// i��° �ڵ��ȣ ���
			System.out.printf("[%s]\n", k27_itemcode[i]);
		}
		System.out.println(k27_val_total);

		// ���� 10 �ۼ�Ʈ
		double k27_rate = 0.1;
		int kopo_27_rate = 10;
		// �����հ�
		double k27_calTax = k27_val_total / (k27_rate + 1.0);
		// �ΰ���
		double kopo_27_netprice = k27_calTax * kopo_27_rate / 100;
		int kopo_27_inetprice = (int) Math.ceil(kopo_27_netprice);
		// ���� �����հ�
		int kk = k27_val_total - kopo_27_inetprice;

		System.out.printf("%17s %18s", "�����հ�", k27_df.format(kk));// ���� ���� �� �����հ� ���
		System.out.printf("\n%18s %18s", "�ΰ���", k27_df.format(kopo_27_inetprice));// ���� ���� �� �ΰ��� ���
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-17s %18s", "�Ǹ��հ�", k27_df.format(k27_val_total));// ���� ���� �� �Ǹ��հ� ���
		System.out.printf("\n========================================");
		System.out.printf("\n%-17s %18s", "�ſ�ī��", k27_df.format(k27_val_total));// ���� ���� �� �ſ�ī�� ���
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-16s", "�츮ī��");// ���� ���� �� ���
		System.out.printf("%20s", "538720**********");// ������ ���� �� ���
		System.out.printf("\n%-17s", "���ι�ȣ 70404427(0)");// ���� ���� �� ���
		System.out.printf("%4s", "���αݾ�");
		System.out.printf("%11s", k27_df.format(k27_val_total));// ������ ���� �� �Ǹ��հ� ���
		System.out.printf("\n========================================");
		System.out.printf("\n%24s %s", k27_formatTime, "�д缭����");// ����ð� ���
		System.out.printf("\n%-17s", "��ǰ �� ��Ÿ ���� : 1522- 4400\n");// ���� ���� �� ���
		System.out.printf("%s", "����� �� �����̼� ���� ���� : 1599- 2211\n");// ���� ���� �� ���
		System.out.printf("%29s", "21128206101588231\n");// ������ ���� �� ���
		System.out.printf("----------------------------------------\n");
		System.out.printf("%-30s", "�� ���̼� ����� �� �Ǵ� Ȩ�������� �����ϼż� ȸ������ �� �پ��� ������ ����������! ��\n");// ���� ���� �� ���

	}

	public static String k27_cutString2(String k27_str, int k27_len) {// ������ ���ڿ��� �߶��ִ� �޼ҵ�
		// itemname�� i��° ���ڸ� str�� ��Ƽ� �������� ����Ʈ�� ��ȯ
		byte[] k27_by = k27_str.getBytes();
		if (k27_by.length <= 21) {// ���� ���ڹ���Ʈ�� 14�� �Ǳ� ���϶�����
			k27_str = new String(k27_by, 0, k27_by.length);
			for (int i = k27_by.length; i < 21; i++) {// -> 14�� �����ֱ����� �ڿ� ���ڶ�� ĭ����ŭ ������ ä������ ����
				k27_str = k27_str + " ";
			}
			return k27_str;
		} else {
			int count = 0;
			try {
				for (int i = 0; i < k27_len; i++) {// 14�� �Ǳ������� ������ ��ĭ�� 2����Ʈ��
					if ((k27_by[i] & 0x80) == 0x80)// by[i]�� �ѱ��̸�
						count++; // count+1
				}
				if ((k27_by[k27_len - 1] & 0x80) == 0x80 && (count % 2) == 1) {// 14�� �Ǳ������� ������ ��ĭ�� 1����Ʈ��
					k27_len--; // ��ĭ ���̰�
					String str1 = new String(k27_by, 0, k27_len) + " ";// �ڿ� ������ �߰��ؼ�
					return str1;// �����Ѵ�
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {// �迭�� �ε����� ������ ������
				System.out.println(e);
				return "";// ������ ����
			}
			String str2 = new String(k27_by, 0, k27_len);// 14�̻��̸� �׸�ŭ ���ڸ� �ڸ���
			return str2;// �߷��� ���ڸ� �����Ѵ�
		}
	}

}