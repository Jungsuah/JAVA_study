package daily0405;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ppt5_4 {// ���� 11
	public static void main(String[] args) {
		int kopo_27_val = 10000; // ���� ���ǰ�
		// ���� 10 �ۼ�Ʈ
		double k27_rate = 0.1;
		int kopo_27_rate = 10;
		// �����հ� = ���� ���ǰ� %/ 1.1
		double k27_calTax = kopo_27_val / (k27_rate + 1.0);
		// �ΰ��� = �����հ� * 0.1
		double kopo_27_netprice = k27_calTax * kopo_27_rate / 100;
		int kopo_27_inetprice = (int) Math.ceil(kopo_27_netprice);
		// ���� �����հ� = �������ǰ� - �ΰ���
		int k27_kk = kopo_27_val - kopo_27_inetprice;

		DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// ���ڸ� ���� �޸� ���

		// ���� ��¥
		LocalDateTime k27_now = LocalDateTime.now();//����ð����
		String k27_formatTime = k27_now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));//��¥ ������ �� ���

		System.out.println("�ſ����");//���
		System.out.printf("%-16s %17s", "�ܸ��� : 2N68665898", "��ǥ��ȣ : 041218\n");//�ڸ��� ���缭 ���
		System.out.println("������ : �Ѿ���ġ�");
		System.out.println("��  �� : ��� ������ �д籸 Ȳ�����351���� 10 , 1��");
		System.out.println("��ǥ�� : ��â��");
		System.out.printf("%-16s %19s", "����� : 752-53-00558", "TEL : 7055695\n");//�ڸ��� ���缭 ���
		System.out.println("- - -  - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%-18s", "��  ��");//�ڸ��� ���缭 ���� ���� �� ���
		System.out.printf("%18s ��\n", k27_df.format(k27_kk));//�ڸ��� ���缭 ������ ���� �� ���
		System.out.printf("%-17s", "�ΰ���");//�ڸ��� ���缭 ���� ���� �� ���
		System.out.printf("%18s ��\n", k27_df.format(kopo_27_inetprice));
		System.out.printf("%-18s", "��  ��");//�ڸ��� ���缭 ���� ���� �� ���
		System.out.printf("%18s ��\n", k27_df.format(kopo_27_val));//�ڸ��� ���缭 ������ ���� �� ���
		System.out.println("- - -  - - - - - - - - - - - - - - - - - - ");
		System.out.println("�츮ī��");
		System.out.println("ī���ȣ : 5387-20**-****-4613(S)  �Ͻú�");
		System.out.println("�ŷ��Ͻ� : " + k27_formatTime);
		System.out.println("���ι�ȣ : 70404427");
		System.out.println("�ŷ���ȣ : 357734873739");
		System.out.printf("%-17s", "���� : ��ī���");//�ڸ��� ���缭 ���� ���� �� ���
		System.out.printf("%16s", "���� : 720068568\n");//�ڸ��� ���缭 ������ ���� �� ���
		System.out.println("�˸� : EDC����ǥ");
		System.out.println("���� : TEL)1544-4700");
		System.out.println("- - -  - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%23s", "* �����մϴ� *\n");//�ڸ��� ���缭 ������ ���� �� ���
		System.out.printf("%39s", "ǥ��v2.08_20200212");//�ڸ��� ���缭 ������ ���� �� ���

	}
}
