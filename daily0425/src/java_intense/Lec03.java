package java_intense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec03 {
	public static void main(String[] args) throws IOException {// main �޼ҵ忡�� IOException�� throws�ϸ�, �ش� ���ܴ� JVM���� ���޵Ǿ�
		// ��µǰ� ���α׷��� ����
		File k27_f = new File("C:\\Users\\������\\���������������.txt");// �ش� ��ο� ���ο� ���� �����
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
		double k27_maxdist = 0;
		double k27_mindist = 0;
		String[] k27_maxDist = null;
		String[] k27_minDist = null;
		while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ ������ ���� ������
			String[] k27_field = k27_readtxt.split("\t");// ���� �������� ������ �ϳ��� �迭�� ���
			System.out.printf("**[%d��° �׸�]***********\n", k27_LineCnt);// ����ϱ�
			System.out.printf(" %s : %s\n", k27_field_name[10], k27_field[10]);// �迭�� 10��° �׸� ���
			System.out.printf(" %s : %s\n", k27_field_name[13], k27_field[13]);// �迭�� 13��° �׸� ���
			System.out.printf(" %s : %s\n", k27_field_name[14], k27_field[14]);// �迭�� 14��° �׸� ���
			double k27_dist = Math.sqrt(Math.pow(Double.parseDouble(k27_field[13]) - k27_lat, 2)
					+ Math.pow(Double.parseDouble(k27_field[14]) - k27_lng, 2));// �Ÿ� ����� �ϱ����� a - b�� ���� + c - d�� ������
																				// �������� ���ؼ� �Ÿ��� ���Ѵ�
			System.out.printf(" ���������� �Ÿ� : %f\n", k27_dist);// ����ȥ �Ÿ� ���� ���
			System.out.println("*************************");//�ٳ�����
			
				if (k27_LineCnt == 0) {//ù��° ������ ����
					k27_maxdist = k27_dist;//������ ���ϱ� ���� �ִ밪�� �־��ֱ�
					k27_mindist = k27_dist;//�ּڰ����� �־��ֱ�
				}else {//�ι�° ���� ���ʹ� else ���� Ÿ�� �ȴ�A
					if (k27_maxdist < k27_dist) {//���� ����ִ� ������ ���� ����� �Ÿ��� �� Ŭ���
						k27_maxdist = k27_dist;//�ִ밪 ������ �־��ش�.
						k27_maxDist = k27_field;//�������� ����� ���� �ִ밪 �迭�� �������ش�.
					}
					if (k27_mindist > k27_dist) {//���� ����ִ� ������ ���� ����� �Ÿ��� �� ���� ���
						k27_mindist = k27_dist;//�ּڰ� ������ �־��ش�.
						k27_minDist = k27_field;//�������� ����� ���� �ּڰ� �迭�� �������ش�.
					}
				}
			k27_LineCnt++;//Ƚ�� ����
		}
		
		// ���� ����� ��� ���� ���
		if (k27_minDist != null) {//������ �ƴ� ����϶�
		    System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
		    System.out.printf(" %s : %s\n", k27_field_name[1], k27_minDist[1]);//�ּҰ��� �ش��ϴ� ��ġ��Ҹ�
		    System.out.printf(" %s : %s\n", k27_field_name[10], k27_minDist[10]);//�ּҰ��� �ش��ϴ� �����������ּ�
		    System.out.printf(" %s : %s\n", k27_field_name[13], k27_minDist[13]);//�ּҰ��� �ش��ϴ� ����
		    System.out.printf(" %s : %s\n", k27_field_name[14], k27_minDist[14]);//�ּҰ��� �ش��ϴ� �浵
		    System.out.printf(" ���������� �Ÿ� : %f\n", k27_mindist);//�ּҰ��� �ش��ϴ� ���������� �Ÿ�
		} else {
		    System.out.printf("\n��� ������ �����ϴ�.\n");
		}

		// ���� �� ��� ���� ���
		if (k27_maxDist != null) {
		    System.out.printf("\n**[�ִ� �Ÿ�]***************\n");
		    System.out.printf(" %s : %s\n", k27_field_name[1], k27_maxDist[1]);//�ּҰ��� �ش��ϴ� ��ġ��Ҹ�
		    System.out.printf(" %s : %s\n", k27_field_name[10], k27_maxDist[10]);//�ּҰ��� �ش��ϴ� �����������ּ�
		    System.out.printf(" %s : %s\n", k27_field_name[13], k27_maxDist[13]);//�ּҰ��� �ش��ϴ� ����
		    System.out.printf(" %s : %s\n", k27_field_name[14], k27_maxDist[14]);//�ּҰ��� �ش��ϴ� �浵
		    System.out.printf(" ���������� �Ÿ� : %f\n", k27_maxdist);//�ּҰ��� �ش��ϴ� ���������� �Ÿ�
		} else {
		    System.out.printf("\n��� ������ �����ϴ�.\n");//���� ��� ������� ����
		}
		
		k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
	}
}
