package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec01 {
	public static void main(String[] args) throws IOException {// main �޼ҵ忡�� IOException�� throws�ϸ�, �ش� ���ܴ� JVM���� ���޵Ǿ�
																// ��µǰ� ���α׷��� ����
		File k27_f = new File("C:\\Users\\������\\���������������.csv");// �ش� ��ο� ���� ã�ƿ���
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader�� FileReader�� ���� ���� ��ü ����

		String k27_readtxt;// ����� ���ڿ��� ���� ���� ����

		if ((k27_readtxt = k27_br.readLine()) == null) {// �о�� ������ ������ ���� ������
			System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
			return;//ȣ���Ѱ����� ���ư���
		}
		String[] k27_field_name = k27_readtxt.split(",");//csv ������ ,�� �������� �����͸� �ڸ����ֱ⶧���� �߶� �迭�� �ֱ�
		int k27_LineCnt = 0;// �ٰ����� �����ִ� ������ ���� ����
		while ((k27_readtxt = k27_br.readLine()) != null) {//�о�� ������ ������ ������
			String[] k27_field = k27_readtxt.split(",");//,�� �������� �ڸ������� �迭�� ��´�
			System.out.printf("**[%d��° �׸�]************\n", k27_LineCnt);//���° ������� ���
			for (int i = 0; i < k27_field_name.length; i++) {//�߶�� ���ڸ� ���� �迭�� for������ �ݺ��ϸ鼭
				System.out.printf(" %s : %s\n" , k27_field_name[i],k27_field[i]);//���� ����ϱ�
			}
			System.out.println("*********************");
			if (k27_LineCnt == 100) {
				break;
			}
			k27_LineCnt++;
		}
		k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
	}

}
