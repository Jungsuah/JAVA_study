package daily0403;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ppt3_10 {
	public static void main(String[] args) {
		int kopo_27_MyWon = 1000000;// ���� ȯ���ϰ� ���� ��ȭ
		double kopo_27_MoneyEX = 1238.21; // �޷� ȯ��
		double kopo_27_commission = 0.003; // ȯ���� �߻��ϴ� ������
		double kopo_27_ComPerOne = kopo_27_MoneyEX * kopo_27_commission; // 1�޷��� ȯ�� ������
		int kopo_27_usd = (int) (kopo_27_MyWon / (kopo_27_MoneyEX + kopo_27_ComPerOne)); // ȯ�� �޷� = ȯ���Ϸ��� ��ȭ / (�޷�ȯ�� + 1�޷��� ȯ��������)
		double kopo_27_totalcom = kopo_27_usd * kopo_27_ComPerOne;// �� ������ = �޷� * 1�޷��� ȯ�� ������
		int kopo_27_i_totalcom = 0;// �ø� ó���� �� ������

		// ������ �ø�ó��
		// ���� �� �������� �Ҽ����� ���� ������ �Ҽ����� ������ ���� ���� �ʴٸ� +1�� ���� ������ ����
		if (kopo_27_totalcom != (double) ((int) kopo_27_totalcom)) {
			kopo_27_i_totalcom = (int) kopo_27_totalcom + 1;
		} else {
			// ���� �� �������� �Ҽ����� ���� ������ �Ҽ����� ������ ���� ���ٸ� �״�� ������ ����
			kopo_27_i_totalcom = (int) kopo_27_totalcom;
		}

		System.out.printf("******************************************************************************\n");
		System.out.printf("*                          (��Ȯ��)������ ����ȯ��                           *\n");

		System.out.printf("�� ������ : %d�� => ��ȭ : %d�޷�, �޷��� ������: %f��\n", kopo_27_i_totalcom, kopo_27_usd,
				kopo_27_ComPerOne);//���� ���缭 ���

		// ������ �ܵ� = ȯ���ϰ���� ��ȭ - (�޷� * �޷�ȯ��) - 1�޷��� ȯ�� ������
		int kopo_27_remain = (int) (kopo_27_MyWon - kopo_27_usd * kopo_27_MoneyEX - kopo_27_i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ� : %d�� => ��ȭ : %d�޷�, ������û��:%d�� �ܵ�: %d��\n", kopo_27_MyWon, kopo_27_usd,
				kopo_27_i_totalcom, kopo_27_remain);//���� ���缭 ���
		System.out.printf("******************************************************************************\n");

		DecimalFormat df = new DecimalFormat("###,###,###,###,###");//õ�ڸ� ���� ',' ��� -> String���� ��ȯ�Ǿ� ��� �ݿ�

		System.out.println();//�ٳѱ��
		System.out.printf("******************************************************************************\n");
//		System.out.println("*                            �޸����, ��¥ ����                            *\n");
		System.out.printf("*                                                                           *\n");

		System.out.printf("�� ������ : %s�� => ��ȭ : %s�޷�, �޷��� ������: %f��\n", df.format(kopo_27_i_totalcom), df.format(kopo_27_usd),
				kopo_27_ComPerOne);//���ڿ����� ���缭 ���
		
		// ������ �ܵ� = ȯ���ϰ���� ��ȭ - (�޷� * �޷�ȯ��) - 1�޷��� ȯ�� ������
		kopo_27_remain = (int) (kopo_27_MyWon - kopo_27_usd * kopo_27_MoneyEX - kopo_27_i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ� : %s�� => ��ȭ : %s�޷�, ������û��:%s�� �ܵ�: %s��\n", df.format(kopo_27_MyWon),
				df.format(kopo_27_usd), df.format(kopo_27_i_totalcom), df.format(kopo_27_remain));//���ڿ����� ���缭 ���

		
		//�޷°�ü�� new��� ������ ������� �ʰ� get���� �ν��Ͻ��� �����ؼ� �����´�
		Calendar k27_clat = Calendar.getInstance(); //�޷� �ν��Ͻ� ����
		
		//�⵵/��/�� �ð�/��/�� �������� ������
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		//�޷¿��� �ð��� �������� ������ �� �� ���ڿ� ���·� ���
		System.out.printf("��������ð� : %s\n", sdf.format(k27_clat.getTime()));
		
		System.out.printf("******************************************************************************\n");
	}
}
