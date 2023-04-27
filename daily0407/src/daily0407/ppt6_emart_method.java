package daily0407;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ppt6_emart_method {//�̸�Ʈ ������ �и�
	// ���ڿ� ������ �׸� �迭 30�� ���� �� �ʱ�ȭ
	static String[] k27_itemname = { "a", "aaa", "�ĸӽ��� ���� ����", "�޲ٴ��� �̵κ� ����", "ö�� �����10kg", "ũ���ؽ� ��Ʈ�� Ŭ�� ����ƴ���� 30m30��",
			"�ÿ��� �� ��������", "����ƮŰģ ���� �� Ʈ�� �ֹ�������� 11�� ����", "��� ���𵨸� ��Ű�� ��Ƽ��ī�� (����/�Žǿ��)", "���� �������� �߹�(1,050~1,400)",
			"���� ���̷��� ��ü���� 2.7L(��������)", "��귣�� ������ ��Ƽ�� 100��", "�Ŷ�� 5���� 1����", "����� ��鰡��", "���� ����丶�� 750g/��",
			"�ѿ� ä�� ���̿� 1���", "����ũ ���� ��ٷο�500g", "���κ��� ���۶�", "����� ��Ÿ��Ŀ ��� ���� ����", "���̽�ĳ�� T9",
			"������ ���� �ױ۸��� ��� �� �������� �ڷ� �÷���", "����Ƽ �δ� ������ ����Ʈ ����� ������", "����� ���� ��Ʈ�� ��Ʈ", "�κ���Ÿ �ǿ��� ��Ʈ��",
			"������ ȫ���� �ξ� 240g", "����ũ ����� �̾߱�", "���߶��Ÿ GREEN����������", "�渮�� �����̼� ���ݸ�", "�ü��̵�", "�ƶ� �Ƽ" };

	// ������ �����ۺ� ���� �׸� 30�� ���� �� �ʱ�ȭ
	static int[] k27_price = { 3000, 2990000, 12890000, 1950000, 29120, 33700, 4900, 900, 159030, 34110, 15040, 1500,
			4500, 980, 4100, 19900, 10980, 11880, 6784, 70400, 434280, 444808, 125020, 201348, 373744, 252672, 235564,
			93436, 9080400, 42112000 };

	// �����ۺ� ���� 30�� ���� �� �ʱ�ȭ
	static int[] k27_num = { 6, 3, 5, 6, 2, 1, 2, 8, 4, 3, 8, 7, 5, 1, 6, 8, 2, 1, 4, 5, 2, 1, 5, 3, 1, 1, 3, 4, 1, 2 };

	// �鼼�׸� Ÿ�� 30�� ���� �� �ʱ�ȭ
	static boolean[] k27_taxFree = { true, true, true, false, false, false, false, false, true, false, false, false,
			true, false, false, false, false, false, true, false, false, false, false, false, false, true, true, true,
			false, false, false, false };

	static DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// ���ڸ� ���� �޸� ���

	static int k27_val_taxFreeTotal = 0;// �鼼��ǰ
	static int k27_val_taxAmountTotal = 0;// ������ǰ

	public static void main(String[] args) {//���κ�
		int k27_itemCount = k27_itemname.length; // �׸��� �����
		k27_TitlePrint();// ������ ���� Ÿ��Ʋ
		k27_TimeStamp();// ��½ð� �μ�
		k27_HeaderPrint();// ��� (��ǰ��,�ܰ�,����,�ݾ�)�μ�

		for (int i = 0; i < k27_itemCount; i++) {// �׸񰹼���ŭ �׸� �μ�
			k27_itemPrint(i);
		}
		k27_TotalPrint();// �հ� , ���׵��� �μ�
	}

	private static void k27_TitlePrint() {// ������ ���� Ÿ��Ʋ ���
		System.out.printf("%s", "emart");
		System.out.printf("%29s", "�̸�Ʈ ������ (031)888-1234");// ������ ���� ���
		System.out.printf("\n%29s", "206-86-50913 ����");// ������ ���� ���
		System.out.printf("\n%28s", "���� ������ ���´�� 552");// ������ ���� ���
		System.out.println();// �ٳѱ�
		System.out.printf("\n������ �������� ��ȯ/ȯ�� �Ұ�");
		System.out.println("\n�����ǰ�� ����, 30�� �̳�(�ż� 7��)");
		System.out.println("���Ϻ� �귣����� ����(���� ����������)");
		System.out.println("��ȯ/ȯ�� ���������� ����(����ī�� ����)");
		System.out.println();// �ٳѱ�
		String k27_formatTime = k27_TimeStamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.printf("%s%s%17s", "[�� ��]", k27_formatTime, "POS:011-9861");// ������ ���� ���
		System.out.printf("\n----------------------------------------\n");// �ٳѱ�
	}

	private static LocalDateTime k27_TimeStamp() {// ����ð� �ҷ�����
		LocalDateTime k27_now = LocalDateTime.now();
		return k27_now;
	}

	private static void k27_HeaderPrint() {// ��� (��ǰ��,�ܰ�,����,�ݾ�)�μ�
		System.out.printf("%8s%12s%3s%8s\n", "�� ǰ ��", "��  ��", "����", "��  ��");// ĭ���� �����ؼ� ĭ�� �°� ���
	}

	private static void k27_itemPrint(int i) {
		String cc = k27_cutString2(k27_itemname[i], 14);// �迭�� i��° ���� �ڸ��� �޼ҵ�� �ѱ�� -> 14���ڷ� �߶����
		if (i % 5 == 0) {// 5���� ��µɶ����� ������ ��� �� �ٳѱ�
			System.out.printf("---------------------------------------- \n");
		}
		if (k27_taxFree[i] == true) {// �鼼�� true �϶�
			// �� ǰ ��,�� ��,����,�հ� -> ĭ�����缭 ����ϰ� *�� ���� ���
			System.out.printf("* %s%10s%3d%11s\n", cc, k27_df.format(k27_price[i]), k27_num[i],
					k27_df.format(k27_price[i] * k27_num[i]));
			k27_val_taxFreeTotal += k27_price[i] * k27_num[i];

		} else {// �鼼�� false �϶�
			// �� ǰ ��,�� ��,����,�հ� -> ĭ�����缭 ����ϰ� �տ��� ���� 2ĭ ���
			System.out.printf("  %s%10s%3d%11s\n", cc, k27_df.format(k27_price[i]), k27_num[i],
					k27_df.format(k27_price[i] * k27_num[i]));
			k27_val_taxAmountTotal += (k27_price[i] * k27_num[i]);
		}
	}

	private static void k27_TotalPrint() {// �հ� , ���׵��� �μ�
		// ���� 10�ۼ�Ʈ
		double k27_rate = 0.1;
		// �����հ踦 ���ϴ� �޼ҵ�� ��ü ���� ���� �հ�� ������ �ѱ��
		int kopo_27_netprice = kopo_27_netprice(k27_val_taxAmountTotal, k27_rate);
		// �ΰ��� = ��ü ���� ���� �հ� - �����հ�
		int kopo_27_tax = k27_val_taxAmountTotal - kopo_27_netprice;
		// �����ϴ� �ݾ�
		int kopo_27_totalprice = kopo_27_netprice + kopo_27_tax + k27_val_taxFreeTotal;

		// �Һ��� ����Ʈ�� �� �ݾ��� 0.001 �ۼ�Ʈ
		int k27_point = kopo_27_totalprice / 1000;
		// ���� ������ �ִ� ����Ʈ
		int k27_beforePoint = 5473;
		// ���������� ��������� ����Ʈ
		int k27_afterPoint = k27_point + k27_beforePoint;

		System.out.printf("\n%22s %12s", "�� ǰ�� ����", k27_itemname.length);// ǰ���� �� ����� �̸��� ������ ����
		System.out.printf("\n%23s %12s", "(*)�� ��  �� ǰ", k27_df.format(k27_val_taxFreeTotal));// ������ ����� �ݾ� ���
		System.out.printf("\n%23s %12s", "�� ��  �� ǰ", k27_df.format(kopo_27_netprice));// �����հ� �ݾ� ���
		System.out.printf("\n%24s %12s", "��   ��   ��", k27_df.format(kopo_27_tax));// ����� ���
		System.out.printf("\n%25s %12s", "��        ��", k27_df.format(kopo_27_totalprice));// �����ϴ� �ݾ� ���
		System.out.printf("\n%-23s", "�� �� �� �� �� ��");
		System.out.printf("%11s", k27_df.format(kopo_27_totalprice));// �����ϴ� �ݾ� ���
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-17s", "0012 KEB �ϳ�");// ���� ���� �� ���
		System.out.printf("%20s", "541707**0484/35860658");
		System.out.printf("\n%-16s", "ī�����(IC)");// ���� ���� �� ���
		System.out.printf("%s", "�Ͻú� / ");
		System.out.printf("%11s", k27_df.format(kopo_27_totalprice));// �����ϴ� �ݾ� ���
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%22s", "[�ż�������Ʈ ����]");
		System.out.printf("\n%-17s", "ȫ*�� ������ ����Ʈ ��Ȳ�Դϴ�.");// ���� ���� �� ���
		System.out.printf("\n%-11s %s%10s", "��ȸ�߻�����Ʈ", " 9350**9995", k27_df.format(k27_point));// �߻��ϴ� ����Ʈ ���� ���� ���
		System.out.printf("\n%-14s", "����(����)����Ʈ");// ���� ���� �� ���
		System.out.printf("%7s(", k27_df.format(k27_afterPoint));// ��������Ʈ�� �߻��� ����Ʈ ���� �� ���
		System.out.printf("%10s)", k27_df.format(k27_beforePoint));// ��������Ʈ ���
		System.out.printf("\n%s", "*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.");
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%21s", "���űݾױ��� ���������ð� �ڵ��ο�");
		System.out.printf("\n%-4s", "������ȣ : ");// ���� ���� �� ���
		System.out.printf("%28s", "34��****");// ������ ���� �� ���
		System.out.printf("\n%-4s", "�����ð� : ");// ���� ���� �� ���
		LocalDateTime k27_k = k27_TimeStamp().minusHours(2);// ����ð��� 2�ð� ����
		String k27_tk = k27_k.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// ��¥ ��� ���� ������
		System.out.printf("%29s", k27_tk);// ������ ���� �� �ð� ���
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-10s", "ĳ��:084599 ��00");// ������ ���� �� ���
		System.out.printf("%25s", "1150\n");// ���� ���� �� ���
		String k27_formatTime1 = k27_TimeStamp().format(DateTimeFormatter.ofPattern("yyyyMMdd"));// ��¥ ��� ���� ������
		System.out.printf("%15s/00119861/00164980/31", k27_formatTime1);// ���� ���� �� ���

	}

	// ��ǰ���ݰ� ������ ���ڷ� ������ ���������� ����ϴ� �޼ҵ�
	private static int kopo_27_netprice(int k27_val_total, double kopo_27_tax_rate) {
		// ���������� ��ü ���հ� ���ݿ��� 1.1�� �����ָ� ������ �� -> double�� ����ϰ� int�� ��ȯ�ؼ� �Ҽ����� ������.
		return (int) (k27_val_total / (1 + kopo_27_tax_rate));
	}

	public static String k27_cutString2(String k27_str, int k27_len) {// ������ ���ڿ��� �߶��ִ� �޼ҵ�
		// itemname�� i��° ���ڸ� str�� ��Ƽ� �������� ����Ʈ�� ��ȯ
		byte[] k27_by = k27_str.getBytes();
		if (k27_by.length <= 14) {// ���� ���ڹ���Ʈ�� 14�� �Ǳ� ���϶�����
			k27_str = new String(k27_by, 0, k27_by.length);
			for (int i = k27_by.length; i < 14; i++) {// -> 14�� �����ֱ����� �ڿ� ���ڶ�� ĭ����ŭ ������ ä������ ����
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
