package ClassTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportSheet {
	public static void main(String[] args) {
		int iPerson_k27 = 30;// �̰��� �ִ� ��ŭ ����� ����
		
		System.out.println("                              ��������ǥ");
		LocalDateTime time_k27 = LocalDateTime.now();//����ð��ҷ�����
		String k27_time = time_k27.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// ��¥ ��� ���� ������
		System.out.println("                                             ������� : " + k27_time);//����ð� ���
		System.out.println("================================================================================");
		System.out.println("��ȣ        �̸�          ����        ����        ����        ����         ���");
		System.out.println("================================================================================");
		
		InputData inData_k27 = new InputData(iPerson_k27); //�������� ���ڸ� �ظ�ŭ �迭�� �����
		//�Էµ����� �����
		for (int i_k27 = 0; i_k27 < iPerson_k27; i_k27++) {//30��ŭ setData�� Ȱ���Ͽ� �����͸� �Է��Ѵ�
			String name = String.format("ȫ��%02d",i_k27);//ȫ���ϰ� 01�� ��������� ������
			int kor = (int)(Math.random()*100);//�������� 0-99���� ���� �Է�
			int eng = (int)(Math.random()*100);//�������� 0-99���� ���� �Է�
			int mat = (int)(Math.random()*100);//�������� 0-99���� ���� �Է�
			inData_k27.SetData(i_k27 , name, kor, eng,mat);//������ ���� ���� setData�� ���� �ֱ�
		}
		
		for (int i_k27 = 1; i_k27 < iPerson_k27; i_k27++) {//setData�� ���� ���� ���� for���� ���鼭 ������
			System.out.printf("��ȣ:%2d    �̸�:%-7s����:%-7d����:%-7d����:%-7d����:%-7d���:%-8d\n",
					i_k27,inData_k27.name_k27[i_k27],inData_k27.kor_k27[i_k27],inData_k27.eng_k27[i_k27],inData_k27.mat_k27[i_k27],inData_k27.sum_k27[i_k27],inData_k27.avg_k27[i_k27]);//������� ������
		}
	}
}


