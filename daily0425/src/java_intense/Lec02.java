package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec02 {
	public static void main(String[] args) throws IOException {// main �޼ҵ忡�� IOException�� throws�ϸ�, �ش� ���ܴ� JVM���� ���޵Ǿ�
		// ��µǰ� ���α׷��� ����
		File k27_f = new File("C:\\Users\\������\\���������������.txt");// �ش� ��ο� ���ο� ���� �����
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader�� FileReader�� ���� ���� ��ü ����

		String k27_readtxt;// ����� ���ڿ��� ���� ���� ����

		if ((k27_readtxt = k27_br.readLine()) == null) {// �о�� ������ ������ ���� ������
			System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
			return;
		}
		String[] k27_field_name = k27_readtxt.split("\t");// ���� �������� ������

		double k27_lat = 37.3860521;// ���� ǥ�� �Ǽ��� ���� ����
		double k27_lng = 127.1214038;// �浵 ǥ�� �Ǽ��� ���� ����
		int k27_LineCnt = 0;// ���� Ƚ���� �����ִ� ������ ���� ����
		while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ ������ ���� ������
			String[] k27_field = k27_readtxt.split("\t");// ���� �������� ������ �ϳ��� �迭�� ���
			System.out.printf("**[%d��° �׸�]***********\n", k27_LineCnt);// ����ϱ�
			System.out.printf(" %s : %s\n", k27_field_name[10], k27_field[10]);// �迭�� 10��° �׸� ���
			System.out.printf(" %s : %s\n", k27_field_name[13], k27_field[13]);// �迭�� 13��° �׸� ���
			System.out.printf(" %s : %s\n", k27_field_name[14], k27_field[14]);// �迭�� 14��° �׸� ���
			double dist = Math.sqrt(Math.pow(Double.parseDouble(k27_field[13]) - k27_lat, 2)
					+ Math.pow(Double.parseDouble(k27_field[14]) - k27_lng, 2));// �Ÿ� ����� �ϱ����� a - b�� ���� + c - d�� ������
																				// �������� ���ؼ� �Ÿ��� ���Ѵ�
			System.out.printf(" ���������� �Ÿ� : %f\n", dist);// ����ȥ �Ÿ� ���� ���
			System.out.println("*************************");//�ٳ�����
			k27_LineCnt++;// �о�� ������ ������ ���� ���� Ƚ�� �÷��ֱ�
		}
		k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
	}
}
