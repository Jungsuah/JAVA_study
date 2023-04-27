package daily0405;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ff {

	public static int netprice(int price2, double tax_rate) {
		return (int) (price2 / (1 + tax_rate));// k31_price�� k31_rate���� �޾Ƽ� ���������� return
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar k31_day = Calendar.getInstance();
		Calendar k31_day2 = Calendar.getInstance();
		String today = null;
		Date date = new Date();

		DecimalFormat k31_df = new DecimalFormat("###,###,###,###,###");
		k31_day2.setTime(date);
		k31_day2.add(Calendar.HOUR, -2);

		k31_day.setTime(date);

		SimpleDateFormat k31_today = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat k31_today1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		today = k31_today1.format(k31_day.getTime());
		SimpleDateFormat k31_today2 = new SimpleDateFormat("yyyyMMdd");

		String itemname[] = { "a", "��ī �ݶ� ���� 1.5LX2"};
//		, "����ũ ���� ��ٷο�500g", "[���]������ ��߸�(86gX6��)",
//				"�ѿ� ä�� ���̿� 1���(100g)(��)", "���̰���κ����300g", "[���]�ȼ����� 5�� 625g(125g5��)", "��� �ҺҰ��(800g)",
//				"����ũ ��¥���� �������ڳ�350g", "[Ǯ����]������ �ᳪ�� 340g", "��귣�� ŰģŸ�� 200��*6��", "[��귣��]���Խ��񿣳�550g",
//				"����ũ ����Ŭ���� �ñ״�ó �׸����Ʈ 450g", "�ۼַ�Ʈ ����� �� 2 800g", "CJ ���� ��� ���� 500g", "[ĥ����]û���� 900g/��",
//				"�̷α� ��Ǫ�ν�Ʈ 600g", "ũ���ؽ� 3�� ���� &����Ʈ 30m*30��", "[�����]�ֺ�9�� �񿣳��ҽ���1kg", "[�������]������ ����(1L2��)",
//				"[û��]������ƽ220g", "����ũ ���캺����6��(210g*6)", "[CJ]�޹�(210g*12��)", "�ʶ��Ǿ� ũ��ġ�� �̱���(200g)", "�������� �� �񸶴� 300g",
//				"[��귣��]���ö� �� 100g(5g*20)", "�� �������� 150mlX5��", "�Ͽ콺 �ް���(1kg/��)", "��귣�� ���� ���վ 10000g",
//				"�ʸ��ɻ� �������� �����ξ��� 1kg" };

		int price[] = { 19800000, 4580, 6784, 5040, 11880, 1480, 3700, 15980, 4784, 2600, 5480, 6980, 4960, 28000, 1980,
				8980, 4680, 25900, 9980, 4980, 4880, 8386, 13980, 9280, 4980, 5480, 8000, 6480, 4980, 9000 };

		int num[] = { 1, 1, 3, 4, 5, 2, 1, 2, 1, 2, 5, 6, 1, 3, 1, 2, 1, 3, 1, 2, 3, 1, 5, 2, 3, 4, 1, 1, 2, 3 };
		boolean[] taxfree = { true, false, false, false, false, false, false, false, false, false, true, false, true,
				false, false, false, false, true, false, false, false, false, false, false, false, false, false, false,
				false, true };

		int totalprice1 = 0;
		int totalprice2 = 0;

		System.out.printf("%28s\n", "    emart �̸�Ʈ ������ (031)888-1234");
		System.out.printf("%26s\n", "206-86-50913 ����");
		System.out.printf("%25s\n\n", "���� ������ ������� 552");
		System.out.printf("������ �������� ��ȯ/ȯ�� �Ұ�\n");
		System.out.printf("�����ǰ�� ����. 30�� �̳�(�ż� 7��)\n");
		System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n");
		System.out.printf("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n\n");
		System.out.printf("[����]%-22.22s", k31_today.format(k31_day.getTime()));
		System.out.printf("%13.13s\n", "POS:0011-9861");
		System.out.printf("----------------------------------------- \n");
		System.out.printf("   �� ǰ ��        ��  ��   ����   ��  �� \n");

		for (int i = 0; i < itemname.length; i++) {

			String cc = cutString2(itemname[i], 14); // bb�� �߶� cc�� ����
			byte[] bb = cc.getBytes();

			if (i % 5 == 0) {
				System.out.printf("----------------------------------------- \n");

			}
			if (taxfree[i] == true) {
				System.out.printf("* %s%11s%3d%11s\n", cc, k31_df.format(price[i]), num[i],
						k31_df.format(price[i] * num[i]));
				totalprice1 = totalprice1 + price[i] * num[i];

			} else {

				System.out.printf("  %s%11s%3d%11s\n", cc, k31_df.format(price[i]), num[i],
						k31_df.format(price[i] * num[i]));
				totalprice2 = totalprice2 + price[i] * num[i];
			}

		}

		double tax_rate = 0.1;// ���� ����
		int netprice = netprice(totalprice2, tax_rate);// ���������� ��� �� ���� ����
		int tax = totalprice2 - netprice;// �ΰ��� ���
		int totalprice = totalprice1 + netprice + tax;
		int havepoint = 5637;
		int point = totalprice / 1000;

		System.out.printf("\n");
		System.out.printf("%17s", "�� ǰ�� ����");
		System.out.printf("%19s\n", itemname.length);
		System.out.printf("%15s", "(*)�鼼 ��ǰ");
		System.out.printf("%22s\n", k31_df.format(totalprice1));
		System.out.printf("%15s", "���� ��ǰ");
		System.out.printf("%22s\n", k31_df.format(netprice));
		System.out.printf("%15s", "�� �� ��");
		System.out.printf("%23s\n", k31_df.format(tax));
		System.out.printf("%16s", "��    ��");
		System.out.printf("%23s\n", k31_df.format(totalprice));
		System.out.printf("�������ݾ�");
		System.out.printf("%29s\n", k31_df.format(totalprice));
		System.out.printf("----------------------------------------- \n");
		System.out.printf("%-18s", "0012 KEB �ϳ�");
		System.out.printf("%18s\n", "541707**0484/35860658");
		System.out.printf("%-18s", "ī�����(IC)");
		System.out.printf("%-5s", "�Ͻú� / ");
		System.out.printf("%10s\n", k31_df.format(totalprice));
		System.out.printf("----------------------------------------- \n");
		System.out.printf("            [�ż�������Ʈ ����]        \n");
		System.out.printf("��*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n");
		System.out.printf("��ȸ�߻�����Ʈ      9350**9995       %4d\n", point);
		System.out.printf("����(����)����Ʈ         %s(    %5d)\n", k31_df.format(havepoint), havepoint + point);
		System.out.printf("�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n");
		System.out.printf("----------------------------------------- \n");
		System.out.printf("   ���űݾױ��� ���������ð� �ڵ��ο�     \n");
		System.out.printf("%-18s", "������ȣ : ");
		System.out.printf("%18s\n", "32��****");
		System.out.printf("%-18s", "�����ð� : ");
		System.out.printf("%18s\n", k31_today.format(k31_day2.getTime()));
		System.out.printf("----------------------------------------- \n");
		System.out.printf("%-20s", "ĳ��:084599 ��00");
		System.out.printf("%18s\n", "1150");
		System.out.printf("      %s/00119861/00164980/31\n", k31_today2.format(k31_day.getTime()));

	}
	
	public static String cutString2(String str, int len) {

	      byte[] by = str.getBytes();
	      if (by.length <= 14) {
	         str = new String(by, 0, by.length);
	         for (int i = by.length; i < 14; i++) {
	            str = str + " ";
	         }
	         return str;
	      } else {
	         int count = 0;
	         try {
	            for (int i = 0; i < len; i++) {
	               if ((by[i] & 0x80) == 0x80)
	                  count++; // �ٽ� �ڵ�
	            }
	            if ((by[len - 1] & 0x80) == 0x80 && (count % 2) == 1) {
	               len--; // �ٽ��ڵ�
	               String str1 = new String(by, 0, len) + " ";
	               return str1;
	            }
	         } catch (java.lang.ArrayIndexOutOfBoundsException e) {
	            System.out.println(e);
	            return "";
	         }
	         String str2 = new String(by, 0, len);
	         return str2;
	      }
	}

}
