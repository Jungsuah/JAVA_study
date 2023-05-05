package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08 {
// ���� ����....
	public static void main(String[] args) throws IOException {
		// �Է� ���� ��� ����
		File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// �Է� ������ �б� ���� BufferedReader ��ü ����
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		// ��� ���� ��� ����
		File k27_f1 = new File("C:\\test\\day_data\\A005930.csv");
		// ��� ������ ���� ���� BufferedWriter ��ü ����
		BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
		// �� �پ� ���� ���� ����
		String k27_readtxt;
		// �Է� ���Ͽ��� ���� ���ڵ� ���� ������ ���� �ʱ�ȭ
		int k27_cnt = 0;
		// ��� ���Ͽ� �� ���ڵ� ���� ������ ���� �ʱ�ȭ
		int k27_wcnt = 0;

		// �Է� ���Ͽ��� �� �پ� �о���̱⤷
		while ((k27_readtxt = k27_br.readLine()) != null) {
			// StringBuffer ��ü ����
			StringBuffer k27_s = new StringBuffer();
			// �о���� ���ڵ带 �����ڸ� �̿��Ͽ� �ʵ�� �и�
			String[] k27_field = k27_readtxt.split("%_%");

			// �ʵ� ���� 2���� ũ�� 3��° �ʵ忡�� A�� ���ԵǾ� �ִ� ���ڵ常 �����Ͽ� ó��
			if (k27_field.length > 2 && k27_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				// ù ��° �ʵ� ���� StringBuffer�� ����
				k27_s.append(k27_field[0].replace("^", "").trim());

				// �� ��° �ʵ���ʹ� ","�� �Բ� StringBuffer�� �߰�
				for (int j = 1; j < k27_field.length; j++) {
					k27_s.append("," + k27_field[j].replace("^", "").trim());
				}
				// BufferedWriter�� �̿��Ͽ� StringBuffer�� ����� ���ڵ带 ��� ���Ͽ� ����
				k27_bw1.write(k27_s.toString());
				// ����� ���ڵ� �� ����
				k27_wcnt++;
				// �α� ���
				System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
			}
			// ���� ���ڵ� �� ����
			k27_cnt++;
		}
		// BufferedReader�� BufferedWriter ��ü �ݱ�
		k27_br.close();
		k27_bw1.close();

		// �α� ���
		System.out.printf("Program End [%d] [%d] records\n", k27_cnt, k27_wcnt);
	}
}
