package java_intense;

import java.io.BufferedReader;  // BufferedReader Ŭ���� ����Ʈ
import java.io.File;  // File Ŭ���� ����Ʈ
import java.io.FileReader;  // FileReader Ŭ���� ����Ʈ
import java.io.IOException;  // IOException Ŭ���� ����Ʈ

public class L07 {
	public static void main(String[] args) throws IOException {
		// ���� ��ü ����
		File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
		// ���� �б� ���� BufferedReader ��ü ����
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
		// ���ڿ��� ������ ����
		String k27_readtxt;
		// ���� �� ī��Ʈ ����
		int k27_LineCnt = 0;
		// ���� ���ڿ��� ������ ����
		StringBuffer k27_s = new StringBuffer();
		
		// ������ ������ �б�
		while (true) {
			// ���ڿ��� ������ �迭
			char[] k27_ch = new char[1000];
			// ���ڿ� �б�
			int k27_n = k27_br.read(k27_ch);
			// ���� ���� ������ ��� while���� ��������
			if (k27_n == -1) {
				break;
			}
			// ���� ���ڿ��� �ϳ��� ó��
			for (char k27_c : k27_ch) {
				// ���� ������ ��� ���ڿ��� ����ϰ� ���۸� �ʱ�ȭ
				if (k27_c == '\n') {
					System.out.printf("[%s]***\n", k27_s.toString());
					k27_s.delete(0, k27_s.length());
				} else {
					// ���� ���ڰ� �ƴ� ��� ���ۿ� ���� �߰�
					k27_s.append(k27_c);
				}
			}
			// ���� �� ����
			k27_LineCnt++;
		}
		// ���������� ���� ���ڿ� ���
		System.out.printf("[%s]***\n", k27_s.toString());
		// BufferedReader �ݱ�
		k27_br.close();
	}
}
