package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec04 {
	public static void main(String[] args) throws IOException {// main �޼ҵ忡�� IOException�� throws�ϸ�, �ش� ���ܴ� JVM���� ���޵Ǿ�
		// ��µǰ� ���α׷��� ����
		File k27_f = new File("C:\\Users\\������\\�ѱ������������_������������������_20191224.txt");// �ش� ��ο� ���ο� ���� �����
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));// BufferedReader�� FileReader�� ���� ���� ��ü ����

		String k27_readtxt;// ����� ���ڿ��� ���� ���� ����

		if ((k27_readtxt = k27_br.readLine()) == null) {// �о�� ������ ������ ���� ������
			System.out.printf("�� ���� �Դϴ�\n");// ����ϱ�
			return;
		}
		String[] k27_field_name = k27_readtxt.split("\t");

		double k27_lat = 37.3860521;
		double k27_lng = 127.1214038;
		int k27_LineCnt = 0;
		double maxdist = 0;
		double mindist = 0;
		String[] maxDist = null;
		String[] minDist = null;
		while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ ������ ���� ������
			String[] k27_field = k27_readtxt.split("\t");
			double dist = Math.sqrt(Math.pow(Double.parseDouble(k27_field[2]) - k27_lat, 2)
					+ Math.pow(Double.parseDouble(k27_field[3]) - k27_lng, 2));

			if (k27_LineCnt == 0) {
				maxdist = dist;
				mindist = dist;
			} else {
				if (maxdist < dist) {
					maxdist = dist;
					maxDist = k27_field;
				}
				if (mindist > dist) {
					mindist = dist;
					minDist = k27_field;
				}
			}
			k27_LineCnt++;
		}

		// ���� ����� ��� ���� ���
		if (minDist != null) {
			System.out.printf("**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" %s : %s\n", k27_field_name[1], minDist[1]);
			System.out.printf(" %s : %s\n", k27_field_name[10], minDist[10]);
			System.out.printf(" %s : %s\n", k27_field_name[13], minDist[13]);
			System.out.printf(" %s : %s\n", k27_field_name[14], minDist[14]);
			System.out.printf(" ���������� �Ÿ� : %f\n", mindist);
		} else {
			System.out.printf("\n��� ������ �����ϴ�.\n");
		}

		// ���� �� ��� ���� ���
		if (maxDist != null) {
			System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
			System.out.printf(" %s : %s\n", k27_field_name[1], maxDist[1]);
			System.out.printf(" %s : %s\n", k27_field_name[10], maxDist[10]);
			System.out.printf(" %s : %s\n", k27_field_name[13], maxDist[13]);
			System.out.printf(" %s : %s\n", k27_field_name[14], maxDist[14]);
			System.out.printf(" ���������� �Ÿ� : %f\n", maxdist);
		} else {
			System.out.printf("\n��� ������ �����ϴ�.\n");
		}

		k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
	}
}
