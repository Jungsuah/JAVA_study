package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_3 {
// ���� ����....
	public static void main(String[] args) throws IOException {
// W�� Ư�������̹Ƿ� WW�ΰ��� ����Ѵ�.
		File k27_f = new File("C:\\test\\day_data\\2015MaxMin.csv"); // ������ ���� ��� ����
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f)); // ������ ���� �о����
		File k27_f1 = new File("C:\\test\\day_data\\final.csv"); // �ִ밪, �ּҰ��� ������ ���� ��� ����
		BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1)); // �ִ밪, �ּҰ��� ������ ���Ͽ� ����
		String k27_readtxt;
		int max = Integer.MIN_VALUE; // �ִ밪 ���� �ʱ�ȭ
		int min = Integer.MAX_VALUE; // �ּҰ� ���� �ʱ�ȭ

		int maxLine = 0; // �ִ밪�� �ִ� ���� ���� �ʱ�ȭ
		int minLine = 0; // �ּҰ��� �ִ� ���� ���� �ʱ�ȭ
		while ((k27_readtxt = k27_br.readLine()) != null) {

			String[] k27_field = k27_readtxt.split(","); // ��ǥ�� �и��� �ʵ带 �迭�� ����

			if (Integer.parseInt(k27_field[3]) < min) {
				minLine = Integer.parseInt(k27_field[3]); // �ּҰ� ���� ������Ʈ
			} else if (Integer.parseInt(k27_field[3]) > max) {
				maxLine = Integer.parseInt(k27_field[3]); // �ִ밪 ���� ������Ʈ
			}

			max = Math.max(max, Integer.parseInt(k27_field[3])); // �ִ밪 ������Ʈ
			min = Math.min(min, Integer.parseInt(k27_field[3])); // �ּҰ� ������Ʈ

		}
		k27_bw1.write(maxLine); // �ִ밪�� �ִ� ������ ���Ͽ� ����
		k27_bw1.newLine(); // �� �� ����
		k27_bw1.write(minLine); // �ּҰ��� �ִ� ������ ���Ͽ� ����
		k27_br.close(); // ������ ���� �ݱ�
		k27_bw1.close(); // �ִ밪, �ּҰ� ���� �ݱ�

		System.out.println("�ִ밪 : " + max + " �ּҰ� : " + min); // �ִ밪�� �ּҰ� ���
	}
}
