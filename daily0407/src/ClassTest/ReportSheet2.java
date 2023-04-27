package ClassTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportSheet2 {
	public static void main(String[] args) {

		int iPerson_k27 = 200;// �̰��� �ִ� ��ŭ ����� ����
		int personNumber_k27 = 30; // ���������� ��µǴ� �ο���
		InputData inData_k27 = new InputData(iPerson_k27); // �������� ���ڸ� �ظ�ŭ �迭�� �����

		// �Էµ����� �����
		for (int i_k27 = 0; i_k27 < iPerson_k27; i_k27++) {//iPerson_k27��ŭ setData�� Ȱ���Ͽ� �����͸� �Է��Ѵ�
			String name_k27 = String.format("ȫ��%02d", i_k27 + 1);//ȫ���ϰ� 01�� ��������� ������
			int kor_k27 = (int) (Math.random() * 100);//�������� 0-99���� ���� �Է�
			int eng_k27 = (int) (Math.random() * 100);//�������� 0-99���� ���� �Է�
			int mat_k27 = (int) (Math.random() * 100);//�������� 0-99���� ���� �Է�
			inData_k27.SetData(i_k27, name_k27, kor_k27, eng_k27, mat_k27);//������ ���� ���� setData�� ���� �ֱ�
		}

		int count_k27 = 0;//������ ���� ����
		int page_k27 = 1;//������ ���� ����
		int i_k27 = 0;//������ ��������
		int pageKor_k27 = 0;//������ ����� ����
		int pageEng_k27 = 0;//������ ����� ����
		int pageMat_k27 = 0;//������ ���к��� ����
		int pageSum_k27 = 0;//������ �հ躯�� ����
		int pageAvg_k27 = 0;//������ ��պ��� ����

		while (count_k27 < 200) {
			int korSum_k27 = 0;//�����
			int EngSum_k27 = 0;//�����
			int matSum_k27 = 0;//���к���
			int totalSum_k27 = 0;//�հ躯��
			int avgSum_k27 = 0;//��պ���
			System.out.println("                              ��������ǥ");
			LocalDateTime time_k27 = LocalDateTime.now();//����ð��ҷ�����
			String k27_time = time_k27.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// ��¥ ��� ���� ������
			System.out.println("PAGE: " + page_k27 + "                                             ������� : " + k27_time);//���
			System.out.println("================================================================================");
			System.out.println("��ȣ        �̸�          ����        ����        ����        ����         ���");
			System.out.println("================================================================================");

			for (i_k27 = count_k27; i_k27 < iPerson_k27; i_k27++) {//iPerson_k27��ŭ ������ ��������
				System.out.printf("��ȣ:%03d    �̸�:%-7s����:%-7d����:%-7d����:%-7d����:%-8d���:%-7d\n", i_k27 + 1, inData_k27.name_k27[i_k27],
						inData_k27.kor_k27[i_k27], inData_k27.eng_k27[i_k27], inData_k27.mat_k27[i_k27], inData_k27.sum_k27[i_k27], inData_k27.avg_k27[i_k27]);//������ ������ ���
				count_k27++;//����Ҷ����� ī��� �ø���

				korSum_k27 += inData_k27.kor_k27[i_k27];//�����Ͱ�������
				EngSum_k27 += inData_k27.eng_k27[i_k27];//�����Ͱ�������
				matSum_k27 += inData_k27.mat_k27[i_k27];//�����Ͱ�������
				totalSum_k27 += inData_k27.sum_k27[i_k27];//�����Ͱ�������
				avgSum_k27 += inData_k27.avg_k27[i_k27];//�����Ͱ�������

				if (count_k27 % personNumber_k27 == 0) {//���� ī��Ʈ�� ���������� ������ ������� ������ 0�̵Ǵ� ������ ����
					page_k27++;//���������� ����
					pageKor_k27 += korSum_k27;//������ ���� ���� ������������ �ֱ�
					pageEng_k27 += EngSum_k27;//������ ���� ���� ������������ �ֱ�
					pageMat_k27 += matSum_k27;//������ ���� ���� ������������ �ֱ�
					pageSum_k27 += totalSum_k27;//������ ���� ���� ������������ �ֱ�
					pageAvg_k27 += avgSum_k27;//������ ���� ���� ������������ �ֱ�
					break;//���������� �ؿ� ����� �ϱ�
				}
			}

			System.out.println("================================================================================");
			System.out.println("����������");//���
			System.out.printf("�հ� %23d%11d%11d%11d%11d\n", korSum_k27, EngSum_k27, matSum_k27, totalSum_k27, avgSum_k27);//���
			System.out.printf("��� %23d%11d%11d%11d%11d\n", korSum_k27 / personNumber_k27, EngSum_k27 / personNumber_k27,//���
					matSum_k27 / personNumber_k27, totalSum_k27 / personNumber_k27, avgSum_k27 / personNumber_k27);//���
			System.out.println("================================================================================");
			System.out.println("����������");//���
			System.out.printf("�հ� %23d%11d%11d%11d%11d\n", pageKor_k27, pageEng_k27, pageMat_k27, pageSum_k27, pageAvg_k27);//���
			System.out.printf("��� %23d%11d%11d%11d%11d\n", pageKor_k27 / count_k27, pageEng_k27 / count_k27, pageMat_k27 / count_k27,
					pageSum_k27 / count_k27, pageAvg_k27 / count_k27);//���
			System.out.println();//�ٳѱ�
			System.out.println();//�ٳѱ�
		}
	}
}
